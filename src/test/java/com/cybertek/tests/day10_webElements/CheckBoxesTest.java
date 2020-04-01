package com.cybertek.tests.day10_webElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxesTest {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        @BeforeTest
        public void beforeMethod(){
            driver.get("http://practice.cybertekschool.com/checkboxes");
        }

        @Test
        public void test1(){
            WebElement one = driver.findElement(By.xpath("//input[1]"));
            WebElement two = driver.findElement(By.xpath("//input[2]"));
            //by default one is not checked, two is checked
            System.out.println("one Selected -> "+one.isSelected());
            System.out.println("two Selected -> "+two.isSelected());

            Assert.assertFalse(one.isSelected());
            Assert.assertTrue(two.isSelected());

            System.out.println("Check the first box");
            one.click();
            System.out.println("one Selected -> "+one.isSelected());
            System.out.println("two Selected -> "+two.isSelected());

            Assert.assertTrue(one.isSelected());
            Assert.assertTrue(two.isSelected());
        }





        @AfterTest
        public void afterTest(){
        driver.quit();
    }

}
