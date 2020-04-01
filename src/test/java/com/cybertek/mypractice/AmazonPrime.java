package com.cybertek.mypractice;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonPrime extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        WebElement firstPrimeResult = driver.findElement(By.xpath("//i[@class='a-icon a-icon-prime a-icon-medium']/../../../../../../div[2]/h2/a/span"));
        System.out.println(firstPrimeResult.getText());
        String firstPrimeLabelText = firstPrimeResult.getText();

        WebElement primeButton = driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']"));
        primeButton.click();
        //Thread.sleep(3000);

        WebElement firstResultInPrime = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        String firstResultInPrimeText = firstResultInPrime.getText();

        Assert.assertEquals(firstResultInPrimeText, firstPrimeLabelText);
    }

}
