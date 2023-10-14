package com.oktaliem.testsuite.flutterweb;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

public class RallyTest extends BaseTest {

    @Test
    public void loginTest() {
        userIsOn.rallyLoginPage().open_rally();
//        userIsOn.rallyLoginPage().loginToRally();
    }

}
