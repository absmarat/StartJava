package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS = 3;

    public static void main(String[] args) throws InterruptedException {
        Scanner console = new Scanner(System.in);
        Player[] players = addPlayers(console);
        String answer = "yes";

        while (!"no".equals(answer)) {
            GuessNumber game = new GuessNumber(players);

            if ("yes".equals(answer)) {
                game.start();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ: ");
            }

            answer = console.nextLine().toLowerCase().trim();
        }
        console.close();
    }

    private static Player[] addPlayers(Scanner console) {
        Player[] players = new Player[PLAYERS];
        for (int i = 0; i < PLAYERS; i++) {
            System.out.print("Введите имя игрока №" + (i + 1) + ": ");
            String name = console.nextLine();
            players[i] = new Player(name);
        }
        return players;
    }
}


