package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       // WebElement button = driver.findElement(
       //                                 By.cssSelector("#disappearing_button"));

        WebElement button = driver.findElement(
                                                By.cssSelector(".col-md-4"));
        System.out.println(button.getText());




    }
}
