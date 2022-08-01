package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1LibraryLogin_stepDef {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();



    @Then("verify that there are {int} modules on the page")
    public void verify_that_there_are_modules_on_the_page(Integer int1) {


        Integer actualModule = dashboardPage.modulesList.size();
        Assert.assertEquals(int1,actualModule);

    }


    @Then("verify the title is {string}")
    public void verifyTheTitleIs(String arg0) {
        BrowserUtils.verifyTitle(arg0);
    }

    @Given("{string} is on the LoginPage")
    public void isOnTheLoginPage(String arg0) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("{string} enters valid email and password")
    public void entersValidEmailAndPassword(String arg0) {
        loginPage.login(arg0);
    }

    @And("{string} clicks {string}")
    public void clicks(String user, String button) {
        switch (button){
            case "sign in button":
                loginPage.signinBtn.click();
                break;
        }
    }

    @Then("verify the url is {string}")
    public void verifyTheUrlIs(String arg0) {
        Assert.assertEquals(arg0,Driver.getDriver().getCurrentUrl());
    }

    @When("{string} enters invalid\\/valid email and password")
    public void entersInvalidValidEmailAndPassword(String arg0) {
        loginPage.login(arg0);
    }

    @Then("verify that the error message {string}")
    public void verifyThatTheErrorMessage(String arg0) {
        Assert.assertEquals(arg0,loginPage.alertMsg.getText());
    }
}
