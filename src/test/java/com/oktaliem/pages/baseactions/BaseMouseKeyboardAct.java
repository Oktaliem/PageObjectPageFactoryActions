package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IMouseAndKeyboardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author : Okta Liem
 */
public class BaseMouseKeyboardAct extends BaseRobotAct implements IMouseAndKeyboardActions {

    public BaseMouseKeyboardAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void doubleClick(By el) {
        WebElement element = driver.findElement(el);
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
        log.info("Double Click element: " + element);
    }

    @Override
    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
        log.info("Double Click element: " + element);
    }

    @Override
    public void moveMousePointerTo(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        log.info("Move your mouse pointer to element: " + element);
    }

    @Override
    public void moveMousePointerTo(By el) {
        WebElement element = driver.findElement(el);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        log.info("Move your mouse pointer to element: " + el);
    }

    @Override
    public void dragFromAndDropTo(By from, By to) {
        WebElement dragFrom = driver.findElement(from);
        WebElement target = driver.findElement(to);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(dragFrom)
                .moveToElement(target)
                .release(target)
                .build();
        dragAndDrop.perform();
        log.info("Drag from :" + from + " then drop to: " + to);
    }

    @Override
    public void dragFromAndDropTo(WebElement from, WebElement to) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(from)
                .moveToElement(to)
                .release(to)
                .build();
        dragAndDrop.perform();
        log.info("Drag from :" + from + " then drop to: " + to);
    }

    @Override
    public void inputTextAndEnter(By el, String value) {
        WebElement element = driver.findElement(el);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
        log.info("input by Element:" + el + " and Enter via Keyboard");
    }

    @Override
    public void inputTextAndEnter(WebElement element, String value) {
        element.clear();
        element.sendKeys(value, Keys.ENTER);
        log.info("input by Element:" + element + " and Enter via Keyboard");
    }

    @Override
    public void inputTextAndTab(By el, String value) {
        WebElement element = driver.findElement(el);
        element.clear();
        element.sendKeys(value, Keys.TAB);
        log.info("input by Element:" + el + " and Tab via Keyboard");
    }

    @Override
    public void inputTextAndTab(WebElement element, String value) {
        element.clear();
        element.sendKeys(value, Keys.TAB);
        log.info("input by Element:" + element + " and Tab via Keyboard");
    }

    @Override
    public void moveMouseAndClick(WebElement move, WebElement target) {
        Actions action = new Actions(driver);
        action.moveToElement(move).perform();
        action.moveToElement(target).click().perform();
        log.info("Move your mouse pointer to element: " + move + " And Click: " + target);
    }

    @Override
    public void moveMouseAndClick(By move, By target) {
        WebElement el1 = driver.findElement(move);
        WebElement el2 = driver.findElement(target);
        Actions action = new Actions(driver);
        action.moveToElement(el1).perform();
        action.moveToElement(el2).click().perform();
        log.info("Move your mouse pointer to element: " + el1 + " And Click: " + el2);
    }

    @Override
    public void selectAutoCompleteDropDownList(WebElement element, String text, int xOffset, int yOffset) {
        log.info("Try to Move to element: " + element.getLocation() + " and Click then input with value: " + text);
        log.info("And move to xOffset: " + xOffset + " and yOffset: " + yOffset + " then click");
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .click()
                .sendKeys(text)
                .moveByOffset(xOffset, yOffset)
                .click()
                .build()
                .perform();
        log.info("Autocomplete succeed");
    }


    @Override
    public void performTab() {
        Actions builder = new Actions(driver);
        Action enter = builder
                .sendKeys(Keys.TAB)
                .build();
        enter.perform();
        log.info("Click on Keyboard button: Tab");
    }

    @Override
    public void performEnter() {
        Actions builder = new Actions(driver);
        Action enter = builder
                .sendKeys(Keys.ENTER)
                .build();
        enter.perform();
        log.info("Click on Keyboard button: Enter");
    }

    @Override
    public void performDelete() {
        Actions builder = new Actions(driver);
        Action enter = builder
                .sendKeys(Keys.DELETE)
                .build();
        enter.perform();
        log.info("Click on Keyboard button: Delete");
    }

    @Override
    public void controlPlus(WebElement element, String keyboard) {
        element.sendKeys(Keys.CONTROL, keyboard);
    }


    @Override
    public void clickViaAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
        log.info("Click element via Action: " + element );
    }


}
