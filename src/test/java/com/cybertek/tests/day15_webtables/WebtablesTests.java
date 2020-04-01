package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebtablesTests extends TestBase {

    @BeforeMethod
    public void setUpTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        WebElement sortDataTables = driver.findElement(By.linkText("Sortable Data Tables"));
        sortDataTables.click();
    }
    @Test
    public void printTable(){
        WebElement myTable = driver.findElement(By.id("table1"));
        //System.out.println(myTable.getText());

        WebElement headOfTable = driver.findElement(By.tagName("th"));
        //System.out.println(headOfTable.getText());

        List<WebElement> headers = driver.findElements(By.cssSelector("table#table1>thead>tr>th"));
        System.out.println("Number of columns: "+headers.size());
        List<String> headersText = BrowserUtils.getElementsText(headers);
        System.out.println(headersText);

        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of Rows: "+rowsWithHeader.size());

        //get nr of rows NOT including header
        List<WebElement> rows2 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println("Numbers of rows2: "+rows2.size());
    }

    @Test
    public void getSingleRowByIndex(){
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(row.getText());

        String xpath = getTableRowXpath(3);
        row = driver.findElement(By.xpath(xpath));
        System.out.println(row.getText());
    }

    public static String getTableRowXpath(int index){
        String xpath = "//table[@id='table1']/tbody/tr["+index+"]";
        return xpath;
    }



}
