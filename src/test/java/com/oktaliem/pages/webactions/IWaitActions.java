package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Author : Okta Liem
 */
public interface IWaitActions {

    void wait(int milliseconds);
    void waitWithJSExecutor(int milliseconds);
    void robotWaitFor(int milliseconds) throws AWTException;
    void waitUntilPageLoaded(int inSeconds);

    void fluentWait(By by, int timeOut, int polling);
    void waitUntilLocatorIsVisible(By by, int insSeconds);
    void waitUntilLocatorIsClickAble(By by, int insSeconds);


    void fluentWait(WebElement element, int timeOut, int polling);
    void waitForElementActionable(WebElement element, int inSeconds);
    void waitUntilLocatorIsVisible(WebElement element, int insSeconds);
    void waitUntilTextIsPresentInLocator(WebElement element, String text);
    void waitUntilLocatorIsInvisible(WebElement element, int inSeconds);
    void waitUntilLocatorIsClickAble(WebElement element, int insSeconds);
}
