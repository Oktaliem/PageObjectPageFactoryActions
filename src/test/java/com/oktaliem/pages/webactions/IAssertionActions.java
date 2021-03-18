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

    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
    Boolean checkIfTextIsContains(By el, String partialText);
    void checkIfTextIsNotExpected(By el, String expected);
    boolean checkIfElementIsPresent(By by, int inSeconds);

}
