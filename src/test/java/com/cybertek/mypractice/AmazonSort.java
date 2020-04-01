package com.cybertek.mypractice;

import com.cybertek.utilities.WebDriverFactory;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonSort {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        WebElement allEl = driver.findElement(By.id("searchDropdownBox"));
        Select allDep = new Select(allEl);
        Assert.assertEquals(allDep.getFirstSelectedOption().getText(), "All Departments");
        List<WebElement> listAll = allDep.getOptions();
        List<String> allDepList = new ArrayList<>();
        for(WebElement each : listAll){
            allDepList.add(each.getText());
        }
        //Collections.sort(allDepList);
        boolean sorted = Ordering.natural().isOrdered(allDepList);
        Assert.assertFalse(sorted);

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.amazon.com/gp/site-directory");
        Thread.sleep(2000);
        List<WebElement> listOfDep = driver.findElements(By.className("fsdDeptTitle"));
        List<String> listOfDep2 = new ArrayList<>();
        for(WebElement each : listOfDep){
            listOfDep2.add(each.getText());
        }

        WebElement allButton = driver.findElement(By.id("searchDropdownBox"));
        Select allList = new Select(allButton);
        List<WebElement> listAll = allList.getOptions();
        List<String> listAll2 = new ArrayList<>();
        for(WebElement each : listAll){
            listAll2.add(each.getText());
        }

//        for(String each : listOfDep2){
//            Assert.assertTrue(listAll2.contains(each));
//        }
        for(String each : listOfDep2){
            System.out.println(each);
        }
    }

    @Test
    public void test3(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a[*=*]"));
        for(WebElement each : listOfLinks){
            System.out.print(each.getAttribute("href")+" -> ");
            System.out.println(each.isDisplayed());

        }
    }

    @Test
    public void testPrice() throws InterruptedException {
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);

        search.sendKeys("wooden spoon"+ Keys.ENTER);
        //<input type="checkbox" name="" value="" checked="">
        //<i class="a-icon a-icon-checkbox"></i>
        WebElement under25 = driver.findElement(By.xpath("//li[@aria-label='Free Shipping by Amazon']//i"));
        under25.click();
        Thread.sleep(2000);

        //<span class="a-offscreen">$8.97</span>
        List<WebElement> pricesWhole = driver.findElements(By.className("a-price-whole"));
        List<WebElement> pricesDecimal = driver.findElements(By.className("a-price-fraction"));
        List<String> prices = new ArrayList<>();
        for(int i = 0; i < pricesDecimal.size(); i++){
            String whole = pricesWhole.get(i).getText();
            String decimal = pricesDecimal.get(i).getText();
            prices.add(whole+"."+decimal);
        }
        //System.out.println(prices);
        List<Double> pricesNumbers = new ArrayList<>();
        for(int i = 0; i < prices.size(); i++){
            double temp = Double.parseDouble(prices.get(i));
            pricesNumbers.add(temp);
            if(pricesNumbers.get(i) < 25){
                System.out.println(pricesNumbers.get(i));
            }
        }



    }
}
