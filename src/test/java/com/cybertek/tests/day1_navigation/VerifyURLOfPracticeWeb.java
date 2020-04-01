package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLOfPracticeWeb {

    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to cybertek practice website
        2. verify the URL
         */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();

            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "http://practice.cybertekschool.com/";

            if (expectedUrl.equals(actualUrl)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
            Thread.sleep(3000);
            driver.close();
        }
    }
