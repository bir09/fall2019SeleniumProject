package com.cybertek.tests.day16_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {
    @BeforeMethod
    public void setup2(){
        driver.get(ConfigurationReader.getProperty("vyTrack_url"));
    }

    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("user3000");
        loginPage.password.sendKeys("UserUser123");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();

        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("SalesManager110");
        loginPage.password.sendKeys("LC");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
}
