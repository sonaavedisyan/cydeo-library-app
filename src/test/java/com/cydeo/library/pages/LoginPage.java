package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class LoginPage {
    // No page elements added
    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//label[text()='Email address']")
    public WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement getPasswordInput;
    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")
    public WebElement signinBtn;

    // No page elements added

    public  void login(String str){

        emailInput.sendKeys(ConfigurationReader.getProperty(str+ "_user"));
        passwordInput.sendKeys(ConfigurationReader.getProperty(str+ "_password"));

    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement alertMsg;
}