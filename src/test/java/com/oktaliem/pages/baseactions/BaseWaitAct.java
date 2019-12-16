package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IWaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Author : Okta Liem
 */
public class BaseWaitAct extends BaseAssertionAct implements IWaitActions {

    public BaseWaitAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean checkIfElementIsVisible(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean checkIfElementIsPresent(By by, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean checkIfElementIsInvisible(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean checkIfElementIsClickAble(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
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
    public void waitForElementActionable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element),
                ExpectedConditions.presenceOfElementLocated((By) element),
                ExpectedConditions.elementToBeSelected(element)));
    }


    @Override
    public void waitWithJavascriptExecutor(int miliseconds) {
        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length - 1]," + miliseconds + ");");
        String time = String.valueOf(System.currentTimeMillis() - start);
        log.info("Elapsed time: " + time);
    }


    @Override
    public void robotWaitFor(int miliseconds) throws AWTException {
        Robot robot = new Robot();
        robot.delay(miliseconds);
        log.info("Wait with Robot class for "+miliseconds+" miliseconds");
    }


//    public void waitWithFluentWait(){
//        FluentWait wait = new FluentWait(driver);
//        //Specify the timout of the wait
//        wait.withTimeout(5000, TimeUnit.MILLISECONDS);
//        //Sepcify polling time
//        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//        //Specify what exceptions to ignore
//        wait.ignoring(NoSuchElementException.class);
//
//        //This is how we specify the condition to wait on.
//        //This is what we will explore more in this chapter
//        wait.until(ExpectedConditions.visibilityOf());
//    }

    @Override
    public WebElement fluentWait(By by, int timeOut, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeOut, TimeUnit.MILLISECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> driver.findElement(by));
        return  element;
    }

}
