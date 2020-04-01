package com.cybertek.office_hours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers extends TestBase {

    @Test
    public void test(){
        //Which an I using
        System.out.println("Option 1");
        System.out.println(ConfigurationReader.getProperty("browser"));
        System.out.println("Option 2");
        System.out.println(driver);

        if(driver.toString().contains("FirefoxDriver")){
            System.out.println("Firefox browser");
        }else if(driver.toString().contains("Chrome")){
            System.out.println("Chrome browser");
        }

        if(driver instanceof ChromeDriver){
            System.out.println("CHROME");
        }else if(driver instanceof FirefoxDriver){
            System.out.println("FIREFOX");
        }


        
    }

}
