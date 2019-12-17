package com.oktaliem.pages.webactions;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface IScreenshot {
    void takeScreenshotWithAshot(String fileName) throws IOException;
    void takeScreenshotWithShutterbug(String fileName) throws IOException;
    void checkIfImagesAreIdentical(String base, String actual, String result) throws IOException;
    void checkIfImagesShouldNotIdentical(String base, String actual, String result) throws IOException;
    void takeScreenShot(String fileName) throws IOException;
    void takeElementScreenShotWithShutterbug(WebElement element, String image) throws IOException;
}