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

    public GuessNumber(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        Random rnd = new Random();
        hiddenNumber = rnd.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    public void start() {
        p1.reset();
        p2.reset();

        System.out.println("Игра началась! У каждого игрока " + MAX_ATTEMPTS + " попыток.");

        Scanner console = new Scanner(System.in);
        int attempt = 1;

        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            System.out.println("Попытка " + attempt);

            if (isGuessed(p1, console, attempt)) break;
            checkAttemptCount(p1.getName(), attempt);

            if (isGuessed(p2, console, attempt)) break;
            checkAttemptCount(p2.getName(), attempt);
            attempt++;
        }
        displayPlayerGuesses();
    }

    private boolean isGuessed(Player player, Scanner console, int attempt) {
        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int number = inputNumber(console);
                player.addNumber(number);

                if (checkGuess(player, number, attempt)) {
                    return true;
                }
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

    private boolean checkGuess(Player player, int number, int attempt) {
        if (number == hiddenNumber) {
            System.out.println(player.getName() +
                    " угадал(-а) число " + number + " c " + attempt + "-й попытки!");
            return true;
        }

        String comparison = (number > hiddenNumber) ? "больше" : "меньше";
        System.out.println("  Число " + number + " " + comparison + " загаданного.");
        return false;
    }

    private void checkAttemptCount(String name, int attempt) {
        if (attempt >= MAX_ATTEMPTS) {
            System.out.println("У игрока " + name + " закончились попытки!");
        }
    }

    private void displayPlayerGuesses() {
        Player[] players = {p1, p2};

        for (Player player : players) {
            System.out.print(player.getName() + ": ");
            int[] guesses = player.receiveGuesses();
            for (int guess : guesses) {
                System.out.print(guess + " ");
            }
            System.out.print("   ");
        }
    }
}




