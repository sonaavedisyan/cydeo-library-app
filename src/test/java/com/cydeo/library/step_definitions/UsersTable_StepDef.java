package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTable_StepDef {
    UsersPage usersPage=new UsersPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String link) {
        BrowserUtils.waitForVisibility(usersPage.dashboardLink);
       switch (link.toLowerCase()){
           case "dashboard":
               usersPage.dashboardLink.click();
               break;
           case "users":
               usersPage.userLink.click();
               break;
           case "book":
               usersPage.bookLink.click();
               break;
       }
    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<WebElement>expectedTableHeader) {
        List<String>actualTableHeader=BrowserUtils.getElementsText(usersPage.usersTableHeader);
        Assert.assertEquals(expectedTableHeader,actualTableHeader);

    }
}
