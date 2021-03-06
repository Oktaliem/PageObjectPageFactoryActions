package com.oktaliem.testsuite.reactweb;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Author : Okta Liem
 */
public class ReactTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        userIsOn.rtDashPage().goToDashboardPage();
    }

    @Test(description = "Click On Year Button")
    public void RT_01() {
        userIsOn.rtDashPage().clickOnYear();
    }

    @Test(description = "Breadcrumb Test")
    public void RT_02() {
        userIsOn.rtDashPage().goToComponent("Base");
        userIsOn.rtDashPage().openSubComponent("Breadcrumbs");
    }

}
