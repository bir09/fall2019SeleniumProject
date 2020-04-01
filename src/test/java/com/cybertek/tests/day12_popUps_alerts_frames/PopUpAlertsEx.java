package com.cybertek.tests.day12_popUps_alerts_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAlertsEx {
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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']"));
        WebElement noButton = driver.findElement(By.xpath("//span[.='No']"));
        button.click();
        Thread.sleep(2000);
        noButton.click();
        Thread.sleep(2000);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        Thread.sleep(2000);
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        Thread.sleep(2000);
        jsConfirm.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        Thread.sleep(2000);
        jsPrompt.click();
        Thread.sleep(2000);

        Alert alert;
        try{
            alert = driver.switchTo().alert();
            alert.sendKeys("SOMETHING");
            Thread.sleep(2000);
            alert.accept();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        Thread.sleep(2000);
        //we have to witch to iframe since wedpage contains two html
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        //TODO you can use id/name inside of brackets for WebElement
        //driver.switchTo().frame("mce_0_ifr");   ->
        driver.switchTo().frame(iframe);
        WebElement texBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        texBox.clear();
        texBox.sendKeys("great, thanks");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        driver.switchTo().frame(0);
        texBox.clear();
        texBox.sendKeys("great, thanks yooooo");
        Thread.sleep(2000);
    }


















}
