package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IJSExecutorActions {

    void clickElementViaJSExecutor(WebElement element);
    void scrollToBottomPage();
    void scrollToTopPage();
    void scrollUntilViewElement(By el);
    void scrollUntilViewElement(WebElement element);
    void refreshPageViaJavaScriptExecutor();
    void handleJavascriptPopUp(String info);
    void openNewTab();
    Object executeJavascript(String javascript);
    WebElement findElementByJSExecutor(String by,String element, int index);
    String getTextElementViaJSExecutor(String by,String element, int index);

}
