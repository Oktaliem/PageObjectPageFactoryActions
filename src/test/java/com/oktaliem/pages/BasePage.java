package com.oktaliem.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import com.oktaliem.pages.baseactions.BaseElementAct;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePage extends BaseElementAct {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private By menuBtn = By.className("full");
    private By setting = By.className("dropdown-item");

    @FindBy(className = "dropdown-item")
    private List<WebElement> Setting;

    @Step("Open Drop Down Menu")
    public void openDropDownMenu(){
        clickOn(menuBtn);
    }

    @Step("Open Setting Page - Page Factory")
    public void goToSettingPagePF(){
        selectOnDropDownListByText(Setting,"Settings");
    }

    @Step("Open Setting Page - Page Object")
    public void goToSettingPagePO() {
        selectOnDropDownListByText(setting,"Settings");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] performPageScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
