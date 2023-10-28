package com.oktaliem.pages.seleniumwebpracticepage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WebFormPage extends HomePage {
    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "my-text-id")
    WebElement textInput;

    @FindBy(name = "my-password")
    WebElement password;

    @FindBy(name = "my-textarea")
    WebElement textArea;

    @FindBy(name = "my-file")
    WebElement inputFile;

    @FindBy(name = "my-range")
    WebElement rangeSlider;

    @FindBy(css = "input[type=hidden]")
    WebElement hiddenInput;

    @FindBy(css = "[type=checkbox]:checked")
    WebElement chxBoxChecked;

    @FindBy(css = "[type=checkbox]:not(:checked)")
    WebElement chxBoxNotChecked;

    @FindBy(name = "my-text")
    WebElement inputText;

    @FindBy(className = "form-control")
    List<WebElement> formControl;


    @Step
    public void inputTextInput(String s) {
        inputTextBox(textInput,s);
    }

    @Step
    public void moveExampleRangeTo(String direction, int iterations) {
        Keys arrow;
        if (direction.equals("right")){
            arrow = Keys.ARROW_RIGHT;
            selectSlider(By.name("my-range"),arrow,iterations);
        } else if (direction.equals("left")){
            arrow = Keys.ARROW_LEFT;
            selectSlider(rangeSlider,arrow,iterations);
        }
    }

    @Step
    public void uploadFormFile() throws IOException {
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        System.out.println(filename);
        inputTextBox(inputFile,filename);
    }

    @Step
    public void checkHiddenWebElement() {
        checkIfElementIsNotDisplayed(By.cssSelector("input[type=hidden]"));
        checkIfElementIsNotDisplayed(hiddenInput);
    }

    @Step
    public void checkBoxTest() {
        checkAttributeIsEqualTo(chxBoxChecked,"id","my-check-1");
        checkIfElementIsSelected(chxBoxChecked);
        checkIfElementIsNotSelected(chxBoxNotChecked);
        checkAttributeIsEqualTo(By.cssSelector("[type=checkbox]:checked"),"id","my-check-1");
        checkIfElementIsSelected(By.cssSelector("[type=checkbox]:checked"));
        checkIfElementIsNotSelected(By.cssSelector("[type=checkbox]:not(:checked)"));
//        checkIfElementIsNotSelected(chxBoxChecked); //expected to fail
    }

    @Step
    public void checkTextBoxIsEnabled() {
        checkIfElementIsEnabled(By.name("my-text"));
        checkIfElementIsEnabled(inputText);
    }

    @Step
    public void checkHTMLAttributeValue() {
        checkAttributeEqualTo(inputText,"type","text");
        checkAttributeEqualTo(By.name("my-text"),"myprop","myvalue");
    }

    @Step
    public void checkDOMAttributeValue() {
        checkDOMAttributeEqualTo(inputText,"type","text");
        checkDOMAttributeEqualTo(By.name("my-text"),"myprop","myvalue");
    }

    @Step
    public void checkDOMProperty() {
        checkDOMPropertyEqualTo(inputText,"type","text");
        checkDOMPropertyEqualTo(By.name("my-text"),"type","text");
    }

    @Step
    public void checkMultipleClassName() {
        checkElementSizeIs(formControl,9);
        checkElementSizeIs(By.className("form-control"),9);
        checkAttributeEqualTo(formControl.get(0),"name","my-text");
        checkAttributeEqualTo(formControl.get(1),"autocomplete","off");
        checkAttributeEqualTo(formControl.get(2),"rows","3");
        checkAttributeEqualTo(formControl.get(8),"class","form-control");
    }
}
