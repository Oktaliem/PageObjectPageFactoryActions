package com.oktaliem.pages.baseactions;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.oktaliem.pages.webactions.IScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BaseScreenshot implements IScreenshot {
    public WebDriver driver;
    public static Logger log = Logger.getLogger("Library Test");

    public BaseScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void takeScreenshotWithAshot(String fileName) throws IOException {
        Screenshot result = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies
                        .viewportPasting(5000))
                .takeScreenshot(driver);
        ImageIO.write(result.getImage(), "PNG", new File(fileName));
        log.info("Take Screenshot with Ashot and Saved");

    }

    @Override
    public void takeScreenshotWithShutterbug(String fileName) throws IOException {
        Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 5000, true)
                .withName(fileName).save();
        log.info("Take Screenshot with Shutterbug and Saved");
    }

    @Override
    public void checkIfImagesAreIdentical(String base, String actual, String result) throws IOException {
        BufferedImage expImage = ImageIO.read(new File(System.getProperty("user.dir") + base));
        BufferedImage actImage = ImageIO.read(new File(System.getProperty("user.dir") + "/screenshots/" + actual + ".png"));
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actImage, expImage);
        if (diff.hasDiff() == true) {
            BufferedImage markedImage = diff.getMarkedImage();
            ImageIO.write(markedImage, "PNG", new File(System.getProperty("user.dir") + result));
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(diff.hasDiff(), "Checking that images are identical,");
        softAssert.assertAll();
        log.info("Checking Images are identical");
    }

    @Override
    public void checkIfImagesShouldNotIdentical(String base, String actual, String result) throws IOException {
        BufferedImage expImage = ImageIO.read(new File(System.getProperty("user.dir") + base));
        BufferedImage actImage = ImageIO.read(new File(System.getProperty("user.dir") + actual));
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actImage, expImage);
        if (diff.hasDiff() == false) {
            BufferedImage markedImage = diff.getMarkedImage();
            ImageIO.write(markedImage, "PNG", new File(System.getProperty("user.dir") + result));
        }
        Assert.assertTrue(diff.hasDiff(), "Checking that images are not identical,");
        log.info("Checking Images should not identical");

    }

    @Override
    public void takeScreenShot(String fileName) throws IOException {
        String screenShotPath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File filePath = new File(screenShotPath);
        FileUtils.copyFile(source, filePath);
        log.info("Take screenshot and saved to: " + screenShotPath);
    }

    @Override
    public void takeElementScreenShotWithShutterbug(WebElement element, String image){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Shutterbug.shootElement(driver, element).withName(image).save();
        log.info("Take element screenshot: "+element+" with Shutterbug");
    }


}
