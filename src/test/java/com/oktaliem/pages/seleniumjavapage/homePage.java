package com.oktaliem.pages.seleniumjavapage;

import com.oktaliem.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends BasePage {

    public homePage(WebDriver driver) {
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


}
