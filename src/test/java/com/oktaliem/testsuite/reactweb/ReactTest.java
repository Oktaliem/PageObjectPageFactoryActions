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

}
