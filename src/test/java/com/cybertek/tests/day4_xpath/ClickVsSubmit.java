package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSubmit {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Go to forgot password Web-Page
         * http://practice.cybertekschool.com/forgot_password
         * 2. enter any email
         * 3. click "
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1500);
        //WebElement passwordBox =
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input")).sendKeys("Cybertek124");
        Thread.sleep(2000);

       // driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button/i")).click();
        driver.findElement(By.id("form_submit")).submit();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actual = driver.getCurrentUrl();
        Thread.sleep(1500);

        if (expectedUrl.equals(actual)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        WebElement text = driver.findElement(By.name("confirmation_message"));

        String expectedResult = "Your e-mail's been sent!";
        String actualResult = text.getText();
        if (expectedResult.equals(actualResult)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }













    }
}
