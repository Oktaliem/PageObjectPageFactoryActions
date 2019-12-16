package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IJSExecutorActions {

    void clickElementViaJSExecutor(WebElement element);
    void inputTextByJSExecutor(WebElement element, String text);
    void scrollToBottomPage();
    void scrollToTopPage();
    void scrollUntilViewElement(By el);
    void scrollUntilViewElement(WebElement element);
    void refreshPageViaJSExecutor();
    void handleJavascriptPopUp(String info);
    void openNewTab();
    Object executeViaJSExecutor(String javascript);
    WebElement findElementByJSExecutor(String by,String element, int index);
    String getTextElementViaJSExecutor(String by,String element, int index);
    String getAttributeViaJSExecutor(String by,String element, int index, String attribute);
    String getURLByJSExecutor();
    void navigateViaJSExecutor(String url);
    void highlightElement (WebElement element);
}
