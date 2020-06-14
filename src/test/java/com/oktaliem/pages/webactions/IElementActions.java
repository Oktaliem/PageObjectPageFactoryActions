package com.oktaliem.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author : Okta Liem
 */
public interface IElementActions {

    /** Web Action - Page Object **/
    void clickOn(By el);
    void inputTextBox(By el, String value);
    String getTextFromElement(By el);
    void selectOnDropDownListByText(By el, String text);
    void selectOnDropDownListByValue(By el, String value);
    void selectOnRadioButtonByText(By els, String text);
    void selectOnRadioButtonByValue(By els, String text);
    void selectCheckBox(By el, boolean status, int index);
    void uploadFile(By el, String fileName);
    WebElement findElementByDoubleChain(By el1, By el2);
    void clickBySortingTextElement(By els, String text);

    /** Web Action - Page Factory **/
    void clickOn(WebElement element);
    void inputTextBox(WebElement element, String value);
    String getTextFromElement(WebElement element);
    void selectOnDropDownListByText(WebElement element, String text);
    void selectOnDropDownListByText(List<WebElement> elements, String text);
    void selectOnDropDownListByValue(WebElement element, String value);
    void selectOnRadioButtonByText(List<WebElement> elements, String text);
    void selectOnRadioButtonByValue(List<WebElement> elements, String text);
    void selectCheckBox(WebElement element, boolean status);
    void uploadFile(WebElement element, String fileName);
    void clickBySortingTextElement(List<WebElement> elements, String text);
}
