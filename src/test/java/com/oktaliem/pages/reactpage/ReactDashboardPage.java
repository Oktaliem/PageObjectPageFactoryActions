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
            System.out.println(element.getText());
            if (element.getText().equals(sub)) {
                element.click();
                System.out.println("go to sub Component:" + sub);
                break;
            }
        }
        fluentWait(By.xpath("//li[contains(text(),'Home')]"),4000,500);
        wait(1000);
        saveScreenshotPNG(driver);
    }
}
