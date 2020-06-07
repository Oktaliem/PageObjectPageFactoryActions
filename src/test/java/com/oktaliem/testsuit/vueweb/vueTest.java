package com.oktaliem.testsuit.vueweb;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.Test;

public class vueTest extends BaseTest {

    @Test(description = "initial test")
    public void AG_01(){
        userIsOn.vueDashPage().goToDashboardPage();
    }
}
