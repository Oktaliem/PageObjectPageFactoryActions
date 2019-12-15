package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IAssertionActions {

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);
    Boolean checkIfTextIsContains(WebElement element, String partialText);

    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
    Boolean checkIfTextIsContains(By el, String partialText);
}
