package com.github.absmarat.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        while (answer.equals("yes")) {
            HangmanGame game = new HangmanGame();
            game.start();
            System.out.print("\nХотите продолжить игру? [yes/no]:  ");
            answer = enterAnswer(console);

            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                answer = enterAnswer(console);
            }
        }
        console.close();
    }

    private static String enterAnswer(Scanner scanner) {
        String answer = scanner.nextLine().toLowerCase();
        return answer;
    }
}
