package com.oktaliem.pages.webactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Author : Okta Liem
 */
public interface IGeneralActions {

    void refreshPage();
    void goToPreviousPage();
    void goToNextPage();
    void getHtmlSource(String fileName) throws IOException;
    void switchToSecondBrowser();
    void switchToFirstBrowser();
    String getValueWithRegex(String regex, String text);
    String getCurrentURL();
    String readFile(String filePath) throws IOException;
    void goToWeb(String url);
    void switchToFrameByIndex(int index);
    void switchToFrameByIdOrName(WebElement element);
    void switchFrameToDefaultContent();
    void switchFrameToParentFrame();
    void performKeyboardAction(Keys tab);
    void performKeyboardInputAction(String text);
}
