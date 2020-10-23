package com.oktaliem.testsuite.angularweb.primeng;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class PrimengV914ComponentTest extends BaseTest {

    @Test
    public void autoComplete() {
        userIsOn.primengV913ComponentPage().navigateToComponent("AutoComplete")
                .openAdvanceAutoComplete()
                .selectCarBrand("Ford")
                .openAdvanceAutoComplete()
                .selectCarBrand("VW");
    }

    @Test
    public void getAllAutocompleteValueAndSortDescending(){
        userIsOn.primengV913ComponentPage().navigateToComponent("AutoComplete")
                .openAdvanceAutoComplete();
        List<String> carList = userIsOn.primengV913ComponentPage().getAllDropDownListText();
        userIsOn.primengV913ComponentPage().sortCarListDescending(carList);
    }

    @Test
    public void calendar() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Calendar")
                .searchPastYearAndMonth("August", "2017")
                .selectDay("15")
                .searchFutureYearAndMonth("August", "2023")
                .selectDay("13");
    }

    @Test
    public void checkBox() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Checkbox");
        String[] cities = {"Los Angeles", "San Francisco", "New York"};
        for (String city : cities) {
            userIsOn.primengV913ComponentPage().selectBasicCheckBox(city);
        }
    }

    @Test
    public void chips() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Chips");
        String[] socialMedia = {"Facebook", "Twitter", "Instagram"};
        for (String chip : socialMedia) {
            userIsOn.primengV913ComponentPage().inputValueToChipsField(chip);
        }
        String[] removeSocialMedia = {"Facebook", "Instagram"};
        for (String chip : removeSocialMedia) {
            userIsOn.primengV913ComponentPage().removeChipByValue(chip);
        }
    }

    @Test
    public void colorPicker() {
        userIsOn.primengV913ComponentPage()
                .navigateToComponent("ColorPicker")
                .setColourByCoordinate("49")
                .selectColourDegradationByCoordinate("144", "51");
        userIsOn.primengV913ComponentPage().getSelectedColourEqualTo("#0c07a8");
    }

    @Test
    public void dropDown() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Dropdown")
                .selectSingleDropDownList("Istanbul")
                .selectEditableDropDownList("Mercedes")
                .selectGroupDropDownList("Mazda")
                .selectVirtualScrollDropDownList("Item 5");
    }

    @Test
    public void editor() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Editor")
                .inputTextOnEditor("This is just for testing only")
                .changeFontSize("Subheading")
                .changeFontType("Serif")
                .changeFontColour("rgb(230, 0, 0)");
    }

    @Test
    public void formLayout() {
        userIsOn.primengV913ComponentPage().navigateToComponent("FormLayout")
                .inputVerticalFirstName("Jon").inputVerticalLastName("Doe")
                .selectVerticalCheckBox("Los Angeles");
    }

    @Test
    public void radioButton() {
        userIsOn.primengV913ComponentPage().navigateToComponent("RadioButton");
        userIsOn.primengV913ComponentPage().selectBasicRadioButton("Option 3");
    }

    @Test
    public void rating() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Rating")
                .giveNoCancelRating("4 stars")
                .giveNoCancelRating("1 star")
                .giveNoCancelRating("5 stars")
                .giveNoCancelRating("3 stars")
                .giveNoCancelRating("2 stars");
    }

    @Test
    public void slider() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Slider")
                .moveHorizontalSliderToPercentage("79")
                .moveToVerticalSliderToPercentage("79");
    }

    @Test
    public void spinner() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Spinner")
                .selectBasicSpinnerUp("50")
                .selectBasicSpinnerDown("-50");
    }

    @Test
    public void splitButton() {
        userIsOn.primengV913ComponentPage().navigateToComponent("SplitButton")
                .clickOnSaveButton()
                .clickOnSplitBtn("Update")
                .clickOnSplitBtn("Delete")
                .clickOnSplitBtn("Setup");
    }

    @Test
    public void carousel() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Carousel")
                .selectCarFromTheList("Fiat");
    }

    @Test
    public void pagination() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Paginator")
                .goToPageNumber("5")
                .goToPageNumber("3");
    }

    @Test
    public void pickList() {
        userIsOn.primengV913ComponentPage().navigateToComponent("PickList")
                .pickCarBrandToBasket("VW - 2012 - Orange")
                .pickCarBrandToBasket("BMW - 2003 - Blue");
    }

    @Test
    public void tooltip() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Tooltip")
                .openToolTip("Enter your username");
    }

    @Test
    public void megaMenu() {
        userIsOn.primengV913ComponentPage().navigateToComponent("MegaMenu")
                .openVideoMenu("Video 4");
    }

    @Test
    public void menuBar() {
        userIsOn.primengV913ComponentPage().navigateToComponent("Menubar")
                .createNewProject();
    }

    @Test
    public void panelMenu() {
        userIsOn.primengV913ComponentPage().navigateToComponent("PanelMenu")
                .openNewUserFile();
    }

    @Test
    public void slideMenu() {
        userIsOn.primengV913ComponentPage().navigateToComponent("SlideMenu")
                .opensSlideOption("Help")
                .opensSlideOption("Search")
                .opensSlideOption("file");
    }

}
