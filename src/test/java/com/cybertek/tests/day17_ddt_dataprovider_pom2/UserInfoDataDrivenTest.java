package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTest {

    @Test(dataProvider = "users")
    public void test(String username, String email, int number){
        System.out.println("Opening application");
        System.out.println("Login as: "+username);
        System.out.println("number is: "+number);
        System.out.println("verify info");
    }

    @DataProvider(name = "users")
    public Object[][] getUsers(){
        return new Object[][]
                {
                        {"user1", "UserUser123", 12},
                        {"salesmanager344", "UserUser123", 13},
                        {"salesmanager321", "UserUser123", 14},
                        {"salesmanager465", "UserUser123", 15}
                };
    }


}
