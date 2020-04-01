package com.cybertek.tests.day8_review2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTests {
    public static void main(String[] args) throws InterruptedException {
        titleTest();
    }

    /*
    1. Open browser
2. Go to Vytrack login page
3. Login as any user
4. Click on your name on top right
5. Click on My Configuration
6. Verify that page title starts with the same name on top
right

     */
    private static void titleTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://qa3.vytrack.com/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        Thread.sleep(3000);
        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        profileName.click();
        String expectedTitle = profileName.getText();

        WebElement myConfig = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        myConfig.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("TITLE PASS");
        }else{
            System.out.println("TITLE FAIL");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }

        Thread.sleep(3000);
        driver.quit();


        //System.out.println(profileName.getText());
    }

}
