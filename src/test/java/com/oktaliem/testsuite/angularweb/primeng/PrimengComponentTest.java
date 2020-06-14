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
    public void calendar(){
        userIsOn.primengComponentPage().navigateToComponent("Calendar")
                .searchPastYearAndMonth("August", "2017")
                .selectDay("15")
                .searchFutureYearAndMonth("August", "2023")
                .selectDay("13");
    }
}
