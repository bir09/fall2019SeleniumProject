package com.cybertek.tests.day10_webElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonsTest {
    WebDriver driver = WebDriverFactory.getDriver("Chrome");
    @BeforeTest
    public void beforeMethod(){
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @Test
    public void test1(){
        WebElement blue = driver.findElement(By.id("blue"));
        //isSelected ---> returns true if element is selected
        //System.out.println("blue.isSelected(): "+blue.isSelected());

        //verify is the button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        //print red is not selected
        //System.out.println("!red.isSelected()--> "+!red.isSelected());

        Assert.assertFalse(red.isSelected());
    }

    @Test
    public void test2(){
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        System.out.println("red.isSelected()--> "+red.isSelected());
        Assert.assertTrue(red.isSelected());
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
