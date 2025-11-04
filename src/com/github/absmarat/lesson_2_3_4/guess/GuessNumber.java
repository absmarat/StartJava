package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player p1;
    private Player p2;
    private int targetNumber;

    public GuessNumber(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start() {
        targetNumber = (int) (1 + Math.random() * 100);
        System.out.println("Угадай число от 1 до 100.");
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print(p1.getName() + ", введи предполагаемое число: ");
            p1.setNumber(console.nextInt());
            boolean isEquality = hasEqualNumbers(p1.getNumber());
            if (isEquality) break;

            System.out.print(p2.getName() + ", введи предполагаемое число: ");
            p2.setNumber(console.nextInt());
            isEquality = hasEqualNumbers(p2.getNumber());
            if (isEquality) break;
        }
    }

    private boolean hasEqualNumbers(int playerNumber) {
        if (playerNumber == targetNumber) {
            System.out.println("  Ты победил(а)!");
            return true;
        }
        if (playerNumber > targetNumber) {
            System.out.println("  Число " + playerNumber + " больше, чем загаданное.");
        } else {
            System.out.println("  Число " + playerNumber + " меньше, чем загаданное.");
        }
        return false;
    }
}