package com.oktaliem.testsuite.angularweb.primeng;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class PrimengComponentTest extends BaseTest {

    @Test
    public void autoComplete() {
        userIsOn.primengComponentPage().navigateToComponent("AutoComplete")
                .openAdvanceAutoComplete()
                .selectCarBrand("Ford")
                .openAdvanceAutoComplete()
                .selectCarBrand("VW");
    }

    @Test
    public void getAllAutocompleteValueAndSortDescending(){
        userIsOn.primengComponentPage().navigateToComponent("AutoComplete")
                .openAdvanceAutoComplete();
        List<String> carList = userIsOn.primengComponentPage().getAllDropDownListText();
        userIsOn.primengComponentPage().sortCarListDescending(carList);
    }

    @Test
    public void calendar() {
        userIsOn.primengComponentPage().navigateToComponent("Calendar")
                .searchPastYearAndMonth("August", "2017")
                .selectDay("15")
                .searchFutureYearAndMonth("August", "2023")
                .selectDay("13");
    }

    @Test
    public void checkBox() {
        userIsOn.primengComponentPage().navigateToComponent("Checkbox");
        String[] cities = {"Los Angeles", "San Francisco", "New York"};
        for (String city : cities) {
            userIsOn.primengComponentPage().selectBasicCheckBox(city);
        }
    }

    @Test
    public void chips() {
        userIsOn.primengComponentPage().navigateToComponent("Chips");
        String[] socialMedia = {"Facebook", "Twitter", "Instagram"};
        for (String chip : socialMedia) {
            userIsOn.primengComponentPage().inputValueToChipsField(chip);
        }
        String[] removeSocialMedia = {"Facebook", "Instagram"};
        for (String chip : removeSocialMedia) {
            userIsOn.primengComponentPage().removeChipByValue(chip);
        }
    }

    @Test
    public void colorPicker() {
        userIsOn.primengComponentPage()
                .navigateToComponent("ColorPicker")
                .setColourByCoordinate("49")
                .selectColourDegradationByCoordinate("144", "51");
        userIsOn.primengComponentPage().getSelectedColourEqualTo("#0c07a8");
    }

    @Test
    public void dropDown() {
        userIsOn.primengComponentPage().navigateToComponent("Dropdown")
                .selectSingleDropDownList("Istanbul")
                .selectEditableDropDownList("Mercedes")
                .selectGroupDropDownList("Mazda")
                .selectVirtualSrollDropDownList("Item 5");
    }

    @Test
    public void editor() {
        userIsOn.primengComponentPage().navigateToComponent("Editor")
                .inputTextOnEditor("This is just for testing only")
                .changeFontSize("Subheading")
                .changeFontType("Serif")
                .changeFontColour("rgb(230, 0, 0)");
    }

    @Test
    public void formLayout() {
        userIsOn.primengComponentPage().navigateToComponent("FormLayout")
                .inputVerticalFirstName("Jon").inputVerticalLastName("Doe")
                .selectVerticalCheckBox("Los Angeles");
    }

    @Test
    public void radioButton() {
        userIsOn.primengComponentPage().navigateToComponent("RadioButton");
        userIsOn.primengComponentPage().selectBasicRadioButton("Option 3");
    }

    @Test
    public void rating() {
        userIsOn.primengComponentPage().navigateToComponent("Rating")
                .giveNoCancelRating("4 stars")
                .giveNoCancelRating("1 star")
                .giveNoCancelRating("5 stars")
                .giveNoCancelRating("3 stars")
                .giveNoCancelRating("2 stars");
    }

    @Test
    public void slider() {
        userIsOn.primengComponentPage().navigateToComponent("Slider")
                .moveHorizontalSliderToPercentage("79")
                .moveToVerticalSliderToPercentage("79");
    }

    @Test
    public void spinner() {
        userIsOn.primengComponentPage().navigateToComponent("Spinner")
                .selectBasicSpinnerUp("50")
                .selectBasicSpinnerDown("-50");
    }

    @Test
    public void splitButton() {
        userIsOn.primengComponentPage().navigateToComponent("SplitButton")
                .clickOnSaveButton()
                .clickOnSplitBtn("Update")
                .clickOnSplitBtn("Delete")
                .clickOnSplitBtn("Setup");
    }

    @Test
    public void carousel() {
        userIsOn.primengComponentPage().navigateToComponent("Carousel")
                .selectCarFromTheList("Fiat");
    }

    @Test
    public void pagination() {
        userIsOn.primengComponentPage().navigateToComponent("Paginator")
                .goToPageNumber("5")
                .goToPageNumber("3");
    }

    @Test
    public void pickList() {
        userIsOn.primengComponentPage().navigateToComponent("PickList")
                .pickCarBrandToBasket("VW - 2012 - Orange")
                .pickCarBrandToBasket("BMW - 2003 - Blue");
    }

    @Test
    public void tooltip() {
        userIsOn.primengComponentPage().navigateToComponent("Tooltip")
                .openToolTip("Enter your username");
    }

    @Test
    public void megaMenu() {
        userIsOn.primengComponentPage().navigateToComponent("MegaMenu")
                .openVideoMenu("Video 4");
    }

    @Test
    public void menuBar() {
        userIsOn.primengComponentPage().navigateToComponent("Menubar")
                .createNewProject();
    }

    @Test
    public void panelMenu() {
        userIsOn.primengComponentPage().navigateToComponent("PanelMenu")
                .openNewUserFile();
    }

    @Test
    public void slideMenu() {
        userIsOn.primengComponentPage().navigateToComponent("SlideMenu")
                .opensSlideOption("Help")
                .opensSlideOption("Search")
                .opensSlideOption("file");
    }

}
