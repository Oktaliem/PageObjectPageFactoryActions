package com.oktaliem.testsuite.angularweb;

import com.oktaliem.testsuite.BaseTest;
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

    @Test(description = "Base Test")
    public void AG_02() {
        userIsOn.agDashboardPage().goToComponent("Base");
    }

}
