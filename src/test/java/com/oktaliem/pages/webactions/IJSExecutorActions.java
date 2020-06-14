package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IJSExecutorActions {

    void clickElementViaJsExecutor(WebElement element);
    void inputTextByJsExecutor(WebElement element, String text);
    void scrollToBottomPage();
    void scrollToTopPage();
    void scrollUntilViewElement(By el);
    void scrollUntilViewElement(WebElement element);
    void refreshPageViaJsExecutor();
    void handleJavascriptPopUp(String info);
    void openNewTab();
    Object executeViaJsExecutor(String javascript);
    WebElement findElementByJSExecutor(String by,String element, int index);
    String getTextElementViaJSExecutor(String by,String element, int index);
    String getAttributeViaJsExecutor(String by, String element, int index, String attribute);
    String getURLByJsExecutor();
    void navigateViaJsExecutor(String url);
    void highlightElement (WebElement element);
    void setAttributeByJsExecutor(String locatorId, String elementName, String attribute, String value);
}
