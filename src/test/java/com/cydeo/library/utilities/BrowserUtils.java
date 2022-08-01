package com.cydeo.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrowserUtils {

//    TC : Create utility method
//1. Create a new class called BrowserUtils
//2. Create a method to make Multiple Windows logic re-usable
//3. When method is called, it should switch window and verify
//    title.
//    Method info:
//            • Name: switchWindowAndVerify
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedInUrl
//• Arg3: String expectedTitle
    public static void switchWindowAndVerify(String expectedInUrl,String expectedTitle){

        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindow);//We are able to switch one by one each window



            if(Driver.getDriver().getCurrentUrl().contains("expectedInUrl")){
                break;
            }

        }
        //        5. Assert:Title contains “Etsy”

        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed",actualTitle.contains(expectedTitle));


    }
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());


    }
    public static void waitForInvisibilityOf(WebElement element){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<String> getElementsText(List<WebElement> elements) {


        List<String> elementsText=new ArrayList<>();

        for (WebElement element : elements) {
            elementsText.add( element.getText());
        }

        return elementsText;
    }


    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }

}
