package com.cybertek.office_hours;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class IframePractice {
    /*
    Iframe - webdocument inside of another webdocument
     */
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
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame("frame-top");
        Thread.sleep(2000);

        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        System.out.println(frameList.size());
//        driver.switchTo().frame(frameList.get(0));
//        System.out.println(driver.findElement(By.xpath("//body")).getText());
//        driver.switchTo().frame(frameList.get(1));
//        System.out.println(driver.findElement(By.id("content")).getText());
//        driver.switchTo().frame(frameList.get(2));
//        System.out.println(driver.findElement(By.xpath("//body")).getText());

        for(WebElement each: frameList){
            driver.switchTo().frame(each);
            String body_text=driver.findElement(By.tagName("body")).getText();
            System.out.println(body_text);
            driver.switchTo().parentFrame();
        }


    }
}
