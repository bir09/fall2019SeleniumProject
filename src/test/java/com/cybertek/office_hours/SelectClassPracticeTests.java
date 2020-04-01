package com.cybertek.office_hours;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SelectClassPracticeTests {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*
go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
verify that table has dropdown with values Family, Friends, Coworkers, Businesses, Contacts
select option Coworkers
verify that that Coworkers is now selected
select options Contacts
verify that contacts is selected
 */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1'")));
        List<WebElement> allOptionsEl = categories.getOptions();
        System.out.println("allOptionsEl.size() = " + allOptionsEl.size());
        List<String> expectedDropdown = new ArrayList<>();
        expectedDropdown.add("Family");
        expectedDropdown.add("Friends");
        expectedDropdown.add("Coworkers");
        expectedDropdown.add("Businesses");
        expectedDropdown.add("Contacts");

        List<String> list = BrowserUtils.getElementsText(allOptionsEl);

        Assert.assertEquals(expectedDropdown, list);
    }

    /*
 go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
select option Coworkers
verify that that Coworkers is now selected
select options Contacts
verify that contacts is selected
 */
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1'")));


    }
}
