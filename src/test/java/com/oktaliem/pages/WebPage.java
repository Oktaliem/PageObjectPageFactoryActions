package com.oktaliem.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.oktaliem.pages.Path.SELENIUM_WEB;
import static com.oktaliem.pages.Path.W3SCHOOL_DRAG_AND_DROP;

public class WebPage extends BasePage {
    /**
     * Martin Flower :
     * "1. A page object wraps an HTML page, or fragment, with an application-specific API, allowing you to manipulate page elements without digging around in the HTML."
     * "2. A page object should also provide an interface that's easy to program to and hides the underlying widgetry in the window  page."
     * "3. The page object should encapsulate the mechanics required to find and manipulate the data in the page itself. A good rule of thumb is to imagine changing the concrete page -in which case the page object interface shouldn't change."
     */

    public WebPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final By moreNews = By.xpath("//div[@class='button green']");
    private final By originPO = By.id("drag1");
    private final By targetPO = By.id("div2");
    private final By guruDrPO = By.xpath("//span[@class='g-separator g-menu-item-content']//span[@class='g-menu-item-title'][contains(text(),'Testing')]");
    private final By cucumberPO = By.xpath("//span[contains(text(),'Cucumber')]");
    private final By countryPO = By.id("country");
    private final By optionPO = By.tagName("label");
    private final By inputPO = By.tagName("input");
    private final By uploadFilePO = By.cssSelector("body:nth-child(2) form:nth-child(3) > input:nth-child(1)");

    @FindBy(className = "green")
    private List<WebElement> moreNewsBtn;

    @FindBy(id = "drag1")
    private WebElement origin;

    @FindBy(id = "div2")
    private WebElement target;

    @FindBy(id = "iframeResult")
    private WebElement iframe;

    @FindBy(className = "g-menu-parent-indicator")
    private List<WebElement> guruDropDown;

    @FindBy(xpath = "//span[contains(text(),'Cucumber')]")
    private WebElement cucumber;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(tagName = "label")
    private List<WebElement> options;

    @FindBy(tagName = "input")
    private List<WebElement> inputs;

    @FindBy(css = "body:nth-child(2) form:nth-child(3) > input:nth-child(1)")
    private WebElement uploadFilePF;

    @FindBy(css = "input#default")
    private WebElement tags;

    @FindBy(xpath = "//input[@id='cond1']")
    private WebElement lettuce;

    @FindBy(xpath = "//input[@id='cond2']")
    private WebElement tomato;

    @FindBy(xpath = "//a[.='Read the Tutorial']")
    private WebElement tutorialBtn;

    @Step
    public void goToSeleniumOfficialWeb() {
        goToWeb(SELENIUM_WEB);
    }

    @Step
    public void gotToMoreNewsButtonPO() {
        scrollUntilViewElement(moreNews);
        wait(5000);
    }

    @Step
    public void gotToMoreNewsButtonPF() {
        wait(3000);
        scrollUntilViewElement(moreNewsBtn.get(1));
        wait(3000);
    }

    @Step
    public void doubleClickMoreNewsButtonPF() {
        doubleClick(moreNewsBtn.get(1));
    }

    @Step
    public void doubleClickMoreNewsButtonPO() {
        doubleClick(moreNews);
    }

    @Step
    public void movePointerToNewsButtonPO() {
        moveMousePointerTo(moreNews);
    }

    @Step
    public void movePointerToNewsButtonPF() {
        moveMousePointerTo(moreNewsBtn.get(1));
    }

    @Step
    public void goToW3SchoolDropAndDropPage() {
        goToWeb(W3SCHOOL_DRAG_AND_DROP);
    }

    @Step
    public void performDragAndDropPF() {
        switchToFrameByIdOrName(iframe);
        dragFromAndDropTo(origin, target);
        switchFrameToDefaultContent();
        wait(5000);
    }

