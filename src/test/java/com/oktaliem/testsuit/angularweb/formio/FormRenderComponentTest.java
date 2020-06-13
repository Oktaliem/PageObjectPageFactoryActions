package com.oktaliem.testsuit.angularweb.formio;

import com.oktaliem.testsuit.BaseTest;
import org.testng.annotations.Test;

public class FormRenderComponentTest extends BaseTest {

    @Test
    public void loginFormSample(){
        userIsOn.formRendererPage().execute_login_form_with_invalid_email_format();
        userIsOn.formRendererPage().error_message_displayed();
    }

}
