package com.oktaliem.pages.angularpage.primeng;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PrimengComponentPage extends BasePage {

    public PrimengComponentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ng-tns-c0-0")
    List<WebElement> components;

    @FindBy(className = "feature-title")
    WebElement featureTitle;

    @FindBys({
            @FindBy(className = "ng-star-inserted"),
            @FindBy(tagName = "div")})
    List<WebElement> carBrands;

    @FindBy(className = "ui-datepicker-month")
    WebElement month;

    @FindBy(className = "ui-datepicker-year")
    WebElement year;

    By backDateBtn = By.className("ui-datepicker-prev-icon");
    By nextDateBtn = By.className("ui-datepicker-next-icon");
    By days = By.className("ui-state-default");

    @Step
    public PrimengComponentPage navigateToComponent(String component) {
        goToWeb("https://primefaces.org/primeng/showcase/#/theming");
        waitUntilTextIsPresentInLocator(featureTitle, "Theming");
        clickBySortingTextElement(components,component);
        wait(1000);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengComponentPage openAdvanceAutoComplete() {
        clickOn(By.className("ui-autocomplete-dropdown"));
        return this;
    }

    @Step
    public PrimengComponentPage selectCarBrand(String brand) {
        clickBySortingTextElement(carBrands,brand);
        checkIfElementIsPresent(By.xpath("//span[.='Brand: " + brand + "']"), 5);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengComponentPage searchPastYearAndMonth(String month, String year) {
        searchYearAndMonth(backDateBtn, month, year);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengComponentPage selectDay(String day) {
        clickBySortingTextElement(days,day);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengComponentPage searchFutureYearAndMonth(String month, String year) {
        searchYearAndMonth(nextDateBtn, month, year);
        performPageScreenshot(driver);
        return this;
    }

    private void searchYearAndMonth(By element, String month, String year) {
        String yearAndMonth = year + month;
        scrollUntilViewElement(By.xpath("//h3[.='Inline']"));
        int i = 0;
        do {
            clickOn(element);
            if (i > 100) {
                break;
            }
            i++;
        }
        while (!yearAndMonth.equals(this.year.getText() + this.month.getText()));
    }


}
