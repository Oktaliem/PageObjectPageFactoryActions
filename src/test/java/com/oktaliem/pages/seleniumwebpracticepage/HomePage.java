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

    private @FindBy(linkText = "Web form")
    WebElement webForm;

    private @FindBy(linkText = "Navigation")
    WebElement navigation;

    private @FindBy(linkText = "Dropdown menu")
    WebElement dropdownMenu;

    private @FindBy(linkText = "Mouse over")
    WebElement mouseOver;

    private @FindBy(linkText = "Drag and drop")
    WebElement dragAndDrop;

    private @FindBy(linkText = "Draw in canvas")
    WebElement drawInCanvas;

    private @FindBy(linkText = "Loading images")
    WebElement loadImages;

    private @FindBy(linkText = "Slow calculator")
    WebElement slowCalculator;

    @Step
    public void goToWebForm(){
        clickOn(webForm);
    }


}
