package com.cybertek.mypractice;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Olympics2016 extends TestBase {
    @Test
    public void test1(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        List<WebElement> numbers = driver.findElements(By.xpath("//caption[text()='2016 Summer Olympics medal table']/../tbody/tr/td[1]"));
        List<String> numbersStr = BrowserUtils.getElementsText(numbers.subList(0, numbers.size()-2));
        List<Integer> nums = new ArrayList<>();
        for(String each : numbersStr){
            int temp = Integer.parseInt(each);
            nums.add(temp);
        }
        boolean isSorted = Ordering.natural().isOrdered(nums);
        System.out.println("Are Rank numbers sorted before clicking NOC: "+isSorted);

        WebElement nocButton = driver.findElement(By.xpath("//th[@scope='col'][text()='NOC']"));
        nocButton.click();

        List<WebElement> countriesSorted = driver.findElements(By.xpath("//*[@*='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a"));
        List<String> countriesStr = BrowserUtils.getElementsText(countriesSorted);
        boolean countriesIsSorted = Ordering.natural().isOrdered(countriesStr);
        System.out.println("Are countries sorted after clicking NOC: "+countriesIsSorted);


        List<WebElement> numbersAfterNoc = driver.findElements(By.xpath("//caption[text()='2016 Summer Olympics medal table']/../tbody/tr/td[1]"));
        List<String> numbersStrAfterNoc = BrowserUtils.getElementsText(numbersAfterNoc);
       // System.out.println(numbersStrAfterNoc);
        List<Integer> numsAfterNoc = new ArrayList<>();
        for(String each : numbersStrAfterNoc){
            if(each.equals("11–86")){
                continue;
            }
            int temp = Integer.parseInt(each);
            numsAfterNoc.add(temp);
        }
        //System.out.println(numsAfterNoc);
        boolean isSortedAfterNoc = Ordering.natural().isOrdered(numsAfterNoc);
        System.out.println("Are Rank numbers sorted before After NOC: "+isSortedAfterNoc);
        



    }
}
