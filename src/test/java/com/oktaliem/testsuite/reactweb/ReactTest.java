package com.oktaliem.testsuite.reactweb;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.BeforeMethod;

/**
 * Author : Okta Liem
 */
public class ReactTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        userIsOn.rtDashPage().goToDashboardPage();
    }

}
