package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDownPractice {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void getSelectedOption(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //create Select object using webElement
        Select dropdownList = new Select(dropdown);
        //get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }
    @Test
    public void selectFromList() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("state"));
        //create Select object
        Select states = new Select(dropdown);

        //select by the text
        states.selectByVisibleText("Iowa");
        Thread.sleep(1000);
        states.selectByVisibleText("California");
        Thread.sleep(1000);
        states.selectByVisibleText("Delaware");
        Thread.sleep(1000);

        //ToDO select by index -> based on the index of the position
        states.selectByIndex(0);
        Thread.sleep(1000);
        states.selectByIndex(45);
        Thread.sleep(1000);

        //todo select by value -> selects by value attribute of the option
        //it is not select by text
        states.selectByValue("DE");
        Thread.sleep(1000);
        states.selectByValue("VA");
        Thread.sleep(1000);
        states.selectByValue("NC");
        Thread.sleep(1000);
        states.selectByValue("FL");
        Thread.sleep(1000);
    }

    @Test
    public void getAllAvailableOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));

        //print first current selection
        System.out.println(monthList.getFirstSelectedOption().getText());

        //TODO getOptions -> returns all the available options from dropdown
        List<WebElement> options = monthList.getOptions();

        for(WebElement month : options){
            System.out.println(month.getText());
        }

        String expected = LocalDate.now().getMonth().name();
        String actual = monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());

        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd 'at' ")

        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        List<String> actualMonths = new ArrayList<>();
        for(WebElement each : options){
            actualMonths.add(each.getText());
        }
        Assert.assertEquals(expectedMonths, actualMonths);
    }

    @Test
    public void verifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));
        int expectedSize = 3;
        int actualSize = list.getOptions().size();

        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");
        List<String> actualValues = new ArrayList<>();
        for(WebElement each : list.getOptions()){
            actualValues.add(each.getText());
        }

        Assert.assertEquals(expectedSize, actualSize);
        System.out.println("Expected values : "+expectedValues);
        System.out.println("Actual values: "+actualValues);
    }




    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
