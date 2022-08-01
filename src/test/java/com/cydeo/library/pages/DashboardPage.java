package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
     PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(xpath = "//main//section")
    public List<WebElement> modulesList;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersModule;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement booksModule;
}
