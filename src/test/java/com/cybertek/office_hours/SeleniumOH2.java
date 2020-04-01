package com.cybertek.office_hours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 1.Go to http://automationpractice.com
         * 2.Search for 'tshirt' in a searchboz + click enter OR click search button
         * 3. validate you got "no results" message on UI
         * 4. Search for "t-shirt"
         * 5. Validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        //WebElement - class in selenium/java and it has many useful methods
        //.sendKeys("value tht we ant to send - input tag ")
        searchBox.sendKeys("tshirt",Keys.ENTER);

        /*
        <p class = "alert alert-warning">
            No results were found for your search "tshirt"
         */

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));

        String errorText = error.getText();
        //.getText() -> returns String (text) from the element
        System.out.println("Error message: " + errorText);
        //NoSuchElementException - it means we could not locate the element
        searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.clear();
        searchBox.sendKeys("t-shirt" + Keys.ENTER);
        //StaleElementReferenceException - element is old/stale - we want to find
        //this element again OR refresh page
        Thread.sleep(3000);
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("Items found: " + count.getText());

        driver.quit();




    }
}
