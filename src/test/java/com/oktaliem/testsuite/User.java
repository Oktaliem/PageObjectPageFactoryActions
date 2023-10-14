package com.oktaliem.testsuite;


import com.oktaliem.pages.LoginPage;
import com.oktaliem.pages.WebPage;
import com.oktaliem.pages.angularpage.coreui.AngularDashboardPage;
import com.oktaliem.pages.angularpage.formio.FormBuilderPage;
import com.oktaliem.pages.angularpage.formio.FormRendererPage;
import com.oktaliem.pages.flutterPage.RallyLoginPage;
import com.oktaliem.pages.reactpage.ReactDashboardPage;
import com.oktaliem.pages.vuepage.VueDashboardPage;
import com.oktaliem.pages.w3c.W3CPage;
import org.openqa.selenium.WebDriver;

public class User {
    WebDriver driver;

    public User (WebDriver driver){
        this.driver = driver;
    }

    public LoginPage loginPage(){return new LoginPage(driver);}
    public WebPage webPage(){return new WebPage(driver);}


    public AngularDashboardPage agDashboardPage(){return new AngularDashboardPage(driver);}
    public ReactDashboardPage rtDashPage(){return new ReactDashboardPage(driver);}
    public VueDashboardPage vueDashPage(){return new VueDashboardPage(driver);}

    public FormRendererPage formRendererPage(){return new FormRendererPage(driver);}
    public FormBuilderPage formBuilderPage(){return new FormBuilderPage(driver);}

    public RallyLoginPage rallyLoginPage(){return new RallyLoginPage(driver);}

    //W3C WAI-ARIA
    public W3CPage w3CPage(){return new W3CPage(driver);}

}
