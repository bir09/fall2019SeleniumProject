package com.cybertek.office_hours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyTests extends TestBase {

    @Test
    public void verifyCountryList(){
        driver.get("https://www.etsy.com/");
        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));
        input.sendKeys("wooden spoon"+ Keys.ENTER);
        String expectedTitle = "Wooden spoon | Etsy";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(driver.getTitle(), expectedTitle);

       // driver.findElement(By.linkText("All categories")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));


        String expectedDefaultCountry = "United States";
        String actualtDefaultCountry = shipToList.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(actualtDefaultCountry, expectedDefaultCountry);

        List<String> options = BrowserUtils.getElementsText(shipToList.getOptions());
        Assert.assertTrue(options.contains("Australia"));

//        WebElement freeShipping = driver.findElement(By.name("free_shipping"));
//        Assert.assertFalse(freeShipping.isSelected());
//        freeShipping.click();
//        Assert.assertTrue(freeShipping.isSelected());

        WebElement freeShipping = driver.findElement(By.xpath("//label[.='FREE shipping']"));
        freeShipping.click();

        Assert.assertTrue(freeShipping.isSelected());

    }




    @Test
    public void test1(){
        //which browser am i using

    }



}
