package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {


    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
    }
        @When("I login as a student")
        public void i_login_as_a_student () {

        }
        @Then("books should be displayed")
        public void books_should_be_displayed () {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @When("I enter username {string}")
        public void i_enter_username (String string){
            // loginPage.emailInput.sendKeys(username);
        }
        @When("I enter password {string}")
        public void i_enter_password (String string){
            //  loginPage.passwordInput.sendKeys(password);
        }
        @When("click the sign in button")
        public void click_the_sign_in_button () {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @When("there should be {int} users")
        public void there_should_be_users (Integer int1){
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }


    }

