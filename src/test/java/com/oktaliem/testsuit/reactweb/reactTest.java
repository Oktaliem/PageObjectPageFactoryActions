package com.oktaliem.testsuit.reactweb;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.Test;

public class reactTest extends BaseTest {

    @Test(description = "initial test")
    public void RT_01(){
        userIsOn.rtDashPage().toToDashboardPage();
    }

}
