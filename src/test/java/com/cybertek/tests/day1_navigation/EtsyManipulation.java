package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class EtsyManipulation {
    public static void main(String[] args) {

        /*
        1. Go to google webstite
2. save the title in a string variable
3. go to Etsy
4. save the Etst Title in a String
5. Navigate back to previouse page
6. Verify the title is same as step 2
7. Navigate forward to previous page
8.Verify the title is same as step 4

         */
        WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.google.com");
            String title = "Google";
            String expectedTitle = driver.getTitle();
            driver.navigate().to("https://www.etsy.com");

            String titleEtsy = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
            String expectedTitleEtsy = driver.getTitle();

            driver.navigate().back();

            if (title.equals(expectedTitle)){
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }

            driver.navigate().forward();

            if (titleEtsy.equals(expectedTitleEtsy)){
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }

            driver.close();




    }
}
