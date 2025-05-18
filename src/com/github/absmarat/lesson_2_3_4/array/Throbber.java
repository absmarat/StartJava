package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public class Throbber {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        char[] animationElements = {'-', '\\', '|', '/'};
        String msg = "Hacking: ";
        simulateHacking(animationElements, msg);
        determainStatus(msg);
    }

    private static void simulateHacking(char[] animationElements, String msg) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (char element : animationElements) {
                System.out.print(msg + element + "\r");
                Thread.sleep(200);
            }
        }
    }

    private static void determainStatus(String msg) {
        Random rdm = new Random();
        int number = rdm.nextInt(100);
        System.out.print(msg);
        String result = (number > 70) ? (ANSI_RED + "Access Granted!") : (ANSI_GREEN + "Access Denied!");
        System.out.print(result + ANSI_RESET);
    }
}
