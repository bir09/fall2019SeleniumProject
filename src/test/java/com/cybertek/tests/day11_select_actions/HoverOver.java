package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverOver {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);   // ---> u have to use driver in order to use actions
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(3000);
        WebElement target = driver.findElement(By.tagName("img"));
        //moveToElement -> moves the mouse on top of given element
        actions.moveToElement(target).perform();
        Thread.sleep(3000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        Thread.sleep(2000);
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));


        //click() -> clicks   click(element) --> moves the mouse on that element
        // TODO multiple actions -> build, single action -> no build
        actions.moveToElement(enabled).pause(2000).
                moveToElement(download).pause(2000).
                click(pdf).build().perform();

    }

    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.dragAndDrop(money, bank).perform();
        Thread.sleep(3000);
    }


   /*
TASK
do the drag and drop by chaining actions
move mouse to source/money
mouse down
move mouse to target/bank
mouse up
 */

   @Test
   public void dragAndDrop3() throws InterruptedException {
       driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       driver.manage().window().maximize();
       WebElement money = driver.findElement(By.id("draggable"));
       WebElement bank = driver.findElement(By.id("droptarget"));
       Thread.sleep(3000);
       actions.moveToElement(money).clickAndHold().moveToElement(bank).release().build().perform();
       Thread.sleep(3000);
   }











    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
