package com.cybertek.mypractice;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonCart extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        String productName = firstResult.getText();
        System.out.println(productName);
        firstResult.click();
        WebElement price = driver.findElement(By.cssSelector("#price_inside_buybox"));
        String productPrice = price.getText();
        System.out.println(productPrice);
        WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart-button"));
        addToCart.click();
        WebElement goToCart = driver.findElement(By.cssSelector("#hlb-view-cart-announce"));
        goToCart.click();
        WebElement productInsideCart = driver.findElement(By.cssSelector("[class='a-size-medium sc-product-title']"));
        String productNameInCart = productInsideCart.getText();
        System.out.println(productNameInCart);
        WebElement priceInsideCart = driver.findElement(By.xpath("//p[@class='a-spacing-small']/span"));
        String productPriceInCart = priceInsideCart.getText();
        System.out.println(productPriceInCart);
        Assert.assertEquals(productName, productNameInCart);
        Assert.assertEquals(productPrice, productPriceInCart);
    }
}
