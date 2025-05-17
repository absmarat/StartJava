package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public class Throbber {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        char[] animationElements = {'-', '\\', '|', '/'};
        int number = generateRandomNumber();
        simulateHacking(animationElements, number);
    }

    private static int generateRandomNumber() {
        Random rnd = new Random();
        return rnd.nextInt(100);
    }

    private static void simulateHacking(char[] animationElements, int number) throws InterruptedException {
        String msg = "Hacking: ";

        for (int i = 0; i < 3; i++) {
            for (char element : animationElements) {
                System.out.print(msg + element + "\r");
                Thread.sleep(200);
            }
        }

        System.out.print(msg);
        String result = (number > 70) ? (ANSI_RED + "Access Granted!") : (ANSI_GREEN + "Access Denied!");
        System.out.println(result + ANSI_RESET);
    }
}
