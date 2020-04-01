package com.cybertek.tests.day10_webElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DisabledAndDisplayedTests {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @BeforeTest
    public void beforeMethod(){
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @Test
    public void disabledTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        //isEnabled --> reurns true if the element Enabled
        System.out.println("is green enabled -> "+green.isEnabled());
        System.out.println("is black enabled -> "+black.isEnabled());
        Assert.assertTrue(green.isEnabled());
        Assert.assertFalse(black.isEnabled());
    }
    @Test
    public void disabledTestWithAttribute() throws InterruptedException{
        Thread.sleep(2000);
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        System.out.println("black -> "+black.getAttribute("disabled"));
        System.out.println("green -> "+green.getAttribute("disabled"));

        //verify certain value is null
        Assert.assertEquals(black.getAttribute("disabled"), null);
        Assert.assertNull(black.getAttribute("disabled"));

        //verify that certain value is not equal to True
        Assert.assertEquals(green.getAttribute("disabled"), null);
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));

    }
    @Test
    public void TestElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));

        //verify that username is not visible
        //isDisplayed -> returns true element we found HTML visible on page
        System.out.println("Username is visible: "+username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());

        System.out.println("click on start");
        start.click();

        Thread.sleep(5000);
        System.out.println("Username is visible: "+username.isDisplayed());
        Assert.assertTrue(username.isDisplayed());
    }



    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
