package com.oktaliem.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import com.oktaliem.pages.baseactions.BaseElementAct;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage extends BaseElementAct {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private By menuBtn = By.className("full");
    private By setting = By.className("dropdown-item");

    @FindBy(className = "dropdown-item")
    private List<WebElement> Setting;

    @Step("Open Drop Down Menu")
    public void openDropDownMenu(){
        clickOn(menuBtn);
    }

    @Step("Open Setting Page - Page Factory")
    public void goToSettingPagePF(){
        selectOnDropDownListByText(Setting,"Settings");
    }

    @Step("Open Setting Page - Page Object")
    public void goToSettingPagePO() {
        selectOnDropDownListByText(setting,"Settings");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] performPageScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Actual image", type = "image/png")
    protected static byte[] getSeleniumElementScreenShot(WebElement el, String image) throws IOException, InterruptedException {
        TimeUnit.MILLISECONDS.sleep(2000);
        File f = el.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "/screenshots/" + image + ".png"));
        BufferedImage getImage = ImageIO.read(new File(System.getProperty("user.dir") + "/screenshots/" + image + ".png"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(getImage, "png", output);
        return output.toByteArray();
    }

}
