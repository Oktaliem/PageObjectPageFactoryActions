package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.List;

/**
 * Author : Okta Liem
 */
public class BaseElementAct extends BaseJSExecutorAct implements IElementActions {

    public BaseElementAct(WebDriver driver) {
        super(driver);
    }

    /**
     * Pure Page Object for Page Actions
     */

    @Override
    public void clickOn(By el) {
        WebElement element = driver.findElement(el);
        waitUntilLocatorIsVisible(element, 4);
        try {
            element.click();
            log.info("User clicks On Element: " + element + " succeed");
        } catch (ElementClickInterceptedException e) {
            clickElementViaJsExecutor(element);
        }
    }

    @Override
    public void inputTextBox(By el, String value) {
        WebElement element = driver.findElement(el);
        waitUntilLocatorIsVisible(element, 4);
        element.clear();
        element.sendKeys(value);
        log.info("User inputs field with element: " + el + " and value " + value + " succeed");
    }

    @Override
    public String getTextFromElement(By el) {
        String text = driver.findElement(el).getText();
        log.info("Get Text with value: " + text + " succeed");
        return text;
    }


    @Override
    public void selectOnDropDownListByText(By el, String text) {
        try {
            WebElement element = driver.findElement(el);
            waitUntilLocatorIsVisible(element, 4);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            log.info("Select Drop down List Element by visible text : " + element + " succeed");
        } catch (UnexpectedTagNameException e) {
            List<WebElement> elements = driver.findElements(el);
            for (WebElement element : elements) {
                if (element.getText().trim().equals(text.trim())) {
                    clickOn(element);
                    log.info("Select Drop down List Element by visible text : " + text + " succeed");
                    break;
                }
            }
        }
    }

    @Override
    public void selectOnDropDownListByValue(By el, String value) {
        WebElement element = driver.findElement(el);
        waitUntilLocatorIsVisible(element, 4);
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element + " succeed");
    }

    @Override
    public void selectOnRadioButtonByText(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getText().equals(text)) {
                clickOn(element);
                log.info("Select radio button by text: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public void selectOnRadioButtonByValue(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by value: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public void selectCheckBox(By el, boolean status, int index) {
        WebElement element = driver.findElements(el).get(index);
        waitUntilLocatorIsVisible(element, 4);
        if (status) {
            if (element.isSelected()) {
                clickOn(element);
            } else {
                log.info("check box is disabled by default");
            }
        }
        if (!status) {
            if (element.isSelected()) {
                log.info("check box is already enabled");
            } else {
                clickOn(element);
            }
        }
    }

    @Override
    public void uploadFile(By el, String fileName) {
        WebElement element = driver.findElement(el);
        waitUntilLocatorIsVisible(element, 4);
        element.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        log.info("Choose file name: " + fileName + " succeed");
    }

    @Override
    public void clickBySortingTextElement(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getText().equals(text)) {
                clickOn(element);
                log.info("Click Element by sorting text: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public WebElement findElementByDoubleChain(By el1, By el2) {
        WebElement els = driver.findElement(el1).findElement(el2);
        log.info("Find element by: " + el1 + " and " + el2 + "succeed");
        return els;
    }

    @Override
    public String getDropDownListValueDisplayed(By el) {
        WebElement element = driver.findElement(el);
        waitUntilLocatorIsVisible(element, 10);
        Select select = new Select(element);
        String value = select.getFirstSelectedOption().getText();
        log.info("Drop down list text displayed : " + value);
        return value;
    }


    /**
     * Page Factory for Page Actions
     */
    @Override
    public void clickOn(WebElement element) {
        waitUntilLocatorIsVisible(element, 4);
        try {
            element.click();
            log.info("User clicks On Element: " + element + " succeed");
        } catch (ElementClickInterceptedException e) {
            clickElementViaJsExecutor(element);
        }
    }

    @Override
    public void inputTextBox(WebElement element, String value) {
        waitUntilLocatorIsVisible(element, 4);
        element.clear();
        element.sendKeys(value);
        log.info("User inputs field with element: " + element + " and value " + value + " succeed");
    }

    @Override
    public String getTextFromElement(WebElement element) {
        waitUntilLocatorIsVisible(element, 4);
        String text = element.getText();
        log.info("Get Text with value: " + text + " succeed");
        return text;

    }

    @Override
    public void selectOnDropDownListByText(WebElement element, String text) {
        waitUntilLocatorIsVisible(element, 4);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Select Drop down List Element by visible text : " + element + " succeed");
    }

    @Override
    public void selectOnDropDownListByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select Drop down List Element by visible text : " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public void selectOnDropDownListByValue(WebElement element, String value) {
        waitUntilLocatorIsVisible(element, 4);
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element + " succeed");
    }

    @Override
    public void selectOnRadioButtonByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            System.out.println("Text: " + element.getText());
            if (element.getText().trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by text: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public void selectOnRadioButtonByValue(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by value: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public void selectCheckBox(WebElement element, boolean status) {
        //only can be used if DOM contains type="checkbox"
        waitUntilLocatorIsVisible(element, 4);
        if (status) {
            if (!element.isSelected()) {
                clickOn(element);
                log.info("check box was unchecked, now is checked");
            } else {
                log.info("check box is already checked");
            }
        }
        if (!status) {
            if (element.isSelected()) {
                clickOn(element);
            } else {
                log.info("check box is already disable");
            }
        }
    }

    @Override
    public void uploadFile(WebElement element, String fileName) {
        waitUntilLocatorIsVisible(element, 4);
        try {
            if (driver instanceof RemoteWebDriver) {
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            }
        } catch (WebDriverException ignored) {
        }
        element.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        log.info("Choose file name: " + fileName + " succeed");
    }



    @Override
    public void clickBySortingTextElement(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                scrollUntilViewElement(element);
                clickOn(element);
                log.info("Click Element by sorting text: " + text + " succeed");
                break;
            }
        }
    }

    @Override
    public String getDropDownListValueDisplayed(WebElement element) {
        waitUntilLocatorIsVisible(element, 10);
        Select select = new Select(element);
        String value = select.getFirstSelectedOption().getText();
        log.info("Drop down list text displayed : " + value);
        return value;
    }


}
