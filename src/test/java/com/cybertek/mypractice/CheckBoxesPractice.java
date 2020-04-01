package com.cybertek.mypractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckBoxesPractice {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        Random rand = new Random();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(3000);
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        List<WebElement> enabledBoxes = new ArrayList<>();

        for(WebElement each : boxes){
            if(each.isEnabled()){
                enabledBoxes.add(each);
            }
        }

        List<WebElement> days3 = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::*"));
        List<String> days2 = new ArrayList<>();

        for (int i = 0; i < days3.size(); i++) {
            if(boxes.get(i).isEnabled()){
                days2.add(days3.get(i).getText());
            }
        }

        System.out.println("Days are enabled: "+days2);

        int friday = 0;
        do {
            int number = rand.nextInt(5);
            for (int i = 0; i < 3; i++) {
                boxes.get(number).click();
                Thread.sleep(1000);
                System.out.println(days2.get(number));
                Assert.assertTrue(boxes.get(number).isSelected());
                if(boxes.get(4).isSelected()){
                    friday++;
                }
                boxes.get(number).click();
                Assert.assertFalse(boxes.get(number).isSelected());

            }
        }while(friday < 3);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(2000);
        //verify that dropdowns under Select your date of birth display current year, month,day
        LocalDateTime now = LocalDateTime.now();
        String expectedYear = now.getYear()+"";
        String expectedMonth = LocalDate.now().getMonth().name();
        String expectedDay = now.getDayOfMonth()+"";
        System.out.println("Expected: "+expectedYear+", "+expectedMonth+", "+expectedDay);

        WebElement elementYear = driver.findElement(By.id("year"));
        WebElement elementMonth = driver.findElement(By.id("month"));
        WebElement elementDay = driver.findElement(By.id("day"));

        Select selectYear = new Select(elementYear);
        Select selectMonth = new Select(elementMonth);
        Select selectDay = new Select(elementDay);

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();
        System.out.println("Actual: "+actualYear+", "+actualMonth+", "+actualDay);

        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualDay, actualDay);
        Assert.assertEquals(actualMonth.toLowerCase(), expectedMonth.toLowerCase());
    }


}
