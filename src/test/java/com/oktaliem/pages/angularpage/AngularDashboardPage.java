package com.oktaliem.pages.angularpage;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AngularDashboardPage extends BasePage {

    public AngularDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void goToDashboardPage(){
        goToWeb("https://coreui.io/angular/demo/#/dashboard");
    }
}
