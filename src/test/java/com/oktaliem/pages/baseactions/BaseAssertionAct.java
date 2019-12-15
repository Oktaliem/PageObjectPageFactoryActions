package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IAssertionActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Author : Okta Liem
 */
public class BaseAssertionAct extends BaseGeneralAct implements IAssertionActions {

    public BaseAssertionAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkIfTextIsExpected(WebElement element, String expected) {
        Assert.assertEquals(element.getText(), expected);
        log.info("Text is expected: " + expected);
    }

    @Override
    public void checkIfTextIsExpected(By el, String expected) {
        Assert.assertEquals(driver.findElement(el).getText(), expected);
        log.info("Text is expected: " + expected);
    }

    @Override
    public Boolean checkIfTextIsContains(By el, String partialText) {
        String text = driver.findElement(el).getText();
        if (text.contains(partialText)) {
            log.info("Check if: " + text + " contains " + partialText + " Return TRUE");
            return true;
        } else {
            log.info("Check if: " + text + " doesn't contains " + partialText + " Return FALSE");
            return false;
        }
    }

    @Override
    public Boolean checkIfTextIsContains(WebElement element, String partialText) {
        String text = element.getText();
        if (text.contains(partialText)) {
            log.info("Check if: " + text + " contains " + partialText + " Return TRUE");
            return true;
        } else {
            log.info("Check if: " + text + " doesn't contains " + partialText + " Return FALSE");
            return false;
        }
    }

}
