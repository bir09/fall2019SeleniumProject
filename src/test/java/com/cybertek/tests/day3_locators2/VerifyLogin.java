package com.cybertek.tests.day3_locators2;

import com.google.gson.internal.$Gson$Preconditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("tomsmith");
        Thread.sleep(1500);
        WebElement password = driver.findElement(By.name("password"));
        Thread.sleep(1500);
       // password.sendKeys("SuperSecretPassword" + Keys.ENTER);
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(1500);
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement text = driver.findElement(By.tagName("h4"));

        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String actualResult = text.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("pASS");
        } else {
            System.out.println("fail");
        }



    }
}
