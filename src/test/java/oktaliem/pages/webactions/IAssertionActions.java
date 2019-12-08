package oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface IAssertionActions {

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);


    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
}
