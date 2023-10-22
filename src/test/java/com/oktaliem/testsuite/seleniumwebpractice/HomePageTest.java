package com.oktaliem.testsuite.seleniumwebpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.oktaliem.constants.Url.WEB_PRACTICE_INDEX;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest {

    WebDriver driver;

    @Test
    public void chromeSetUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String title = openHomePageURL(driver);
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @Test
    public void edgeSetUpTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        String title = openHomePageURL(driver);
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @Test
    public void fireFoxSetUpTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        String title = openHomePageURL(driver);
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @Test
    public void safariSetUpTest() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        String title = openHomePageURL(driver);
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @Step
    private String openHomePageURL(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(WEB_PRACTICE_INDEX);
        return driver.getTitle();
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
