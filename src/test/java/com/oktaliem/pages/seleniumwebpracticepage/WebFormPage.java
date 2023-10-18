package com.oktaliem.pages.seleniumwebpracticepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormPage extends HomePage {
    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "my-text-id")
    WebElement textInput;

    @FindBy(name = "my-password")
    WebElement password;

    @FindBy(name = "my-textarea")
    WebElement textArea;


}
