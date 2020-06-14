package com.oktaliem.testsuite.angularweb.formio;

import com.oktaliem.testsuite.BaseTest;
import org.testng.annotations.Test;

public class FormBuilderComponentTest extends BaseTest {

    @Test
    public void textFieldComponent() {
        userIsOn.formBuilderPage().open_component("Text Field");
        userIsOn.formBuilderPage().open_form_tab("display");
        userIsOn.formBuilderPage().open_form_tab("data");
        userIsOn.formBuilderPage().open_form_tab("validation");
        userIsOn.formBuilderPage().open_form_tab("api");
        userIsOn.formBuilderPage().open_form_tab("conditional");
        userIsOn.formBuilderPage().open_form_tab("logic");
        userIsOn.formBuilderPage().open_form_tab("layout");
    }

    @Test
    public void textAreaComponent() {
        userIsOn.formBuilderPage().open_component("Text Area");
    }

    @Test
    public void numberComponent() {
        userIsOn.formBuilderPage().open_component("Number");
    }

    @Test
    public void passwordComponent() {
        userIsOn.formBuilderPage().open_component("Password");
    }

    @Test
    public void checkboxComponent() {
        userIsOn.formBuilderPage().open_component("Checkbox");
    }

    @Test
    public void selectboxComponent() {
        userIsOn.formBuilderPage().open_component("Select Boxes");
    }

    @Test
    public void selectComponent() {
        userIsOn.formBuilderPage().open_component("Select");
    }

    @Test
    public void radioComponent() {
        userIsOn.formBuilderPage().open_component("Radio");
    }

    @Test
    public void buttonComponent() {
        userIsOn.formBuilderPage().open_component("Button");
    }

}
