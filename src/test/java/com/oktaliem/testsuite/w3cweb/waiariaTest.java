package com.oktaliem.testsuite.w3cweb;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

public class waiariaTest extends BaseTest {

    @Test
    public void accordionTest(){
        userIsOn.w3CPage().goToWeb("https://www.w3.org/TR/wai-aria-practices-1.1/examples/accordion/accordion.html");
        userIsOn.w3CPage().clickOnAccordion("Shipping Address");
    }

    @Test
    public void alertTest(){
        userIsOn.w3CPage().goToWeb("https://www.w3.org/TR/wai-aria-practices-1.1/examples/alert/alert.html");
        userIsOn.w3CPage().clickOnAlert();
    }

    @Test
    public void alertDialog(){
        userIsOn.w3CPage().goToWeb("https://www.w3.org/TR/wai-aria-practices-1.1/examples/dialog-modal/alertdialog.html");
        userIsOn.w3CPage().clickOnSaveAlert();
        userIsOn.w3CPage().clickOnDiscardAlert();
    }

}
