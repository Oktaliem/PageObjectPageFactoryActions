package com.oktaliem.pages.angularpage.formio;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FormBuilderPage extends BasePage {

    public FormBuilderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "formcomponent")
    List<WebElement> components;

    @FindBy(className = "drag-and-drop-alert")
    WebElement dragAndDropTarget;

    @Step
    public void open_component(String component) {
        goToWeb("https://formio.github.io/angular-demo/#/forms/builder");

        int index = 0;
        int count = components.size();
        for (int i = 0; i < count; i++) {
            if (components.get(i).getText().equals(component)) {
                index = i;
                break;
            }
            if (i == 9) {
                Assert.fail(component + " not found");
            }
        }
        dragFromAndDropTo(components.get(index), dragAndDropTarget);

        wait(1000);
        performPageScreenshot(driver);
    }

    @Step
    public void open_form_tab(String tab) {
        clickOn(By.cssSelector("a[href='#" + tab + "']"));
        wait(1000);
        performPageScreenshot(driver);
    }
}
