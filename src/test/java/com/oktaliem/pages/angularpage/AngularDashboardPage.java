package com.oktaliem.pages.angularpage;

import com.oktaliem.pages.BasePage;
import com.oktaliem.pages.ipages.IDashboard;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AngularDashboardPage extends BasePage implements IDashboard {

    public AngularDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#option3")
    WebElement yearBtn;

    @FindBys({
            @FindBy(className = "nav-item"),
            @FindBy(className = "nav-dropdown-toggle")
    })
    List<WebElement> components;

    @Step
    @Override
    public void goToDashboardPage() {
        goToWeb("https://coreui.io/angular/demo/#/dashboard");
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
        //doesn't have breadcrumbs
    }
}
