package com.cybertek.tests.day12_popUps_alerts_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsEx {
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
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        // get all the available tabs
        Set<String> windowHandles = driver.getWindowHandles();

        // print all the windows handles
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
        }

        // get the id of current window/tab
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("BEFORE SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            Thread.sleep(2000);
            if (driver.getTitle().equals("driver.getWindowHandles();")) {
                break;
            }
        }

        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());




    }
}
