package com.oktaliem.pages.reactpage;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReactDashboardPage extends BasePage {

    public ReactDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void toToDashboardPage(){
        goToWeb("https://coreui.io/react/demo/#/dashboard");
    }

}
