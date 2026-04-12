package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;

    private Player p1;
    private Player p2;
    private int hiddenNumber;

    Random rnd = new Random();

    public GuessNumber(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        hiddenNumber = rnd.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    public void start() {
        p1.reset();
        p2.reset();

        System.out.println("Игра началась! У каждого игрока " + MAX_ATTEMPTS + " попыток.");

        Scanner console = new Scanner(System.in);
        int attempt = 1;

        while (attempt <= MAX_ATTEMPTS) {
            System.out.println("Попытка " + attempt);

            if (isGuessed(p1, console, attempt)) break;
            checkAttemptCount(p1.getName(), attempt);

            if (isGuessed(p2, console, attempt)) break;
            checkAttemptCount(p2.getName(), attempt);

            attempt++;
        }
        displayPlayerAttempts();
    }

    private boolean isGuessed(Player player, Scanner console, int attempt) {
        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int number = inputNumber(console);
                player.addNumber(number);

                if (number == hiddenNumber) {
                    System.out.println(player.getName() +
                            " угадал(-а) число " + number + " c " + attempt + "-й попытки!");
                    return true;
                }

                String comparison = (number > hiddenNumber) ? "больше" : "меньше";
                System.out.println("  Число " + number + " " + comparison + " загаданного.");
                return false;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + player.getName() + ", попробуй ещё раз: ");
            }
        }
    }

    private int inputNumber(Scanner console) {
        while (!console.hasNextInt()) {
            System.out.print("Ошибка! Введи целое число: ");
            console.next();
        }
        return console.nextInt();
    }

    private void checkAttemptCount(String name, int attempt) {
        if (attempt >= MAX_ATTEMPTS) {
            System.out.println("У игрока " + name + " закончились попытки!");
        }
    }

    private void displayPlayerAttempts() {
        Player[] players = {p1, p2};

        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName() + ": ");
            int[] playerNumbers = players[i].receiveGuesses();
            for (int number : playerNumbers) {
                System.out.print(number + " ");
            }
            System.out.print("   ");
        }
    }
}




