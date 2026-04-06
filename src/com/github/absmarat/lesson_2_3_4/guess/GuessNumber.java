package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;

    private Player p1;
    private Player p2;
    private int hiddenNumber;

    public GuessNumber(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start() {
        hiddenNumber = (int) (MIN_NUMBER + Math.random() * MAX_NUMBER);
        p1.reset();
        p2.reset();

        System.out.println("Игра началась! У каждого игрока " + MAX_ATTEMPTS + " попыток.");

        Scanner console = new Scanner(System.in);
        int attempt = 1;

        while (attempt <= MAX_ATTEMPTS) {
            System.out.println("Попытка " + attempt);

            if (hasNumberEquality(p1, console, attempt)) break;
            if (attempt >= MAX_ATTEMPTS) {
                System.out.println("У игрока " + p1.getName() + " закончились попытки!");
            }

            if (hasNumberEquality(p2, console, attempt)) break;
            if (attempt >= MAX_ATTEMPTS) {
                System.out.println("У игрока " + p2.getName() + " закончились попытки!");
            }
            attempt++;
        }
        System.out.println(p1.getName() + ": " + p1.buildGuessesString() + "   " +
                p2.getName() + ": " + p2.buildGuessesString());
    }

    private boolean hasNumberEquality(Player player, Scanner console, int attempt) {
        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int number = readValidInteger(console);
                player.setNumber(number);
                player.incrementUsedAttempt();
                String comparison = (number > hiddenNumber) ? "больше" : "меньше";
                String message = (number == hiddenNumber) ?
                        player.getName() + " угадал число " + number + " с " + attempt + "-й попытки"
                        : "  Число " + number + " " + comparison + " загаданного.";
                System.out.println(message);
                return number == hiddenNumber;
            } catch (IllegalArgumentException exc) {
                System.out.print(exc.getMessage() + player.getName() + ", попробуй ещё раз: ");
            }
        }
    }

    private int readValidInteger(Scanner console) {
        while (!console.hasNextInt()) {
            System.out.print("Ошибка! Введи целое число: ");
            console.next();
        }
        return console.nextInt();
    }
}




