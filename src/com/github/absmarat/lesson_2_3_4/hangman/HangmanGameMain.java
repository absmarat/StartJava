package com.github.absmarat.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        do {
            HangmanGame game = new HangmanGame();
            if ("yes".equals(answer)) {
                game.start();
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            }

            if (!"yes".equals(answer) && !"no".equals(answer)) {
                System.out.print("Введите корректный ответ: ");
            }
            answer = console.nextLine();
        } while (!"no".equals(answer));
        console.close();
    }
}
