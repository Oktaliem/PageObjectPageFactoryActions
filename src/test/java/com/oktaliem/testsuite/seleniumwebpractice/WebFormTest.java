package com.oktaliem.testsuite.seleniumwebpractice;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.oktaliem.constants.Url.WEB_PRACTICE_INDEX;

public class WebFormTest extends BaseTest {


    @Test
    public void webFormUIComponentTest() throws InterruptedException, IOException {
        userIsOn.homePage().goToWeb(WEB_PRACTICE_INDEX);
        userIsOn.homePage().goToWebForm();
        userIsOn.webFormPage().inputTextInput("Hello World !");
        userIsOn.webFormPage().moveExampleRangeTo("right", 3);
        userIsOn.webFormPage().moveExampleRangeTo("left", 6);
        userIsOn.webFormPage().uploadFormFile();
    }


}
