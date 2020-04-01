package com.cybertek.tests.day14_testBase_Props_Driver;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExample {

    @Test
    public void test(){

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));


        // browser url
        // Properties --> class from java that saves key value combinations
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertekschool.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name= " + browser);

        //i need the browser/url from properties file

        String pUrl = ConfigurationReader.getProperty("url");
        String pBrowser = ConfigurationReader.getProperty("browser");

        System.out.println("pUrl = " + pUrl);
        System.out.println("pBrowser = " + pBrowser);

    }
    @Test
    public void test2(){
        String str = Singleton.getInstance();
        System.out.println(str);

    }
}
