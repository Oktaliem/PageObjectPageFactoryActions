package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Author : Okta Liem
 */
public interface IWaitActions {

    void wait(int miliseconds);
    void waitWithJSExecutor(int miliseconds);
    void robotWaitFor(int miliseconds) throws AWTException;
    boolean checkIfElementIsVisible(WebElement element, int inSeconds);
    boolean checkIfElementIsPresent(By by, int inSeconds);
    boolean checkIfElementIsInvisible(WebElement element, int inSeconds);
    boolean checkIfElementIsClickAble(WebElement element, int inSeconds);
    void waitForElementActionable(WebElement element, int inSeconds);
    WebElement fluentWait(By by, int timeOut, int polling);
    void waitUntilLocatorIsVisible(WebElement element, int insSeconds);
    void waitUntilTextIsPresentInLocator(WebElement element, String text);
    void waitUntilLocatorIsInvisible(WebElement element, int inSeconds);
    void waitUntilPageLoaded(int inSeconds);
}
