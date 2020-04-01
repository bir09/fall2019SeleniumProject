package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        /*
        1. Go to cybertek practice web site
        2. Verify Title expected title: Practice

        Actual title ? --->
        http://practice.cybertekschool.com
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com");

        String expectedTitle = "Practice";
        driver.manage().window().fullscreen();
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The acrual title is " + actualTitle);


        }

    }
}
