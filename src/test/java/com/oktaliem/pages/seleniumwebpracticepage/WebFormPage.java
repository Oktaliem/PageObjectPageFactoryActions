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
}
