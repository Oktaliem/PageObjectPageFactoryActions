package com.oktaliem.testsuite.vueweb;

import com.oktaliem.testsuite.BaseTest;
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

}