    @Step
    public void performDragAndDropPO() {
        switchToFrameByIndex(0);
        dragFromAndDropTo(originPO, targetPO);
        switchFrameToParentFrame();
        wait(5000);
    }

    @Step
    public void launchTheApplicationGuru99() {
        goToWeb("https://www.guru99.com/");
    }

    @Step
    public void goToTestingAndClickCucumberPF() {
        moveMousePointerTo(guruDropDown.get(0));
        moveMouseAndClick(guruDropDown.get(0), cucumber);
        wait(5000);
    }

    @Step
    public void goToTestingAndClickCucumberPO() {
        moveMousePointerTo(guruDrPO);
        moveMouseAndClick(guruDrPO, cucumberPO);
        wait(3000);
    }

    @Step
    public void waitViaJavaScriptExecutor() {
        waitWithJSExecutor(10000);
    }

    @Step
    public void selectCountryDropDownList() {
        switchToFrameByIndex(0);
        selectOnDropDownListByText(country, "USA");
        wait(5000);
        selectOnDropDownListByValue(country, "canada");
        wait(5000);
        selectOnDropDownListByValue(countryPO, "australia");
        wait(5000);
    }

    @Step
    public void selectRadioW3SchoolText() {
        switchToFrameByIndex(0);
        selectOnRadioButtonByText(options, "Option 2");
        wait(5000);
        selectOnRadioButtonByText(optionPO, "Option 1");
        wait(5000);
    }

    @Step
    public void selectRadioW3SchoolValue() {
        switchToFrameByIndex(0);
        selectOnRadioButtonByValue(inputs, "Firefox");
        wait(5000);
        selectOnRadioButtonByValue(inputPO, "Safari");
        wait(5000);
    }

    @Step
    public void uploadFilePOPF() {
        switchToFrameByIndex(0);
        uploadFile(uploadFilePO, "/actualhtmltext/loginpage.txt");
        wait(3000);
        refreshPage();
        switchToFrameByIndex(0);
        wait(3000);
        uploadFile(uploadFilePF, "/actualhtmltext/loginpage.txt");
        wait(3000);
    }

    @Step
    public void selectTags(String text) {
        wait(7000);
        switchToFrameByIndex(0);
        selectAutoCompleteDropDownList(tags, text, 0, 50);
    }

    @Step
    public void deselectLettuce() {
        selectCheckBox(this.lettuce, false);
        wait(4000);
        performPageScreenshot(driver);
    }

    public void selectLettuce() {
        selectCheckBox(this.lettuce, true);
        wait(4000);
        performPageScreenshot(driver);
    }

    public void selectTomato() {
        selectCheckBox(tomato, true);
        wait(4000);
        performPageScreenshot(driver);
    }

    public void deselectTomato() {
        selectCheckBox(lettuce, false);
        wait(4000);
        performPageScreenshot(driver);
    }

    public void clickOnReadTheTutorial() {
        clickViaJsForXpath("//a[.='Read the Tutorial']");
        wait(2000);
    }

    public void buttonIsNotEqualToThisText(String text) {
        checkIfTextIsNotExpected(By.xpath("//a[.='Read the Tutorial']"), text);
        fluentWait(tutorialBtn,3000,500);
        waitUntilLocatorIsVisible(tutorialBtn,3000);
        checkIfTextIsNotExpected(tutorialBtn, text);
    }

    public void verifyDropDownListDoesNotContain(String text) {
        clickOn(By.xpath("//button[contains(.,'Releases')]"));
        List<WebElement> dropDown = driver.findElements(By.className("navbar-dropdown-list-item-link"));
        checkIfTextIsNotInTheListOfElements(dropDown, text);
    }

    public void deleteButton(String buttonName) {
        String button = "//a[.='" + buttonName + "']";
        waitUntilLocatorIsVisible(By.xpath(button),3000);
        waitUntilLocatorIsClickAble(By.xpath(button),3000);
        deleteElementWithXpath(button);
        wait(3000);
    }
}
