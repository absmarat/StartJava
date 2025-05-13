package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public class LoadingAnimation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        char[] chars = {'-', '\\', '|', '/'};
        int number = generateRandomNumber();
        displayMessage(chars, number);
    }

    private static int generateRandomNumber() {
        Random rnd = new Random();
        return rnd.nextInt(100);
    }

    private static void displayMessage(char[] chars, int number) throws InterruptedException {
        String msg = "Hacking: ";

        for (int i = 0; i < 3; i++) {
            for (char ch : chars) {
                System.out.print(msg + ch + "\r");
                Thread.sleep(200);
            }
        }

        String result = (number > 70)
                ? ("\r" + msg + ANSI_RED + "Access Granted!" + ANSI_RESET)
                : ("\r" + msg + ANSI_GREEN + "Access Denied!" + ANSI_RESET);
        System.out.println(result);
    }
}
