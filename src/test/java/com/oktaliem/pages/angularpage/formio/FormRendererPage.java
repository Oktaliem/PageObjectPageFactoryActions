package com.oktaliem.pages.angularpage.formio;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FormRendererPage extends BasePage {

    public FormRendererPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "data[firstName]")
    WebElement firstNameField;

    @FindBy(name = "data[lastName]")
    WebElement lastNameField;

    @FindBy(name = "data[email]")
    WebElement emailField;

    By submitBtn = By.name("data[submit]");

    @Step
    public void execute_login_form_with_invalid_email_format(){
        goToWeb("https://formio.github.io/angular-demo/#/forms/renderer");
        inputTextBox(firstNameField,"Mark");
        inputTextBox(lastNameField,"Anthony");
        inputTextBox(emailField,"example.com");
        clickOn(submitBtn);
        performPageScreenshot(driver);
    }

    @Step
    public void error_message_displayed() {
        String errorMessage ="Email must be a valid email.";
        String actualError = getTextElementViaJSExecutor("class","alert-danger",0);
        Assert.assertEquals(actualError,errorMessage);
        checkIfTextIsExpected(By.className("error"),errorMessage);
    }
}
