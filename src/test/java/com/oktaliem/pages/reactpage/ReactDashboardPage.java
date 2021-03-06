package com.oktaliem.pages.reactpage;

import com.oktaliem.pages.BasePage;
import com.oktaliem.pages.ipages.IDashboard;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReactDashboardPage extends BasePage implements IDashboard {

    public ReactDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //button[contains(text(),'Year')]")
    WebElement yearBtn;

    @FindBy(className = "nav-dropdown-toggle")
    List<WebElement> components;

    @FindBy(className = "nav-link")
    List<WebElement> subComponents;

    @Step
    @Override
    public void goToDashboardPage() {
        goToWeb("https://coreui.io/react/demo/#/dashboard");
    }

    @Step
    @Override
    public void clickOnYear() {
        clickOn(yearBtn);
    }

    @Step
    @Override
    public void goToComponent(String component) {
        clickBySortingTextElement(components,component);
        performPageScreenshot(driver);
    }

    @Step
    @Override
    public void openSubComponent(String sub) {
        clickBySortingTextElement(subComponents,sub);
        fluentWait(By.xpath("//li[contains(text(),'Home')]"),10000,500);
        wait(1000);
        performPageScreenshot(driver);
    }
}
