package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static void main(String[] args) {
        getDriver("ChromeDriver");
    }
    //write  a return method which returns WebDriver
    //name: getDriver
    //it takes a String as a parameter --> browser type
    //returns ChromeDriver and FirefoxDriver

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        browser = browser.toLowerCase();
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
           // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.gecko.driver", "/Users/armanbirmagambetov/Downloads/geckodriver");
            driver = new FirefoxDriver();

        } else {
            System.out.println("Check your condition");
        }
        return driver;

    }
}



