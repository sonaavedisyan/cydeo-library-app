package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class BasePage {
    // No page elements added

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboardLink;
    @FindBy(xpath = "//span[.='Users']")
    public WebElement userLink;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement bookLink;

    @FindBy(xpath = "//span[.='navbarDropdown']")
    public WebElement userNameLink;

}