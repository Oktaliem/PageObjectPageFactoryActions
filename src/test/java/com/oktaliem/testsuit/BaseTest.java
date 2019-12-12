package com.oktaliem.testsuit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Author : Okta Liem
 */
public class BaseTest {
    private WebDriver driver;
    public User user;


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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        user = new User(driver);
        System.out.println("I'm on test: " + method.getName());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
