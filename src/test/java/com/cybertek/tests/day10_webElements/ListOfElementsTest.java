package com.cybertek.tests.day10_webElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterTest() {
       driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //   driver.findElements --> returns a LIST of element
        // if the locator does not match anhytihg, it does not throw exception, it just returns empty list

        List<WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected());
        }
    }

    @Test
    public void getAllLinksTest(){
        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("links size: "+links.size());
        //get the text of each link and print

        for(WebElement each : links){
            System.out.println(each.getText());
        }
    }

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://amazon.com/");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels"+ Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        System.out.println("Number of results -> "+allResults.size());
        System.out.println("First result: "+allResults.get(0).getText());
        System.out.println("Last result: n"+allResults.get(allResults.size()-1).getText());

    }

    @Test
    public void test2() throws InterruptedException {
        Random randomList = new Random();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> sports = driver.findElements(By.name("sport"));
        for(WebElement each: sports){
            Assert.assertFalse(each.isSelected());
        }

        for(int outer = 0; outer < 4; outer++) {
            int random = randomList.nextInt(4);
            Thread.sleep(2000);
            sports.get(random).click();
            //sports.get(outer).click();

            for (int i = 0; i < sports.size(); i++) {
                if (i == random) {
                    Assert.assertTrue(sports.get(i).isSelected());
                } else {
                    Assert.assertFalse(sports.get(i).isSelected());
                }

            }
        }


    }



}
