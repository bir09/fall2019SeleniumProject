package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static List<String> getElementsText(List<WebElement> elements){
        //given list of elements return list of texts
        List<String> list = new ArrayList<>();
        for(WebElement each: elements){
            list.add(each.getText());
        }
        return list;
    }
}
