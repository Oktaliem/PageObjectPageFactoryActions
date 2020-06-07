package com.oktaliem.pages.vuepage;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VueDashboardPage extends BasePage {

    public VueDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void goToDashboardPage(){
        goToWeb("https://coreui.io/vue/demo/3.0.0/#/dashboard");
    }
}
