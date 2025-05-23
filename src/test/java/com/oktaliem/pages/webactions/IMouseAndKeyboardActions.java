package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IMouseAndKeyboardActions {
    void performTab();
    void performEnter();
    void performDelete();
    void controlPlus( WebElement element, String keyboard);

    /** Keyboard & Mouse Action - Page Object */
    void doubleClick(By el);
    void moveMousePointerTo(By el);
    void dragFromAndDropTo(By from, By to);
    void inputTextAndEnter(By el, String value);
    void inputTextAndTab(By el, String value);
    void moveMouseAndClick(By move, By Target);

    /** Keyboard & Mouse Action - Page Factory */
    void doubleClick(WebElement element);
    void moveMousePointerTo(WebElement element);
    void dragFromAndDropTo(WebElement from, WebElement to);
    void inputTextAndEnter(WebElement element, String value);
    void inputTextAndTab(WebElement element, String value);
    void moveMouseAndClick(WebElement move, WebElement target);
    void selectAutoCompleteDropDownList(WebElement element, String text, int xOffset, int yOffset);
    void clickViaAction(WebElement element);
}
