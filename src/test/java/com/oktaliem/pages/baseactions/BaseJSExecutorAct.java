package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.IJSExecutorActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public class BaseJSExecutorAct extends BaseMouseKeyboardAct implements IJSExecutorActions {

    public BaseJSExecutorAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        log.info("Open New Tab");
    }

    @Override
    public void handleJavascriptPopUp(String info) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            if (alert.getText().equals(info)) {
                alert.accept();
            } else {
                alert.dismiss();
            }
        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("window.confirm = function() { return true; }");
//            ((JavascriptExecutor) driver).executeScript("window.alert = function() { return true; }");
//            ((JavascriptExecutor) driver).executeScript("window.prompt = function() { return true; }");
        }
        log.info("accepting javascript Pop Up");
    }


    @Override
    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "window.scrollTo(0,document.body.scrollHeight);";
        jsExecutor.executeScript(query);
        log.info("Scroll to the buttom page");
    }

    @Override
    public void scrollToTopPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "window.scrollTo(0,-document.body.scrollHeight);";
        jsExecutor.executeScript(query);
        log.info("Scroll to the top page");
    }

    @Override
    public void scrollUntilViewElement(By el) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(el);
        String query = "arguments[0].scrollIntoView(true);";
        jsExecutor.executeScript(query, element);
        log.info("Scroll until element: " + element + " is displayed");
    }

    @Override
    public void scrollUntilViewElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "arguments[0].scrollIntoView(true);";
        jsExecutor.executeScript(query, element);
        log.info("Scroll until element: " + element + " is displayed");
    }


    @Override
    public void refreshPageViaJsExecutor() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("history.go(0)");
        //or
        jsExecutor.executeScript("location.reload();");
        log.info("refresh Page Via JavaScriptExecutor");
    }

    @Override
    public Object executeViaJsExecutor(String javascript) {
        log.info("execute javascript: " + javascript);
        return ((JavascriptExecutor) driver).executeScript(javascript);
    }

    @Override
    public WebElement findElementByJSExecutor(String by, String element, int index) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement el;
        switch (by) {
            case "id":
                el = (WebElement) jsExecutor.executeScript("return document.getElementById('" + element + "')");
                log.info("return document.getElementById('" + element + "')" + " Succeed");
                break;
            case "tagName":
                el = (WebElement) jsExecutor.executeScript("return document.getElementsByTagName('" + element + "')" +
                        "[" + index + "]");
                log.info("return document.getElementBysTagName('" + element + "')[" + index + "]" + " Succeed");
                break;
            case "class":
                el = (WebElement) jsExecutor.executeScript("return document.getElementsByClassName('" + element + "')" +
                        "[" + index + "]");
                log.info("return document.getElementsByClassName('" + element + "')[" + index + "]" + " Succeed");
                break;
            case "name":
                el = (WebElement) jsExecutor.executeScript("return document.getElementsByName('" + element + "')" +
                        "[" + index + "]");
                log.info("return document.getElementsByName('" + element + "')[" + index + "]" + " Succeed");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + element);
        }
        return el;
    }

    @Override
    public String getTextElementViaJSExecutor(String by, String element, int index) {
        WebElement el = findElementByJSExecutor(by, element, index);
        String text = el.getText();
        log.info("get text By: " + by + "element: " + element + " with value " + text);
        return text;
    }

    @Override
    public String getAttributeViaJsExecutor(String by, String element, int index, String attribute) {
        WebElement el = findElementByJSExecutor(by, element, index);
        String text = el.getAttribute(attribute);
        log.info("get attribute " + attribute + " By: " + by + " element: " + element + " with value " + text);
        return text;
    }

    @Override
    public String getURLByJsExecutor() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String text = jsExecutor.executeScript("return document.URL;").toString();
        log.info("get url " + text);
        return text;
    }

    @Override
    public void navigateViaJsExecutor(String url) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
        log.info("navigate via JSExecutor to " + url);
    }

    @Override
    public void highlightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }


    @Override
    public void inputTextByJsExecutor(WebElement element, String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='" + text + "'", element);
        log.info("input text in " + element + " with value " + text);
    }

    @Override
    public void clickElementViaJsExecutor(WebElement element) {
        log.warn("Element is not clickable, try to click with JSExecutor");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
        log.info("click on " + element + " via JSExecutor succeed");
    }

    @Override
    public void setAttributeByJsExecutor(String locatorId, String elementName, String attribute, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (locatorId) {
            case "id":
                js.executeScript("document.getElementById('" + elementName + "').setAttribute('" + attribute + "', '" + value + "')");
                log.info("document.getElementById('" + elementName + "').setAttribute('" + attribute + "', '" + value + "')");
                break;
            case "tagName":
                js.executeScript("document.getElementsByTagName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                log.info("document.getElementsByTagName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                break;
            case "class":
                js.executeScript("document.getElementsByClassName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                log.info("document.getElementsByClassName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                break;
            case "name":
                js.executeScript("document.getElementsByName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                log.info("document.getElementsByName('" + elementName + "')[0].setAttribute('" + attribute + "', '" + value + "')");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + elementName);
        }
    }

    @Override
    public void deleteElementWithXpath(String xpath) {
        String js = "var elements = document.evaluate(\"" + xpath + "\",document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);\n" +
                "for (var i = 0; i < elements.snapshotLength; i++) {\n" +
                "    var element = elements.snapshotItem(i);\n" +
                "    element.parentNode.removeChild(element);\n" +
                "}";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(js);
    }

    @Override
    public void clickViaJsForXpath(String xpath) {
        String js = "var elements = document.evaluate(\"" + xpath + "\",document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);\n" +
                "var length = elements.snapshotLength;\n" +
                "if(length == 0) null.click();\n" +
                "for (var i = 0; i < length; i++) {\n" +
                "   elements.snapshotItem(i).click();\n" +
                "}";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(js);
    }
}
