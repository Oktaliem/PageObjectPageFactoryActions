package com.oktaliem.testsuite;

import com.oktaliem.pages.Path;
import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


/**
 * Author : Okta Liem
 */
public class UnitTest extends BaseTest{

    /**
     * “If you have WebDriver APIs in your test methods, You're Doing It Wrong.” Simon Stewart
     */

    @Test(description ="Page Factory - input and click ")
    public void TC01(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().loginSamplePF();
    }

    @Test(description = "Page Object - input and click ")
    public void TC02(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().loginSamplePO();
    }

    @Test(description = "General - refresh page")
    public void TC03(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().refreshPage();
    }

    @Test(description = "General - Open and Switch Tab")
    public void TC04(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().openNewTab();
        userIsOn.loginPage().switchToSecondBrowser();
        userIsOn.loginPage().wait(3000);
        userIsOn.loginPage().switchToFirstBrowser();
        userIsOn.loginPage().wait(2000);
    }

    @Test(description = "Page Factory - Get and Verify Text")
    public void TC05(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().getTextSamplePF();
    }

    @Test(description = "Page Object - Get and Verify Text")
    public void TC06(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().getTextSamplePO();
    }

    @Test(description = "General - Go back and go forward on web page")
    public void TC07(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().wait(3000);
        userIsOn.loginPage().goToPreviousPage();
        userIsOn.loginPage().wait(3000);
        userIsOn.loginPage().goToNextPage();
        userIsOn.loginPage().wait(3000);
    }

    @Test(description = "General - Click via Javascript")
    public void TC08(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().login();
    }

    @Test(description = "General - Get HTML source")
    public void TC09() throws IOException {
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().getHtmlSource("loginPage");
    }

    @Test(description = "Page Factory - Dropdown Test")
    public void TC10() {
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().login();
        userIsOn.loginPage().openDropDownMenu();
        userIsOn.loginPage().goToSettingPagePF();
    }

    @Test(description = "Page Object - Dropdown Test")
    public void TC11() {
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().login();
        userIsOn.loginPage().openDropDownMenu();
        userIsOn.loginPage().goToSettingPagePO();
    }

    @Test(description = "Page Factory - Select CheckBox")
    public void TC12(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().login();
        userIsOn.loginPage().openDropDownMenu();
        userIsOn.loginPage().goToSettingPagePO();
        userIsOn.settingPage().selectAllName();
    }

    @Test(description = "General - Get Login Page URL")
    public void TC13(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().login();
        userIsOn.loginPage().getLoginPageURL();
    }

    @Test(description = "General - Get Value with Regex")
    public void TC14() throws IOException {
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().getCSRFToken();
        //This test is intended to fail
    }


    @Test(description = "General - Scroll Up and Scroll Down ")
    public void TC15(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().scrollToBottomPage();
        userIsOn.seleniumPage().wait(3000);
        userIsOn.seleniumPage().scrollToTopPage();
        userIsOn.seleniumPage().wait(3000);
    }

    @Test(description = "Page Object - Scroll until view element")
    public void TC16(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPO();
    }

    @Test(description = "Page Factory - Scroll until view element")
    public void TC17(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPF();
    }

    @Test(description = "Page Factory - Double Click")
    public void TC18(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPF();
        userIsOn.seleniumPage().doubleClickMoreNewsButtonPF();
    }

    @Test(description = "Page Object - Double Click")
    public void TC19(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPO();
        userIsOn.seleniumPage().doubleClickMoreNewsButtonPO();
    }

    @Test(description = "Page Object - Move Mouse Pointer")
    public void TC20(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPO();
        userIsOn.seleniumPage().movePointerToNewsButtonPO();
    }

    @Test(description = "Page Factory - Move Mouse Pointer")
    public void TC21(){
        userIsOn.seleniumPage().goToSeleniumOfficialWeb();
        userIsOn.seleniumPage().gotToMoreNewsButtonPF();
        userIsOn.seleniumPage().movePointerToNewsButtonPF();
    }

    @Test(description = "drag and drop action - Page Factory")
    public void TC22(){
        userIsOn.seleniumPage().goToW3SchoolDropAndDropPage();
        userIsOn.seleniumPage().performDragAndDropPF();
    }

    @Test(description = "drag and drop action - Page Object")
    public void TC23(){
        userIsOn.seleniumPage().goToW3SchoolDropAndDropPage();
        userIsOn.seleniumPage().performDragAndDropPO();
    }

