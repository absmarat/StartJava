package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;

    private Player p1;
    private Player p2;
    private int targetNumber;

    public GuessNumber(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start() {
        targetNumber = (int) (MIN_NUMBER + Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
        p1.reset();
        p2.reset();

        System.out.println("Игра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток.");

        int attempt = 1;

        while (attempt <= MAX_ATTEMPTS) {
            System.out.println("Попытка " + attempt);

            if (hasNumberEquality(p1, attempt)) break;
            if (attempt >= MAX_ATTEMPTS) {
                System.out.println("У " + p1.getName() + " закончились попытки!");
            }

            if (hasNumberEquality(p2, attempt)) break;
            if (attempt >= MAX_ATTEMPTS) {
                System.out.println("У " + p2.getName() + " закончились попытки!");
            }
            attempt++;
        }
        System.out.println(p1.getName() + ": " + p1.buildIncorrectGuessesString() + "   " +
                p2.getName() + ": " + p2.buildIncorrectGuessesString());
    }

    private boolean hasNumberEquality(Player player, int attempt) {
        Scanner console = new Scanner(System.in);

        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int number = checkInteger(console);
                player.setNumber(number);
                player.incrementAttempts();
                String comparison = (number > targetNumber) ? "больше" : "меньше";
                String message = (number == targetNumber) ?
                        player.getName() + " угадал число " + number + " с " + attempt + "-й попытки"
                        : "  Число " + number + " " + comparison + " загаданного.";
                System.out.println(message);
                return number == targetNumber;
            } catch (IllegalArgumentException exc) {
                System.out.print(exc.getMessage() + player.getName() + ", попробуй ещё раз: ");
                console.nextLine();
            }
        }
    }

    private int checkInteger(Scanner console) {
        while (!console.hasNextInt()) {
            System.out.print("Ошибка! Введи целое число: ");
            console.next();
        }
        return console.nextInt();
    }
}




