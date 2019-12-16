package com.oktaliem.testsuit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Author : Okta Liem
 */
public class BaseTest {
    private WebDriver driver;
    public User user;
    public static String screenShotPath;

    @BeforeMethod
    public void initialization(Method method) {
        try {
            if (System.getProperty("browser").equals("zalenium")) {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setCapability("name", method.getName());
                driver = new RemoteWebDriver(new URL(System.getProperty("grid_url")), capability);
            }
            if (System.getProperty("browser").equals("bonigarcia")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } catch (Exception e) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver-mac");
            System.out.println(System.getProperty("user.dir") + "/drivers/chromedriver-mac");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        user = new User(driver);
        System.out.println("I'm on testing test case no: " + method.getName());
    }

    @AfterMethod
    public void teardown(ITestResult result, Method method) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("TEST FAILED");
            screenShotPath = System.getProperty("user.dir") + "/Screenshots/" + "SepFailed_" + method.getName() + ".png";
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File filePath = new File(screenShotPath);
            FileUtils.copyFile(source, filePath);
        }
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("TEST SUCCEED");
        }
        driver.quit();
    }

}
