package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));

        System.out.println(link.getText());

        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));
        String text =example3_2.getText();

        System.out.println(text);

        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School"));
        System.out.println(cybertekSchool.getText());

        String textVersion = cybertekSchool.getText();

        //locate the element: Home

        /**
         * Locators:
         * ID
         */






    }
}
