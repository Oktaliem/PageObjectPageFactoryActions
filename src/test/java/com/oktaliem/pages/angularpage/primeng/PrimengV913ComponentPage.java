package com.oktaliem.pages.angularpage.primeng;

import com.oktaliem.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrimengV913ComponentPage extends BasePage {

    public PrimengV913ComponentPage(WebDriver driver) {
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

    @FindBys({
            @FindBy(className = "ui-helper-clearfix"),
            @FindBy(tagName = "div")})
    List<WebElement> listCarBrands;

    @FindBy(className = "ui-datepicker-month")
    WebElement month;

    @FindBy(className = "ui-datepicker-year")
    WebElement year;

    @FindBy(className = "ui-chkbox")
    List<WebElement> checkBox;

    @FindBy(className = "ui-chkbox-label")
    List<WebElement> checkBoxLabel;

    @FindBy(xpath = "//p-chips[1]//input[@class='undefined']")
    WebElement chip;

    @FindBy(className = "ui-chips-token-label")
    List<WebElement> chipLabel;

    @FindBy(className = "ui-chips-token-icon")
    List<WebElement> chipIcon;

    @FindBy(className = "ui-dropdown-item")
    List<WebElement> dropDownValues;

    By backDateBtn = By.className("ui-datepicker-prev-icon");
    By nextDateBtn = By.className("ui-datepicker-next-icon");
    By days = By.className("ui-state-default");

    @FindBy(xpath = "//div[@class='ql-editor']")
    WebElement editor;

    @FindBy(className = "ql-picker-label")
    List<WebElement> qlPicker;

    @FindBys({
            @FindBy(id = "ql-picker-options-0"),
            @FindBy(tagName = "span")})
    List<WebElement> qlPickerItem;

    @FindBys({
            @FindBy(id = "ql-picker-options-1"),
            @FindBy(tagName = "span")})
    List<WebElement> qlPickerType;

    @FindBys({
            @FindBy(id = "ql-picker-options-2"),
            @FindBy(tagName = "label")})
    List<WebElement> qlPickerColour;


    @FindBy(tagName = "p-checkbox")
    List<WebElement> squareCheckBox;

    @FindBys({
            @FindBy(className = "p-field-checkbox"),
            @FindBy(tagName = "label")})
    List<WebElement> squareCheckLabel;

    @FindBy(className = "ui-radiobutton-label")
    List<WebElement> radioButtons;

    @FindBy(tagName = "p-rating")
    List<WebElement> rating;

    @FindBy(className = "first")
    WebElement horizontalCounter;

    @FindBy(xpath = "//h3[contains(text(),'Vertical:')]")
    WebElement verticalCounter;

    @FindBy(xpath = "//p-slider[1]//div[1]//span[2]")
    WebElement horizontalSlider;

    @FindBy(xpath = "//p-slider[6]//div[1]//span[2]")
    WebElement verticalSlider;

    @FindBy(className = "ui-spinner-up")
    List<WebElement> spinnerUp;

    @FindBy(className = "ui-spinner-down")
    List<WebElement> spinnerDown;

    @FindBy(xpath = "//p-spinner[1]//span[1]//input[1]")
    WebElement spinnerResult;

    @FindBy(className = "ui-button-text")
    List<WebElement> splitButton;

    @FindBy(className = "pi-chevron-down")
    List<WebElement> splitButtonRight;

    @FindBy(className = "ui-menuitem-text")
    List<WebElement> splitBtnList;

    @FindBy(className = "car-title")
    List<WebElement> carsTitle;

    @FindBy(className = "ui-paginator-page")
    List<WebElement> pageNumbers;

    @FindBys({
            @FindBy(className = "ui-helper-clearfix"),
            @FindBy(tagName = "div")})
    List<WebElement> pickList;

    @FindBy(className = "ui-widget-header")
    List<WebElement> videoList;

    @FindBy(className = "ui-menuitem-link")
    List<WebElement> menuLink;

    @FindBy(className = "ui-panelmenu-header-link")
    List<WebElement> panelMenuLink;

    @Step
    public PrimengV913ComponentPage navigateToComponent(String component) {
        goToWeb("https://www.primefaces.org/primeng/v9.1.4-lts/#/theming");
        waitUntilTextIsPresentInLocator(featureTitle, "Theming");
        clickBySortingTextElement(components, component);
        wait(1000);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage openAdvanceAutoComplete() {
        clickOn(By.className("ui-autocomplete-dropdown"));
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage selectCarBrand(String brand) {
        clickBySortingTextElement(carBrands, brand);
        checkIfElementIsPresent(By.xpath("//span[.='Brand: " + brand + "']"), 5);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public List<String> getAllDropDownListText() {
        List<String> carList = listCarBrands.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        log.info("Store element text as a list " + carList);
        for (WebElement listCarBrand : listCarBrands) {
            log.info("print each car brand: " + listCarBrand.getText());
        }
        return carList;
    }

    @Step
    public void sortCarListDescending(List<String> carList) {
        Collections.reverse(carList);
        List<String> expectedCarList = Collections
                .singletonList("VW, Volvo, Renault, Mercedes, Jaguar, Honda, Ford, Fiat, BMW, Audi");
        log.info("Actual car list after sorting: " + carList);
        log.info("Expected car list: " + expectedCarList);
    }

    @Step
    public PrimengV913ComponentPage searchPastYearAndMonth(String month, String year) {
        searchYearAndMonth(backDateBtn, month, year);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage selectDay(String day) {
        clickBySortingTextElement(days, day);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage searchFutureYearAndMonth(String month, String year) {
        searchYearAndMonth(nextDateBtn, month, year);
        performPageScreenshot(driver);
        return this;
    }

    @Step
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
        performPageScreenshot(driver);
    }

    @Step
    public void selectBasicCheckBox(String label) {
        int count = checkBox.size();
        for (int i = 0; i < count; i++) {
            if (checkBoxLabel.get(i).getText().equals(label)) {
                clickOn(checkBox.get(i));
                break;
            }
        }
        performPageScreenshot(driver);
    }

    @Step
    public void inputValueToChipsField(String chip) {
        inputTextAndEnter(this.chip, chip);
        performPageScreenshot(driver);
    }

    @Step
    public void removeChipByValue(String chip) {
        int count = chipLabel.size();
        for (int i = 0; i < count; i++) {
            count = chipLabel.size();
            if (chipLabel.get(i).getText().equals(chip)) {
                clickOn(chipIcon.get(i));
            }
        }
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage selectColourDegradationByCoordinate(String left, String right) {
        String value = "left: " + left + "px; top: " + right + "px;";
        setAttributeByJsExecutor("class", "ui-colorpicker-color-handle", "style", value);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage setColourByCoordinate(String coordinate) {
        String value = "top: " + coordinate + "px;";
        setAttributeByJsExecutor("class", "ui-colorpicker-hue-handle", "style", value);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void getSelectedColourEqualTo(String hexColourCode) {
        checkIfTextIsContains(By.cssSelector("div.implementation > p:nth-of-type(1)"), hexColourCode);
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage selectSingleDropDownList(String country) {
        clickOn(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/ng-component[1]/div[2]/" +
                "p-dropdown[1]/div[1]/div[2]/span[1]"));
        selectOnDropDownListByText(dropDownValues, country);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage selectEditableDropDownList(String car) {
        clickOn(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/ng-component[1]/div[2]/" +
                "p-dropdown[2]/div[1]/div[3]/span[1]"));
        selectOnDropDownListByText(dropDownValues, car);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage selectGroupDropDownList(String car) {
        clickOn(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/ng-component[1]/div[2]/" +
                "p-dropdown[4]/div[1]/div[3]/span[1]"));
        selectOnDropDownListByText(dropDownValues, car);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage selectVirtualSrollDropDownList(String car) {
        clickOn(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/ng-component[1]/div[2]/" +
                "p-dropdown[5]/div[1]/div[3]/span[1]"));
        selectOnDropDownListByText(dropDownValues, car);
        wait(1000);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage inputTextOnEditor(String info) {
        clickOn(editor);
        controlPlus(editor, "a");
        performDelete();
        wait(1000);
        inputTextBox(By.xpath("//p-editor[@class='ng-valid ng-touched ng-dirty']//div[@class='ql-editor ql-blank']"), info);
        wait(1000);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage changeFontSize(String size) {
        clickOn(qlPicker.get(0));
        for (WebElement element : qlPickerItem) {
            if (element.getAttribute("data-label").equals(size)) {
                clickOn(element);
                break;
            }
        }
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage changeFontType(String type) {
        clickOn(qlPicker.get(1));
        for (WebElement element : qlPickerType) {
            if (element.getAttribute("data-label").equals(type)) {
                clickOn(element);
                break;
            }
        }
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void changeFontColour(String colour) {
        clickOn(qlPicker.get(2));
        controlPlus(editor, "a");
        for (WebElement element : qlPickerColour) {
            if (element.getAttribute("style").contains(colour)) {
                clickOn(element);
                break;
            }
        }
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage inputVerticalFirstName(String firstName) {
        inputTextBox(By.id("firstname1"), firstName);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage inputVerticalLastName(String lastName) {
        inputTextBox(By.id("lastname1"), lastName);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void selectVerticalCheckBox(String label) {
        scrollUntilViewElement(squareCheckBox.get(0));
        int count = squareCheckBox.size();
        for (int i = 0; i < count; i++) {
            if (squareCheckLabel.get(i).getText().equals(label)) {
                clickOn(squareCheckBox.get(i));
                break;
            }
        }
        performPageScreenshot(driver);
    }

    @Step
    public void selectBasicRadioButton(String option) {
        selectOnRadioButtonByText(radioButtons, option);
        wait(2000);
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage giveNoCancelRating(String rating) {
        List<WebElement> stars = this.rating.get(2)
                .findElement(By.className("ui-rating"))
                .findElements(By.className("ng-star-inserted"));
        switch (rating) {
            case "1 star":
                clickOn(stars.get(0));
                break;
            case "2 stars":
                clickOn(stars.get(1));
                break;
            case "3 stars":
                clickOn(stars.get(2));
                break;
            case "4 stars":
                clickOn(stars.get(3));
                break;
            case "5 stars":
                clickOn(stars.get(4));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rating);
        }
        wait(1000);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage moveHorizontalSliderToPercentage(String percentage) {
        int i = 0;
        do {
            Actions builder = new Actions(driver);
            builder.moveToElement(horizontalSlider)
                    .clickAndHold()
                    .dragAndDropBy(horizontalSlider, i / 3, 0)
                    .build()
                    .perform();
            log.info("move to x coordinate: " + horizontalSlider.getLocation().getX());
            i++;
        }
        while (!horizontalCounter.getText().contains(percentage));
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void moveToVerticalSliderToPercentage(String percentage) {
        int i = 0;
        do {
            Actions builder = new Actions(driver);
            builder.moveToElement(verticalSlider)
                    .clickAndHold()
                    .dragAndDropBy(verticalSlider, 0, -i / 3)
                    .build()
                    .perform();
            log.info("move to y coordinate: " + verticalSlider.getLocation().getY());
            i++;
        }
        while (!verticalCounter.getText().contains(percentage));
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage selectBasicSpinnerUp(String value) {
        do {
            clickOn(spinnerUp.get(0));
        }
        while (!spinnerResult.getAttribute("aria-valuenow").equals(value));
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void selectBasicSpinnerDown(String value) {
        do {
            clickOn(spinnerDown.get(0));
        }
        while (!spinnerResult.getAttribute("aria-valuenow").equals(value));
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage clickOnSaveButton() {
        clickOn(splitButton.get(0));
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage clickOnSplitBtn(String button) {
        clickOn(splitButtonRight.get(0));
        wait(1000);
        clickBySortingTextElement(splitBtnList, button);
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void selectCarFromTheList(String car) {
        for (int i = 0; i <= 13; i++) {
            if (i == 13) {
                Assert.fail("List exceed the limit");
            }
            if (carsTitle.get(i).isDisplayed()) {
                if (carsTitle.get(i).getText().equals(car)) {
                    clickOn(carsTitle.get(i));
                    break;
                }
                if (i == 3 || i == 6) {
                    clickOn(By.cssSelector("div.implementation > p-carousel:nth-of-type(1) .ui-carousel-next-icon"));
                    wait(1000);
                }
            } else {
                Assert.fail("Car is not displayed");
            }
        }
        performPageScreenshot(driver);
    }

    @Step
    public PrimengV913ComponentPage goToPageNumber(String page) {
        clickBySortingTextElement(pageNumbers, page);
        scrollUntilViewElement(By.className("feature-title"));
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public PrimengV913ComponentPage pickCarBrandToBasket(String carBrand) {
        for (WebElement element : pickList) {
            System.out.println(element.getText());
            if (element.getText().equals(carBrand)) {
                clickOn(element);
                wait(1000);
                clickOn(By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-angle-right']"));
                break;
            }
        }
        performPageScreenshot(driver);
        return this;
    }

    @Step
    public void openToolTip(String tooltip) {
        moveMousePointerTo(By.cssSelector(".ui-fluid.p-grid [placeholder='Right']"));
        checkIfTextIsExpected(By.className("ui-tooltip"), tooltip);
        performPageScreenshot(driver);
    }

    @Step
    public void openVideoMenu(String video) {
        moveMousePointerTo(By.xpath("//div[@class='ui-megamenu ui-widget ui-widget-content ui-corner-all" +
                " ui-megamenu-horizontal']//a[.='Videos']"));
        wait(1000);
        clickBySortingTextElement(videoList, video);
    }

    @Step
    public void createNewProject() {
        clickOn(menuLink.get(0));
        moveMousePointerTo(menuLink.get(1));
        wait(1000);
        performPageScreenshot(driver);
        moveMouseAndClick(menuLink.get(1), menuLink.get(2));
    }

    @Step
    public void openNewUserFile() {
        clickOn(panelMenuLink.get(0));
        clickOn(menuLink.get(0));
        performPageScreenshot(driver);
        clickOn(menuLink.get(1));
    }

    @Step
    public PrimengV913ComponentPage opensSlideOption(String option) {
        for (WebElement menu : menuLink) {
            if (menu.findElement(By.className("ui-menuitem-text")).getText().equals(option)) {
                clickOn(menu);
            }
        }
        performPageScreenshot(driver);
        return this;
    }

}