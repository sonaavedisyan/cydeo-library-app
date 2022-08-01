package com.cydeo.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- we are creating property object
    //2-making private to be inaccessible from outside
    //3=we make it static,because static runs first and we will use this object under static method
    private static Properties properties = new Properties();

    // make it static,because static runs first
    static {
        //  - create FileName object to open file as a stream in Java memory
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file);
        } catch (IOException e) {
            System.out.println("File did not found in ConfigurationReader class");
           // e.printStackTrace();

        }

    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }
}
