package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IWaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Author : Okta Liem
 */
public class BaseWaitAct extends BaseAssertionAct implements IWaitActions {

    public BaseWaitAct(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait actions
     */
    @Override
    public void wait(int miliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("User waits for " + miliseconds + " milliseconds");
    }

    @Override
    public void waitForElementActionable(WebElement element, int inSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, inSeconds);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element),
                ExpectedConditions.elementToBeSelected(element)));
        log.info(element + " is visible, clickable and selected");
    }


    @Override
    public void waitWithJSExecutor(int milliseconds) {
        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length - 1]," + milliseconds + ");");
        String time = String.valueOf(System.currentTimeMillis() - start);
        log.info("Elapsed time: " + time);
    }


    @Override
    public void robotWaitFor(int milliseconds) throws AWTException {
        Robot robot = new Robot();
        robot.delay(milliseconds);
        log.info("Wait with Robot class for " + milliseconds + " milliseconds");
    }

    @Override
    public void fluentWait(By by, int timeOut, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeOut, TimeUnit.MILLISECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> driver.findElement(by));
        log.info("fluent wait is success waiting for " + element);
    }

    @Override
    public void fluentWait(WebElement element, int timeOut, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeOut, TimeUnit.MILLISECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement el = wait.until(driver -> element);
        log.info("fluent wait is success waiting for " + el);
    }

    @Override
    public void waitUntilLocatorIsVisible(WebElement element, int insSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, insSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("wait until element: " + element + " is visible");
    }

    @Override
    public void waitUntilLocatorIsVisible(By by, int insSeconds) {
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, insSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("wait until element: " + element + "is visible");
    }

    @Override
    public void waitUntilLocatorIsClickAble(By by, int insSeconds) {
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, insSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("wait until element: " + element + "is visible");
    }


    @Override
    public void waitUntilLocatorIsClickAble(WebElement element, int insSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, insSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("wait until element: " + element + "is visible");
    }

    @Override
    public void waitUntilTextIsPresentInLocator(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        log.info("wait until text in element: " + element + " is present");
    }

    @Override
    public void waitUntilLocatorIsInvisible(WebElement element, int inSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, inSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("wait until element: " + element + " is invisible");
    }



    @Override
    public void waitUntilPageLoaded(int inSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, inSeconds);
        wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        log.info("wait until page is loaded");
    }



}
