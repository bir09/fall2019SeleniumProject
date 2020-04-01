package com.cybertek.tests.day10_webElements;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {
    String title;


    @Test
    public void login(){
        System.out.println("opening browser");
        System.out.println("capturing title");
    }

    @Test
    public void assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
    }
}
