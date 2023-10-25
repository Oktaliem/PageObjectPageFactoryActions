package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author : Okta Liem
 */
public interface IAssertionActions {

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);
    Boolean checkIfTextIsContains(WebElement element, String partialText);
    void checkIfTextIsNotExpected(WebElement element, String expected);
    boolean checkIfElementIsVisible(WebElement element, int inSeconds);
    boolean checkIfElementIsInvisible(WebElement element, int inSeconds);
    boolean checkIfElementIsClickAble(WebElement element, int inSeconds);
    void checkIfTextIsNotInTheListOfElements(List<WebElement> elements, String text);
    void checkIfElementIsNotDisplayed(WebElement element);
    void checkAttributeIsEqualTo(WebElement element, String attribute, String value);
    void checkIfElementIsSelected(WebElement element);
    void checkIfElementIsNotSelected(WebElement element);

    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
    Boolean checkIfTextIsContains(By el, String partialText);
    void checkIfTextIsNotExpected(By el, String expected);
    boolean checkIfElementIsPresent(By by, int inSeconds);
    void checkIfElementIsNotDisplayed(By by);
    void checkAttributeIsEqualTo(By by, String attribute, String value);
    void checkIfElementIsSelected(By by);
    void checkIfElementIsNotSelected(By by);
}
