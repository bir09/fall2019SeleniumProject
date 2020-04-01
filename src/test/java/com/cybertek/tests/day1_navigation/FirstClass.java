package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        //binary driver and browsers
        WebDriverManager.chromedriver().setup();
        //Webdriver object --> interface
        //I have a driver
        WebDriver driver = new ChromeDriver();

        //I wanrt to open Google home page

        //how do you launch/open a web page?
        //by using get() --> url as String
        driver.get("https://www.google.com");

        driver.navigate().to("https://soeks.ru/informaciya/lechenie-gorla-v-domashnix-uslovijax");

        //get --> wait to load the page
        //to() --> does not wait


        //navigate().back --->
        //1.go to google. 2. go ro cybertek practice website

        driver.get("https://www.google.com");
       Thread.sleep(3000);
       driver.navigate().to("http://practice.cybertekschool.com/");
       Thread.sleep(3000);

        //driver.findElement(By.linkText("Dropdown")).click();



    }
}