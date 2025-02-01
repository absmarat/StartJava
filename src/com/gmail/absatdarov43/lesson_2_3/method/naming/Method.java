package com.gmail.absatdarov43.lesson_2_3.method.naming;

public class Method {
    
    public static String getCurrName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}