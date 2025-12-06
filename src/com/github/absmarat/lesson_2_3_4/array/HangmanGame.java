package com.github.absmarat.lesson_2_3_4.array;

import java.util.Scanner;

public class HangmanGame {
    public void start() {
        Scanner scan = new Scanner(System.in);
        StringBuilder incorrectLetters = new StringBuilder();
        StringBuilder mask = new StringBuilder();
        String[] words = {"виселица", "игра", "компьютер", "алгоритм", "программирование"};
        int index = (int) (0 + Math.random() * words.length);
        String selectedWord = words[index];
        int attempts = 6;

        for (int i = 0; i < selectedWord.length(); i++) {
            mask.append("*");
        }

        System.out.println("Добро пожаловать в игру!\nУ вас " + attempts + " попыток, чтобы угадать слово.");

        while (attempts > 0) {
            System.out.println("Угадываемое слово: " + String.valueOf(mask).toUpperCase());
            System.out.println("Неверно введённые буквы: " + String.valueOf(incorrectLetters).toUpperCase());
            System.out.println("Введите букву из кириллического алфавита: ");
            char guess = scan.next().toLowerCase().charAt(0);

            if (!isLetter(guess)) {
                System.out.println("Символ " + "\"" + String.valueOf(guess).toUpperCase() + "\"" +
                        " не корректен, введите букву кириллического алфавита!");
                continue;
            }

            if (isReEnteredLetter(guess, mask)) {
                System.out.println("Буква " + "\"" + String.valueOf(guess).toUpperCase() +
                        "\"" + " уже угадана!");
                continue;
            }

            if (isReEnteredLetter(guess, incorrectLetters)) {
                System.out.println("Буква " + "\"" + String.valueOf(guess).toUpperCase() +
                        "\"" + " уже вводилась!");
                continue;
            }

            int amountHangmanElements = 0;
            boolean found = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (guess == selectedWord.charAt(i)) {
                    mask.replace(i, i + 1, String.valueOf(guess));
                    found = true;

                    if (attempts < 6) {
                        amountHangmanElements = 6 - (++attempts);
                        System.out.println("Буква " + "\"" + String.valueOf(guess).toUpperCase() +
                                "\"" + " верна." + "Количество попыток: " + attempts);
                        System.out.println(difineHangmanElements(amountHangmanElements));
                    }
                }
            }

            if (!found) {
                incorrectLetters.append(guess).append(",");
                amountHangmanElements = 6 - (--attempts);
                System.out.println("Буквы " + "\"" + String.valueOf(guess).toUpperCase() + "\"" +
                        " нет в угадываемом слове! Количество попыток: " + attempts);
                System.out.println(difineHangmanElements(amountHangmanElements));
            }

            if (String.valueOf(mask).equals(selectedWord)) {
                System.out.println("Поздравляю! Вы угадали слово " +
                        "\"" + String.valueOf(mask).toUpperCase() + "\"");
                break;
            }

            if (attempts == 0) {
                System.out.println("Все попытки исчерпаны. Вы проиграли! Загаданное слово " +
                        "\"" + selectedWord.toUpperCase() + "\"");
                break;
            }
        }
    }

    private static String difineHangmanElements(int amount) {
        StringBuilder elements = new StringBuilder();
        String[] hangmanElements =
          {"_______",
           "|     |",
           "|     @",
           "|    /|\\",
           "|    / \\",
           "| GAME OVER!"
          };

        for (int i = 0; i < amount; i++) {
            elements.append(hangmanElements[i]).append("\n");
        }

        return elements.toString();
    }

    private static boolean isLetter(char ch) {
        return ch >= 'а' && ch <= 'ё';
    }

    private static boolean isReEnteredLetter(char letter, StringBuilder str) {
        boolean found = false;

        for (int i = 0; i < str.length(); i++) {
            if (letter == str.charAt(i)) {
                found = true;
            }
        }
        return found;
    }
}
