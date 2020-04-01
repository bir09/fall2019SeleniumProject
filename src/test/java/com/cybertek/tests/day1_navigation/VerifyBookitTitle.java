package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyBookitTitle {
    public static void main(String[] args) {

           WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");

    String expectedTitle = "bookit";

    String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
        System.out.println("PASS");
    } else {
        System.out.println("FAIL");
        System.out.println("I expected " + expectedTitle);
        System.out.println("The actual title is " + actualTitle);
}
}
}