package com.cybertek.mypractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowsPractice {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@name='p']"));
        search.sendKeys("amazon"+ Keys.ENTER);
        Thread.sleep(2000);
        String parentTab = driver.getWindowHandle();
        //<p class="d-ib va-mid">
        // <a class=" pb-4 fz-14 d-b website" href="http://redirect.viglink.com?u=http%3A%2F%2Fwww.amazon.com&amp;key=1e49e2fd94ad9bb5e82b265e0fcffdfb" referrerpolicy="origin" target="_blank" title="Sponsored link by Viglink"><b>amazon</b>.com</a> </p>
        Thread.sleep(2000);
        WebElement amazon = driver.findElement(By.xpath("//p[@class='d-ib va-mid']//a"));
        amazon.click();

        Alert alert;
        try{
            alert = driver.switchTo().alert();
            alert.sendKeys("SOMETHING");
            Thread.sleep(2000);
            alert.accept();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> winsows2 = windows.iterator();
        String child = "";
        while (winsows2.hasNext()){
            child = winsows2.next();
        }
        driver.switchTo().window(child);


        String expectedAm = "https://www.amazon.com/";
        String actualAm = driver.getCurrentUrl();
        if(expectedAm.equals(actualAm)){
            System.out.println("URL PASS AMAZON");
        }else{
            System.out.println("FAIL URL AMAZON");
            System.out.println("actualAm = " + actualAm);
            System.out.println("expectedAm = " + expectedAm);
        }

        Thread.sleep(3000);
//        for(String each : windows){
//            if(!driver.getTitle().startsWith("amazon")){
//                driver.switchTo().window(each);
//                break;
//            }
//        }

        WebElement searchAmazon = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchAmazon.sendKeys("wooden spoon"+Keys.ENTER);
        Thread.sleep(2000);

        driver.switchTo().window(parentTab);
        Thread.sleep(2000);
        WebElement search2 = driver.findElement(By.xpath("//input[@name='p']"));
        search2.clear();
        search2.sendKeys("etsy"+Keys.ENTER);

        Thread.sleep(2000);
        WebElement etsyButton = driver.findElement(By.xpath("//p[@class='d-ib va-mid']//a"));
        etsyButton.click();
        Thread.sleep(2000);
        Set<String> etsyTabs = driver.getWindowHandles();
        Iterator<String> eatsyIt = etsyTabs.iterator();
        String etsyTab = "";
        while(eatsyIt.hasNext()){
            etsyTab = eatsyIt.next();
        }
        driver.switchTo().window(etsyTab);


        Thread.sleep(2000);
        WebElement etsySearch = driver.findElement(By.xpath("//input[@data-id='search-query']"));
        Thread.sleep(2000);
        etsySearch.sendKeys("wooden spoon"+Keys.ENTER);
        Thread.sleep(2000);
        driver.switchTo().window(parentTab);
        WebElement search3 = driver.findElement(By.xpath("//input[@name='p']"));
        Thread.sleep(2000);
        search3.clear();
        search3.sendKeys("йо йо йо Тахмина пиФФФФет");
        Thread.sleep(3000);
        driver.switchTo().window(child);
        Thread.sleep(3000);
    }
}