    @Test(description ="Page Factory - input and tab and enter ")
    public void TC24(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().loginSamplePFWithTabEnter();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC25(){
        userIsOn.loginPage().launchTheApplication();
        userIsOn.loginPage().loginSamplePOWithTabAndEnter();
    }

    @Test(description ="Page Factory - input and tab and enter ")
    public void TC26(){
        userIsOn.seleniumPage().launchTheApplicationGuru99();
        userIsOn.seleniumPage().goToTestingAndClickCucumberPF();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC27(){
        userIsOn.seleniumPage().launchTheApplicationGuru99();
        userIsOn.seleniumPage().goToTestingAndClickCucumberPO();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC28(){
        userIsOn.seleniumPage().launchTheApplicationGuru99();
        userIsOn.seleniumPage().waitViaJavaScriptExecutor();
    }

    @Test(description = "General - Execute Javascript ")
    public void TC29(){
        userIsOn.seleniumPage().launchTheApplicationGuru99();
        userIsOn.seleniumPage().wait(5000);
        userIsOn.seleniumPage().wait(5000);
        userIsOn.seleniumPage().executeViaJSExecutor("alert(\"Hello World!\")");
        userIsOn.seleniumPage().wait(5000);
        userIsOn.seleniumPage().handleJavascriptPopUp("Hello World!");
        userIsOn.seleniumPage().executeViaJSExecutor("window.confirm(\"sometext\");");
        userIsOn.seleniumPage().wait(5000);
        userIsOn.seleniumPage().handleJavascriptPopUp("cancel");
        userIsOn.seleniumPage().executeViaJSExecutor("window.prompt(\"sometext\",\"defaultText\");");
        userIsOn.seleniumPage().wait(5000);
        userIsOn.seleniumPage().handleJavascriptPopUp("defaultText");
        userIsOn.seleniumPage().refreshPageViaJSExecutor();
        userIsOn.seleniumPage().executeViaJSExecutor("window.open()");
        userIsOn.seleniumPage().executeViaJSExecutor("window.focus()");
        userIsOn.seleniumPage().executeViaJSExecutor("screen.height");
    }

    @Test(description = "General - Login with javascript executor (Negative Scenario) ")
    public void TC30(){
        userIsOn.loginPage().executeViaJSExecutor("window.location=\"http://localhost/web/login/\";");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().executeViaJSExecutor("document.getElementById('login').value='bitnami'");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().executeViaJSExecutor("document.getElementById('password').value='test'");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().executeViaJSExecutor("document.getElementsByClassName('btn-primary')[0].style.backgroundColor='red'");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().executeViaJSExecutor("document.getElementsByClassName('btn-primary')[0].click()");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().executeViaJSExecutor("document.body.style.zoom='50'");
        userIsOn.loginPage().wait(2000);
    }


    @Test(description = "General - Login with javascript executor (Positive Scenario) ")
    public void TC31(){
        userIsOn.loginPage().executeViaJSExecutor("window.location=\"http://localhost/web/login/\";");
        userIsOn.loginPage().executeViaJSExecutor("document.getElementById('login').value='user@example.com'");
        userIsOn.loginPage().executeViaJSExecutor("document.getElementById('password').value='bitnami'");
        userIsOn.loginPage().executeViaJSExecutor("document.getElementsByClassName('btn-primary')[0].click()");
    }

    @Test(description = "General - Keyboard Action ")
    public void TC32() {
        userIsOn.loginPage().goToWeb(Path.LOGIN_PAGE_URL);
        userIsOn.loginPage().inputUserName("test123");
        userIsOn.loginPage().inputUserName(Keys.chord(Keys.COMMAND, "a")); //still not as expected
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.BACK_SPACE);
        userIsOn.loginPage().performKeyboardAction(Keys.BACK_SPACE);
        userIsOn.loginPage().performKeyboardAction(Keys.chord(Keys.COMMAND, "C")); //still not as expected
        userIsOn.loginPage().wait(5000);
        userIsOn.loginPage().performKeyboardAction(Keys.TAB);
        userIsOn.loginPage().performKeyboardAction(Keys.chord(Keys.COMMAND, "V")); //strill not as expected
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.TAB);
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.ENTER);
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardInputAction("test");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.TAB);
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardInputAction("test");
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.ENTER);
        userIsOn.loginPage().wait(2000);

        userIsOn.loginPage().goToWeb(Path.SELENIUM_WEB);
        userIsOn.loginPage().wait(2000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(1000);
        userIsOn.loginPage().performKeyboardAction(Keys.ARROW_DOWN);
        userIsOn.loginPage().wait(7000);
    }

    @Test(description = "Page Object - Page Factory Drop Down list")
    public void TC33(){
        userIsOn.seleniumPage().goToWeb("https://www.w3schools.com/css/tryit.asp?filename=trycss_forms");
        userIsOn.seleniumPage().selectCountryDropDownList();
    }

    @Test(description = "Page Object - Page Factory Radio button by Text")
    public void TC34(){
        userIsOn.seleniumPage().goToWeb("https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_form_radio_inline&stacked=h");
        userIsOn.seleniumPage().selectRadioW3SchoolText();
    }

    @Test(description = "Page Object- Page Factory Radio Button by Value")
    public void TC35(){
        userIsOn.seleniumPage().goToWeb("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_radio_value3");
        userIsOn.seleniumPage().selectRadioW3SchoolValue();
    }

    @Test(description = "Page Object - Page Factory Upload File")
    public void TC36(){
        userIsOn.seleniumPage().goToWeb("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        userIsOn.seleniumPage().uploadFilePOPF();
    }

    @Test(description = "General - Some javascript find element")
    public void TC37(){
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().performSomeJSFindElement();
    }

    @Test(description = "Page Object Page Factory - Check text contains")
    public void TC38(){
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().checkIfElementContainsExpectedResult();
    }


    @Test(description = "General - Highlight Element and save")
    public void TC39() throws IOException {
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().highlightPasswordFieldAndSave();
    }

    @Test(description = "Page Object Page Factory - Double chain alements")
    public void TC40(){
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().inputUserNameByChainElements();
    }

    @Test(description = "Sikuli - perform Sikuli action")
    public void TC41() throws FindFailed {
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().loginWithSikuli(); // return false positive , unable to click but test succeed,
        // Sikuli works well for non-web UI
        }

    @Test(description = "General - Several waiting Methods")
    public void TC42() throws AWTException {
        userIsOn.loginPage().goToWeb("http://localhost/web/login");
        userIsOn.loginPage().waitingGame();
    }

    @Test(description = "General - Autocomplete element")
    public void TC43(){
        userIsOn.seleniumPage().goToWeb("https://codepen.io/matt-west/full/jKnzG");
        userIsOn.seleniumPage().selectTags("HTML");
    }


}
