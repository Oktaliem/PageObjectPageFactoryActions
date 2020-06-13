package com.oktaliem.pages.flutterPage;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class RallyLoginPage extends BasePage {
    public RallyLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='flt-text-editing']")
    WebElement textField;

    @FindBy(tagName = "flt-glass-pane")
    WebElement loginBtn;

    @Step
    public void open_rally() {
        goToWeb("https://gallery.flutter.dev/#/rally/login");
        wait(1000);
        performPageScreenshot(driver);
    }

    @Step
    public void loginToRally() {
        performTab();
        performTab();
        inputTextBox(textField, "Test");
        performTab();
        inputTextBox(textField,"password");
        performTab();
        clickOn(loginBtn);
        performEnter();
        wait(7000);
        performPageScreenshot(driver);
    }


}
