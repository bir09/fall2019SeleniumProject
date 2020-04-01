package com.cybertek.mypractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsPractice2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com");

        WebElement autoComplete = driver.findElement(By.xpath("//a[@href=\"/autocomplete\"]")); ////a[@href="/autocomplete"]
        System.out.println(autoComplete.getText()); //Autocomplete
        Thread.sleep(1500);

        WebElement contextMenuLink = driver.findElement(By.xpath("//a[.='Context Menu']"));
        contextMenuLink.click();
        Thread.sleep(2000);
        driver.close();


    }
}