package com.oktaliem.testsuite.angularweb.primeng;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

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
                .moveSliderToPercentage("79");
    }

    @Test
    public void spinner() {
        userIsOn.primengComponentPage().navigateToComponent("Spinner");
        //IN-PROGRESS
    }

    @Test
    public void carousel() {
        userIsOn.primengComponentPage().navigateToComponent("Carousel");
        //IN-PROGRESS
    }

}
