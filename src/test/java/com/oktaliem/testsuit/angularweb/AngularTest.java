package com.oktaliem.testsuit.angularweb;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Author : Okta Liem
 */
public class AngularTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        userIsOn.agDashboardPage().goToDashboardPage();
    }

    @Test(description = "Click On Year Button")
    public void AG_01(){
        userIsOn.agDashboardPage().clickOnYear();
    }

    @Test(description = "Base Test")
    public void AG_02() {
        userIsOn.agDashboardPage().goToComponent("Base");
    }

}
