package com.cybertek.mypractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverOverPractice {
    WebDriver driver;
    Actions act;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        act = new Actions(driver);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(2000);
        WebElement dresses = driver.findElement(By.cssSelector("a[title='Evening Dresses']"));
        WebElement eveningDresses = driver.findElement(By.cssSelector("a[title='Evening Dresses']"));
        //act.moveToElement(dresses).moveToElement(eveningDresses).click(eveningDresses).build().perform();
        System.out.println(eveningDresses.getText());
    }

}
