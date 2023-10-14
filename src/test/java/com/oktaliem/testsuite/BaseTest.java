package com.oktaliem.testsuite;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * Author : Okta Liem
 */
public class BaseTest {
    private WebDriver driver;
    public User userIsOn;
    public static String screenShotPath;
    public static Logger log = Logger.getLogger("Test Preparation");

    @BeforeMethod
    public void initialization(Method method) {
        try {
            if (System.getProperty("browser").equals("chromePath")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver-mac");
                log.info("I'm using Webdriver: "+System.getProperty("user.dir") + "/drivers/chromedriver-mac");
                driver = new ChromeDriver();
            }
        } catch (Exception e) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
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
