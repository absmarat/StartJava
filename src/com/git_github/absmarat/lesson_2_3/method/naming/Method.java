package com.git_github.absmarat.lesson_2_3.method.naming;

public class Method {
    
    public static String getCurrName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}