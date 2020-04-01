package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {
        //go to practice login page
        //locate username box with absolute xpath
        //locate username box with relative xpath


        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("ChromeDriver");

        WebElement relativeXpath = driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input")); //relative

        WebElement fullXpath = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[2]/div/input")); //Absolute











    }
}
