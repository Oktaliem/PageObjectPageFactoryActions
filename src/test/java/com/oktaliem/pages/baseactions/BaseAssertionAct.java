package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IAssertionActions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Override
    public void checkIfTextIsNotExpected(By el, String expected) {
        String element = driver.findElement(el).getText();
        Assert.assertNotEquals(element, expected);
        log.info("PASSED - Text is not expected, " + "expected: " + expected + " and actual: " + element);
    }

    @Override
    public void checkIfTextIsNotExpected(WebElement element, String expected) {
        String el = element.getText();
        Assert.assertNotEquals(el, expected);
        log.info("PASSED - Text is not expected, " + "expected: " + expected + " and actual: " + el);
    }

    @Override
    public boolean checkIfElementIsVisible(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(inSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info(element + " is visible");
            return true;
        } catch (Exception e) {
            log.info(element + " is not visible");
            return false;
        }
    }

    @Override
    public boolean checkIfElementIsPresent(By by, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(inSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            log.info(by + " is present");
            return true;
        } catch (Exception e) {
            log.info(by + " is not present");
            return false;
        }
    }

    @Override
    public void checkIfElementIsNotDisplayed(By by) {
        WebElement hidden = driver. findElement(by);
        Assertions.assertThat(hidden.isDisplayed()).isFalse();
    }

    @Override
    public boolean checkIfElementIsInvisible(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(inSeconds));
            wait.until(ExpectedConditions.invisibilityOf(element));
            log.info(element + " is invisible");
            return true;
        } catch (Exception e) {
            log.info(element + " is not invisible");
            return false;
        }
    }

    @Override
    public boolean checkIfElementIsClickAble(WebElement element, int inSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(inSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info(element + " is clickable");
            return true;
        } catch (Exception e) {
            log.info(element + " is not clickable");
            return false;
        }
    }

    @Override
    public void checkIfTextIsNotInTheListOfElements(List<WebElement> elements, String text) {
        for (WebElement btn : elements) {
            System.out.println(btn.getText());
            if (text.trim().equals(btn.getText().trim())) {
                Assert.fail("dashboard page: " + text + " should not be in the dashboard page list/button");
                break;
            }
        }
    }

    @Override
    public void checkIfElementIsNotDisplayed(WebElement element) {
        Assertions.assertThat(element.isDisplayed()).isFalse();
    }

    @Override
    public void checkAttributeIsEqualTo(WebElement element, String attribute, String value) {
        assertThat(element.getAttribute(attribute)).isEqualTo(value);
    }

    @Override
    public void checkIfElementIsSelected(WebElement element) {
        assertThat(element.isSelected()).isTrue();
    }

    @Override
    public void checkAttributeIsEqualTo(By by, String attribute, String value) {
        WebElement element = driver.findElement(by);
        assertThat(element.getAttribute(attribute)).isEqualTo(value);
    }

    @Override
    public void checkIfElementIsSelected(By by) {
        WebElement element = driver.findElement(by);
        assertThat(element.isSelected()).isTrue();
    }

    @Override
    public void checkIfElementIsNotSelected(WebElement element) {
        assertThat(element.isSelected()).isFalse();
    }

    @Override
    public void checkIfElementIsNotSelected(By by) {
        WebElement element = driver.findElement(by);
        assertThat(element.isSelected()).isFalse();
    }

}
