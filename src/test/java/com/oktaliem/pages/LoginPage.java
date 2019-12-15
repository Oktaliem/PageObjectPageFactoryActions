package com.oktaliem.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By userNameLogin = By.id("login");
    private By passwordLogin = By.id("password");
    private By loginButton = By.className("btn-primary");
    private By DBManage = By.className("border-right");
    private By fieldLogin = By.className("field-login");
    private By tagNameInput = By.tagName("input");

    private String userNameJS = "login";
    private String passwordJS = "password";
    private String loginBtnJS = "btn-primary";
    private String csrfToken = "csrf_token";
    private String msg = "alert-danger";
    private String tag = "input";

    @FindBy(id = "login")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "btn-primary")
    private WebElement loginBtn;

    @FindBy(className = "o_menu_brand")
    private WebElement pageHeader;

    @FindBy(className = "border-right")
    private WebElement manageDB;

    @FindBys({
            @FindBy(className = "field-login"),
            @FindBy(tagName = "input")})
    private WebElement userNameChains;

    @Step("Go to Odoo Login Page")
    public void launchTheApplication() {
        goToWeb(Path.LOGIN_PAGE_URL);
    }

    @Step
    public void inputUserName(String name){
        inputTextBox(userName, name);
    }

    @Step("Page Factory - Login")
    public void loginSamplePF() {
        inputTextBox(userName, "user@example.com");
        inputTextBox(password, "bitnami");
        clickOn(loginBtn);
    }

    @Step("Page Object - Login")
    public void loginSamplePO() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickOn(loginButton);
    }

    @Step("Landing to Discuss Page")
    public void landingToDiscussPagePF() {
        // checkIfElementIsVisible(pageHeader,10);
        // waitForElementActionable(pageHeader,10);
    }

    @Step("Get Text sample Page Factory")
    public void getTextSamplePF() {
        String text = getTextFromElement(manageDB);
        checkIfTextIsExpected(manageDB, text);
    }

    @Step("Get Text sample Page Object")
    public void getTextSamplePO() {
        String text = getTextFromElement(DBManage);
        checkIfTextIsExpected(DBManage, text);
    }

    @Step("Login with Javascript Btn")
    public void login() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickElementViaJSExecutor(loginBtn);
    }

    @Step("Login URL")
    public void getLoginPageURL() {
        getCurrentURL();
    }

    @Step("value or Regex")
    public void getCSRFToken() throws IOException {
        String text = readFile(System.getProperty("user.dir")+
                    "/src/main/resources/actualhtmltext/loginPage.txt");
        String pattern = "csrf_token: \"\\w{41}\"";
        String values = getValueWithRegex(pattern, text);
        String value = values.substring(values.length() - 42, values.length() - 1);

        //This test is intended to fail
        Assert.assertEquals(value, "01122a113f7377a85655c778b1143914eaa38884o");
        log.info("Regex Result: " + values);
        log.info("Result: " + value);
    }

    @Step("Login with Tab And Enter")
    public void loginSamplePFWithTabEnter() {
        inputTextAndTab(userName,"user@example.com");
        inputTextAndEnter(password,"bitnami");
        wait(5000);
    }

    @Step
    public void loginSamplePOWithTabAndEnter() {
        inputTextAndTab(userNameLogin,"user@example.com");
        inputTextAndEnter(passwordLogin,"bitnami");
        wait(5000);
    }

    @Step
    public void performSomeJSFindElement() {
        findElementByJSExecutor("id",userNameJS,0).sendKeys("abc");
        findElementByJSExecutor("id",passwordJS,0).sendKeys("abc");
        findElementByJSExecutor("class",loginBtnJS,0).click();
        String csrf_value = findElementByJSExecutor("tagName",tag,0).getAttribute("value");
        System.out.println("Get CSRF value by TagName: "+csrf_value);
        String csrf_value_2 = findElementByJSExecutor("name",csrfToken,0).getAttribute("value");
        System.out.println("Get CSRF value by name: "+ csrf_value_2);
        getTextElementViaJSExecutor("class",msg,0);
        getAttributeViaJSExecutor("class","border-right",0,"href");
        inputTextByJSExecutor(userName,"kucing garong");
        getURLByJSExecutor();
        navigateViaJSExecutor("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        navigateViaJSExecutor("http://localhost/web/login");

        String a = executeJavascript("return document.documentElement.innerText;").toString();
        System.out.println("return document.documentElement.innerText; " + a);
        String b = executeJavascript("return document.title; ").toString();
        System.out.println("return document.title; "+ b);
        String c = executeJavascript("return document.domain;").toString();
        System.out.println("return document.domain; "+c);

        navigateViaJSExecutor("https://www.detik.com/");
        executeJavascript("window.scrollBy(0,1500)");
        wait(1000);
        executeJavascript("window.history.back()");
        wait(2000);
        executeJavascript("window.history.forward()");
        wait(2000);
        navigateViaJSExecutor("http://localhost/web/login");

        executeJavascript("document.querySelector('.btn-primary').click()"); //To call an element with class name, use ".classname"
        executeJavascript("document.querySelector('#login').value='okta'"); //To call element by id, use "#id"
        String csrf_aja = executeJavascript("return document.querySelector('input').getAttribute('value')").toString(); //To call element by tagname, use "tagname"
        System.out.println("get csrf token: " + csrf_aja);
        executeJavascript("document.body.style.zoom = '300%';");
        wait(2000);
        executeJavascript("window.open(arguments[0])");
        String docTitle = executeJavascript("return document.title").toString();
        System.out.println("Document Title: " + docTitle);
        executeJavascript("window.scrollByPages(3)");

        wait(5000);
    }

    @Step
    public void checkIfElementContainsExpectedResult() {
        checkIfTextIsContains(manageDB,"Databas");
        wait(2000);
        checkIfTextIsContains(DBManage,"Data");
        wait(2000);
    }

    @Step
    public void performKeyboardAction(String key) {
        Actions builder = new Actions(driver);
        builder.sendKeys(key).build().perform();
        builder.release().perform();
        log.info("Keyboard Action: "+ key);
    }

    @Step
    public void highlightPasswordFieldAndSave() throws IOException {
        highlightElement(password);
        takeScreenShot("TC39");
    }

    @Step
    public void inputUserNameByChainElements() {
        findElementByDoubleChain(By.className("field-login"),By.tagName("input")).sendKeys("Akto");
        wait(2000);
        findElementByDoubleChain(fieldLogin,tagNameInput).sendKeys("qwerty");
        wait(2000);
        inputTextBox(userNameChains,"akulah");
        wait(2000);
    }
}
