package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Creating a private constructor we are closing access to the object of this class from the outside the class
    private Driver() {
    }


    // We make WebDriver private, because we want to close access from outside of class
    //We make it static, because we will use it inside static method
   // private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>();


    public static WebDriver getDriver() {
        //it will check if driver is null and if it is we will set up browser inside of statements
        //if you already setup driver and using it again for following line of codes, it will return to same driver
        if (driverPool.get() == null) {

       // We read browserType from Configurstion.properties with
       //help of ConfigurationReader class'getProperty()method
         String browserType= ConfigurationReader.getProperty("browser");

         switch (browserType){
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driverPool.set(new ChromeDriver());
                 driverPool.get().manage().window().maximize();
                 driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driverPool.set(new FirefoxDriver());
                 driverPool.get().manage().window().maximize();
                 driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                 break;

         }

        }
        return driverPool.get();

    }
    public static void closeDriver(){   // it is static because we want to call them with class name

        if(driverPool.get() !=null){
            driverPool.get().quit();//this line terminate the existing driver session. with using this driver will
            driverPool.remove();
        }

    }
}
