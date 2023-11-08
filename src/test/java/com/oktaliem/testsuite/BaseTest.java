package com.oktaliem.testsuite;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Author : Okta Liem
 */
public class BaseTest {
    private WebDriver driver;
    public User userIsOn;
    public static String screenShotPath;
    public static Logger log = Logger.getLogger("Test Preparation");

    @BeforeMethod
    public void initialization(Method method) throws MalformedURLException {
        String runner = "default"; //System.getProperty("browser")
        switch (runner) {
            case "grid-chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                this.driver = new RemoteWebDriver(new URL("http://192.168.68.78:4444/"), options);
            case "grid-firefox":
                break;
            default:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
                ngWebDriver.waitForAngularRequestsToFinish();
        }
        driver.manage().window().maximize();
        userIsOn = new User(driver);
        log.info("I'm on testing test case no: " + method.getName());
    }

    @AfterMethod
    public void teardown(ITestResult result, Method method) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            log.info("TEST FAILED");
            screenShotPath = System.getProperty("user.dir") + "/Screenshots/" + "SepFailed_" + method.getName() + ".png";
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File filePath = new File(screenShotPath);
            FileUtils.copyFile(source, filePath);
        }
        if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("TEST SUCCEED");
        }
        driver.quit();
    }

}
