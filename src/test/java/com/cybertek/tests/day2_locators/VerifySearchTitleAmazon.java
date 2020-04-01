package com.cybertek.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifySearchTitleAmazon {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.ebay.com/");
        WebElement iphoneSearch = driver.findElement(By.name("_nkw"));
        Thread.sleep(2000);
        iphoneSearch.sendKeys("Iphone" + Keys.ENTER);



        String expectedTitle = "Iphone | eBay";

        String actualTitle = driver.getTitle();

        if (expectedTitle.contains(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);


        }
    }
}