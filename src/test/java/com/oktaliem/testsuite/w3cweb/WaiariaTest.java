package com.oktaliem.testsuite.w3cweb;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

import static com.oktaliem.constants.Url.*;

public class WaiariaTest extends BaseTest {

    @Test
    public void accordionTest(){
        userIsOn.w3CPage().goToWeb(W3C_ACCORDION_URL);
        userIsOn.w3CPage().clickOnAccordion("Shipping Address");
    }

    @Test
    public void alertTest(){
        userIsOn.w3CPage().goToWeb(W3C_ALERT_URL);
        userIsOn.w3CPage().clickOnAlert();
    }

    @Test
    public void alertDialog(){
        userIsOn.w3CPage().goToWeb(W3C_ALERT_DIALOG_URL);
        userIsOn.w3CPage().clickOnSaveAlert();
        userIsOn.w3CPage().clickOnDiscardAlert();
    }

    @Test
    public void breadcrumbTest(){
        userIsOn.w3CPage().goToWeb(W3C_BREADCRUMB_URL);
        userIsOn.w3CPage().clickOnBreadCrumb("Breadcrumb Pattern");
    }

}
