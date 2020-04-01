package com.cybertek.office_hours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitPractice extends TestBase {
    @Test
    public void testWait() throws InterruptedException {
        driver.get("http://qa3.vytrack.com");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Login"));

        WebElement emailInput = driver.findElement(By.cssSelector("#prependedInput"));
       // wait.until(ExpectedConditions.visibilityOf(emailInput));
        WebElement passwordInput = driver.findElement(By.cssSelector("#prependedInput2"));
        //wait.until(ExpectedConditions.visibilityOf(passwordInput));
        WebElement submit = driver.findElement(By.id("_submit"));


        emailInput.sendKeys("salesmanager110");
        passwordInput.sendKeys("UserUser123");
        submit.click();

        WebElement accounts = driver.findElement(By.xpath("//ul[@class='quick-launchpad-toolbar']/li/a"));
        wait.until(ExpectedConditions.elementToBeClickable(accounts));
        accounts.click();

        Thread.sleep(3000);


    }
}
