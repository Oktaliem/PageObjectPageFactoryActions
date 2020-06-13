package com.oktaliem.testsuit.vueweb;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Author : Okta Liem
 */
public class VueTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        userIsOn.vueDashPage().goToDashboardPage();
    }

    @Test(description = "Click On Year Button")
    public void VU_01() {
        userIsOn.vueDashPage().clickOnYear();
    }

    @Test(description = "Breadcrumb Test")
    public void VU_02() {
        userIsOn.vueDashPage().goToComponent("Base");
        userIsOn.vueDashPage().openSubComponent("Breadcrumbs");
    }

}
