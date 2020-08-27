package com.oktaliem.pages.w3c;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.FileAssert.fail;

public class W3CPage extends BasePage {

    public W3CPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBys({@FindBy(id = "accordion3id"),
            @FindBy(tagName = "span")})
    WebElement accordion;

    @FindBy(id = "dialog_label")
    WebElement dialogLabel;

    @Step
    public void clickOnAccordion(String accordion) {
        scrollUntilViewElement(this.accordion);
        if (this.accordion.getText().equals(accordion)) {
            clickViaAction(this.accordion);
        } else {
            fail("Test Failed");
        }
        performPageScreenshot(driver);
        boolean result = checkIfTextIsContains(By.cssSelector("[for='m-city']"), "City");
        Assert.assertTrue(result);
    }

    @Step
    public void clickOnAlert() {
        clickOn(By.id("alert-trigger"));
        checkIfTextIsExpected(By.xpath("//div[@id='ex1']//span[3]"), "こんにちは");
        performPageScreenshot(driver);
    }

    @Step
    public void clickOnSaveAlert() {
        clickOn(By.id("notes_save"));
        checkIfTextIsExpected(By.id("alert_toast"), "Saved");
        performPageScreenshot(driver);
    }

    @Step
    public void clickOnDiscardAlert() {
        clickOn(By.id("notes_discard"));
        checkIfTextIsExpected(dialogLabel, "Confirmation");
        performPageScreenshot(driver);
        clickOn(By.id("notes_confirm"));
        checkIfElementIsInvisible(dialogLabel, 2);
        performPageScreenshot(driver);
    }

    @Step
    public void clickOnBreadCrumb(String value) {
        clickOn(By.xpath("//a[.='" + value + "']"));
        performPageScreenshot(driver);
        Assert.assertTrue(checkIfElementIsPresent(By.xpath("//a[.='Breadcrumb design pattern example']"),4));
    }
}
