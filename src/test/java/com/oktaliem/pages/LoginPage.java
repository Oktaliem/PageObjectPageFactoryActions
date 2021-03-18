package com.oktaliem.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final By userNameLogin = By.id("login");
    private final By passwordLogin = By.id("password");
    private final By loginButton = By.className("btn-primary");
    private final By DBManage = By.className("border-right");
    private final By fieldLogin = By.className("field-login");
    private final By tagNameInput = By.tagName("input");
    private final By dialogBox = By.xpath("/html[1]/body[1]/ul[1]/li[6]/div[1]/button[1]");
    private final By dialog = By.xpath("/html[1]/body[1]/ul[1]/li[5]/div[1]/button[1]");

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

    String sikuliPath = System.getProperty("user.dir") + "/src/main/resources/sikuli/";
//    private static final Pattern sikuliPath = new Pattern(Main.class.getResource("login_button.png"));


    @FindBy(id = "swal2-title")
    WebElement popUpTitle;

    @Step("Go to Odoo Login Page")
    public void launchTheApplication() {
        goToWeb(Path.LOGIN_PAGE_URL);
    }

    @Step
    public void inputUserName(String name) {
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
        clickElementViaJsExecutor(loginBtn);
    }

    @Step("Login URL")
    public void getLoginPageURL() {
        getCurrentURL();
    }

    @Step("value or Regex")
    public void getCSRFToken() throws IOException {
        String text = readFile(System.getProperty("user.dir") +
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
        inputTextAndTab(userName, "user@example.com");
        inputTextAndEnter(password, "bitnami");
        wait(5000);
    }

    @Step
    public void loginSamplePOWithTabAndEnter() {
        inputTextAndTab(userNameLogin, "user@example.com");
        inputTextAndEnter(passwordLogin, "bitnami");
        wait(5000);
    }

    @Step
    public void performSomeJSFindElement() {
        String userNameJS = "login";
        findElementByJSExecutor("id", userNameJS, 0).sendKeys("abc");
        String passwordJS = "password";
        findElementByJSExecutor("id", passwordJS, 0).sendKeys("abc");
        String loginBtnJS = "btn-primary";
        findElementByJSExecutor("class", loginBtnJS, 0).click();
        String tag = "input";
        String csrf_value = findElementByJSExecutor("tagName", tag, 0).getAttribute("value");
        System.out.println("Get CSRF value by TagName: " + csrf_value);
        String csrfToken = "csrf_token";
        String csrf_value_2 = findElementByJSExecutor("name", csrfToken, 0).getAttribute("value");
        System.out.println("Get CSRF value by name: " + csrf_value_2);
        String msg = "alert-danger";
        getTextElementViaJSExecutor("class", msg, 0);
        String attribute = getAttributeViaJsExecutor("class", "border-right", 0, "href");
        System.out.println(attribute);
        inputTextByJsExecutor(userName, "kucing garong");
        String url = getURLByJsExecutor();
        System.out.println(url);
        navigateViaJsExecutor("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        navigateViaJsExecutor("http://localhost/web/login");

        String a = executeViaJsExecutor("return document.documentElement.innerText;").toString();
        System.out.println("return document.documentElement.innerText; " + a);
        String b = executeViaJsExecutor("return document.title; ").toString();
        System.out.println("return document.title; " + b);
        String c = executeViaJsExecutor("return document.domain;").toString();
        System.out.println("return document.domain; " + c);

        navigateViaJsExecutor("https://www.detik.com/");
        executeViaJsExecutor("window.scrollBy(0,1500)");
        wait(1000);
        executeViaJsExecutor("window.history.back()");
        wait(2000);
        executeViaJsExecutor("window.history.forward()");
        wait(2000);
        navigateViaJsExecutor("http://localhost/web/login");

        executeViaJsExecutor("document.querySelector('.btn-primary').click()"); //To call an element with class name, use ".classname"
        executeViaJsExecutor("document.querySelector('#login').value='okta'"); //To call element by id, use "#id"
        String csrf_aja = executeViaJsExecutor("return document.querySelector('input').getAttribute('value')").toString(); //To call element by tagname, use "tagname"
        System.out.println("get csrf token: " + csrf_aja);
        executeViaJsExecutor("document.body.style.zoom = '300%';");
        wait(2000);
        executeViaJsExecutor("window.open(arguments[0])");
        String docTitle = executeViaJsExecutor("return document.title").toString();
        System.out.println("Document Title: " + docTitle);

        executeViaJsExecutor("window.scrollByPages(3)");

        wait(5000);
    }

    @Step
    public void checkIfElementContainsExpectedResult() {
        checkIfTextIsContains(manageDB, "Databas");
        wait(2000);
        checkIfTextIsContains(DBManage, "Data");
        wait(2000);
    }

    @Step
    public void performKeyboardAction(String key) {
        Actions builder = new Actions(driver);
        builder.sendKeys(key).build().perform();
        builder.release().perform();
        log.info("Keyboard Action: " + key);
    }

    @Step
    public void highlightPasswordFieldAndSave() throws IOException {
        highlightElement(password);
        takeScreenShot("TC39");
    }

    @Step
    public void inputUserNameByChainElements() {
        findElementByDoubleChain(By.className("field-login"), By.tagName("input")).sendKeys("Akto");
        wait(2000);
        findElementByDoubleChain(fieldLogin, tagNameInput).sendKeys("qwerty");
        wait(2000);
        inputTextBox(userNameChains, "akulah");
        wait(2000);
    }

    @Step
    public void loginWithSikuli() throws FindFailed {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickOn(password);
        wait(2000);
        clickViaSikuli(sikuliPath, "login_button.png"); //test sukses tapi tapi berhasil, false positive
        wait(5000);
    }

    @Step
    public void waitingGame() throws AWTException {
        Assert.assertTrue(checkIfElementIsVisible(userName, 3));
        Assert.assertTrue(checkIfElementIsPresent(passwordLogin, 3));
        Assert.assertTrue(checkIfElementIsClickAble(loginBtn, 2));
        robotWaitFor(2000);
        fluentWait(DBManage, 2000, 250);
        waitUntilTextIsPresentInLocator(manageDB, "Manage Databases");
        waitForElementActionable(loginBtn, 2);
        goToWeb("https://sweetalert2.github.io/");
        scrollUntilViewElement(dialog);
        wait(2000);
        clickOn(dialogBox);
        try {
            waitUntilLocatorIsInvisible(popUpTitle, 5);
        } catch (TimeoutException e) {
            log.info("This step is intended to time out with element :" + popUpTitle);
        }
        try {
            Assert.assertTrue(checkIfElementIsInvisible(popUpTitle, 5));
        } catch (TimeoutException e) {
            log.info("This step is intended to ignore time out error with element :" + popUpTitle);
        } catch (AssertionError e) {
            log.info("This step is intended to ignore assertion error with element :" + popUpTitle);
        }
    }
}
