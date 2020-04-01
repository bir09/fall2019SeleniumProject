package com.cybertek.tests.day9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterClass {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }
    @Test(priority = 3)
    public void test1(){
        String str1 = "Java";
        String str2 = "Java";
        System.out.println("Test1");
        Assert.assertEquals(str1, str2);
    }
    @Test(priority = 2)
    public void test2(){
        String str1 = "Java";
        String str2 = "Java";
        System.out.println("Test2");
        Assert.assertEquals(str1, str2);
        System.out.println("Test 2 check");
    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("Test 3");
        Assert.assertTrue(15>10);
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
