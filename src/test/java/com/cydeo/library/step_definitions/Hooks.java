package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup (){

//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//
//
    }
    LoginPage loginPage=new LoginPage();

//    @Before("@librarianLogin")
//    public void librarianLogin(){
//        loginPage.login("librarian");
//
//    }


    @After
    public void teardownScenario(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());


        }

        Driver.closeDriver();
    }
}
