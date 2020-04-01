package com.cybertek.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) {
        /**
         * <div id="login-bg-image" class="login-bg-image" data-se="login-bg-image" style="background-image: none"></div>
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.okta.com");
        driver.manage().window().maximize();

        WebElement emailBox = driver.findElement(By.id("okta-signin-username"));
       // WebElement passwordBox = driver.findElement(By.id("okta-signin-password"));

        emailBox.sendKeys("Jumgal91@gmail.com");

        driver.findElement(By.id("okta-signin-password")).sendKeys("rerfYm-jyhfyz-8qigto");



        driver.findElement(By.id("okta-signin-submit")).click();











    }
}
