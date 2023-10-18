package com.oktaliem.pages.seleniumwebpracticepage;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Web form")
    WebElement webForm;

    @FindBy(linkText = "Navigation")
    WebElement navigation;

    @FindBy(linkText = "Dropdown menu")
    WebElement dropdownMenu;

    @FindBy(linkText = "Mouse over")
    WebElement mouseOver;

    @FindBy(linkText = "Drag and drop")
    WebElement dragAndDrop;

    @FindBy(linkText = "Draw in canvas")
    WebElement drawInCanvas;

    @FindBy(linkText = "Loading images")
    WebElement loadImages;

    @FindBy(linkText = "Slow calculator")
    WebElement slowCalculator;

    @Step
    protected void goToWebForm(){
        clickOn(webForm);
    }


}
