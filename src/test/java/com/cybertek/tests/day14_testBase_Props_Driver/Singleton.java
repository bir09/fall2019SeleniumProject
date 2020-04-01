package com.cybertek.tests.day14_testBase_Props_Driver;

public class Singleton {
    //make private constructor
    private Singleton(){
    }

    static String str;

    public static String getInstance(){
        if(str == null){
            str = "chrome";
        }
        return str;
    }


}
