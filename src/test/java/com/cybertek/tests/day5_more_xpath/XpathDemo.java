package com.cybertek.tests.day5_more_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cybertek.utilities.WebDriverFactory.getDriver;

public class XpathDemo {
    public static void main(String[] args) {

        WebDriver driver =getDriver("ChromeDriver");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

         WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
         //start interacting with the element
        String txt = buttonOne.getText();
        System.out.println(txt);

         WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button"));
        System.out.println(buttonTwo.getText());

         WebElement buttonThree = driver.findElement(By.xpath("//button[3]"));
        System.out.println(buttonThree.getText());

        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());



        WebElement buttonFive = driver.findElement(By.xpath("//button[5]"));
        System.out.println(buttonFive.getText());

        WebElement buttonSix = driver.findElement(By.xpath("button[@id='disappearing_button'"));
        System.out.println(buttonSix.getText());


    }
}
