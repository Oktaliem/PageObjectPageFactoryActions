package com.oktaliem.testsuit.angularweb;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.Test;

/**
 * Author : Okta Liem
 */
public class angularTest extends BaseTest {


    @Test(description = "initial test")
    public void AG_01(){
        userIsOn.agDashboardPage().goToDashboardPage();
    }

}
