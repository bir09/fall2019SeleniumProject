package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodOfXpath {
    public static void main(String[] args) {


        /*
        go to http://practice.cybertekschool.com/context_menu
        verify Context Menu is on the page
         */


        WebDriver driver = WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/context_menu");

        WebElement context = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));

        String expectedResult = "Context Menu";
        String actualResult = context.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


    }

    public static class PracticeFactory {
        public static void main(String[] args) {
            //go to google

            WebDriverManager.chromedriver().setup();

           // WebDriver driver = new ChromeDriver();

            WebDriver driver = WebDriverFactory.getDriver("ChromeDriver");

            driver.get("https://google.com");

            ///Users/JuniorKG/IdeaProjects/fall2019seleniumproject



        }
    }
}
