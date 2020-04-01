package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FakerPractice {
    public static void main(String[] args) {

        //create Faker object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        Faker faker = new Faker();
        String username = faker.name().fullName();
        String password = faker.app().author();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("wooden_spoon")).click();

       // String gameOfThrones = fakerData.gameOfThrones().character().toString();



//        for (int i = 0; i < 10000; i++) {
//            String gameOfThrones = fakerData.gameOfThrones().character().toString();
//            switch (gameOfThrones) {
//                case "John Snow":
//                    System.out.println("gameOfThrones = " + gameOfThrones);
//                    break;
//            }


        }
    }