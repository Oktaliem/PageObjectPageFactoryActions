package com.oktaliem.pages.vuepage;

import com.oktaliem.pages.BasePage;
import com.oktaliem.pages.ipages.IDashboard;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VueDashboardPage extends BasePage implements IDashboard {

    public VueDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Year')]")
    WebElement yearBtn;

    @FindBy(className = "c-sidebar-nav-dropdown-toggle")
    List<WebElement> components;

    @FindBy(className = "c-sidebar-nav-item")
    List<WebElement> subComponents;

    @FindBy(xpath = "//a[contains(text(),'Go to widgets')]")
    WebElement goToWidgets;


    @Step
    @Override
    public void goToDashboardPage() {
        goToWeb("https://coreui.io/vue/demo/3.0.0/#/dashboard");
    }

    @Step
    @Override
    public void clickOnYear() {
        clickOn(yearBtn);
    }

    @Step
    @Override
    public void goToComponent(String component) {
        for (WebElement element : components) {
            if (element.getText().equals(component)) {
                element.click();
                System.out.println("go to Component:" + component);
                break;
            }
        }
        saveScreenshotPNG(driver);
    }

    @Step
    @Override
    public void openSubComponent(String sub) {
        for (WebElement element : subComponents) {
            if (element.findElement(By.tagName("a")).getText().equals(sub)) {
                element.click();
                System.out.println("go to sub Component:" + sub);
                break;
            }
        }
        waitUntilLocatorIsVisible(goToWidgets, 4);
        wait(1000);
        saveScreenshotPNG(driver);
    }
}
