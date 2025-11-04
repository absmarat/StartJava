package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String firstName = console.nextLine();
        Player p1 = new Player(firstName);

        System.out.print("Введите имя второго игрока: ");
        String secondName = console.nextLine();
        Player p2 = new Player(secondName);

        GuessNumber game = new GuessNumber(p1, p2);
        String answer = "";
        do {
            game.start();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]:");
                answer = console.nextLine();
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while (!"no".equals(answer));
    }
}