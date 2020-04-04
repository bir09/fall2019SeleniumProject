package com.cybertek.tests;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class WebTablesPractice extends TestBase {
    @BeforeMethod
    public void setUpTests() {
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("10");
        driver.findElement(By.id("preview")).click();
    }

    @Test
    public void testHeaderCount() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");
        WebElement table = driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());
        //get all the in the table
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(), 6);
    }

    @Test
    public void verifyGender() {
        List<WebElement> allGenders = driver.findElements(By.xpath("//table[@style]/tbody/tr[1]/td[5]"));
        System.out.println(allGenders.size());
        //go through the list
        //verify that values is either Male or Female
        for (WebElement gender : allGenders) {
            String actual = gender.getText();
            Assert.assertTrue(actual.equals("Male") || actual.equals("Female"));
        }
    }
}