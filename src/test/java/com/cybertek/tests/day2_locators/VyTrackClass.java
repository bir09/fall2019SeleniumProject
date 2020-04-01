package com.cybertek.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackClass {
    public static void main(String[] args) throws InterruptedException {
        /**
         * <div id="login-bg-image" class="login-bg-image" data-se="login-bg-image" style="background-image: none"></div>
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        WebElement emailBox = driver.findElement(By.id("prependedInput"));
        // WebElement passwordBox = driver.findElement(By.id("okta-signin-password"));

        emailBox.sendKeys("storemanager52");
        Thread.sleep(2000);

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(2000);


        driver.findElement(By.id("_submit")).click();


        String expectedUrl = "https://app.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
}
}