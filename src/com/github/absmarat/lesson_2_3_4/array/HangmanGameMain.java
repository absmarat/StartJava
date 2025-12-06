package com.github.absmarat.lesson_2_3_4.array;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String answer = "yes";

        while (answer.equals("yes")) {
            game.start();
            System.out.print("\nХотите продолжить игру? [yes/no]:  ");
            answer = console.nextLine().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("no")) {
                answer = enterCorrectAnswer(console, answer);
            }
        }
        console.close();
    }

    private static String enterCorrectAnswer(Scanner console, String answer) {
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Введите корректный ответ [yes / no]: ");
            answer = console.nextLine().toLowerCase();
        }
        return answer;
    }
}
