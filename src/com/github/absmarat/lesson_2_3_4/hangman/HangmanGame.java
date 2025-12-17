package com.github.absmarat.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private static final String[] HANGMAN_ELEMENTS = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final String[] WORDS = {"виселица", "компьютер", "алгоритм", "программирование", "игра"};
    private static final int MAX_ATTEMPTS = HANGMAN_ELEMENTS.length;
    private static Scanner scanner;
    private static String selectedWord;
    private static int currentNumAttempts;
    private static StringBuilder wrongLetters;
    private static StringBuilder mask;

    public void start() {
        initializeGame();
        printWelcomeMessage();

        while (!String.valueOf(mask).equals(selectedWord) && currentNumAttempts > 0) {
            displayGameState();
            char guess = enterLetter();

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

            if (isReEnteredLetter(guess, wrongLetters)) {
                System.out.println("Буква " + "\"" + String.valueOf(guess).toUpperCase() +
                        "\"" + " уже вводилась!");
                continue;
            }

            checkLetterValidity(guess);
            printFinalResult();
        }
    }

    private static void checkLetterValidity(char guess) {
        int amountHangmanElements = 0;
        boolean found = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (guess == selectedWord.charAt(i)) {
                mask.replace(i, i + 1, String.valueOf(guess));
                found = true;

                if (currentNumAttempts < MAX_ATTEMPTS) {
                    amountHangmanElements = MAX_ATTEMPTS - (++currentNumAttempts);
                    System.out.println("Буква " + "\"" + String.valueOf(guess).toUpperCase() +
                            "\"" + " верна." + "Количество попыток: " + currentNumAttempts);
                    System.out.println(defineHangmanElements(amountHangmanElements));
                }
            }
        }

        if (!found) {
            wrongLetters.append(guess).append(",");
            amountHangmanElements = MAX_ATTEMPTS - (--currentNumAttempts);
            System.out.println("Буквы " + "\"" + String.valueOf(guess).toUpperCase() + "\"" +
                    " нет в угадываемом слове! Количество попыток: " + currentNumAttempts);
            System.out.println(defineHangmanElements(amountHangmanElements));
        }
    }

    private static String defineHangmanElements(int amount) {
        StringBuilder elements = new StringBuilder();

        for (int i = 0; i < amount; i++) {
            elements.append(HANGMAN_ELEMENTS[i]).append("\n");
        }
        return elements.toString();
    }

    private static void displayGameState() {
        System.out.println("Угадываемое слово: " + String.valueOf(mask).toUpperCase());
        System.out.println("Неверно введённые буквы: " + String.valueOf(wrongLetters).toUpperCase());
    }

    private static char enterLetter() {
        System.out.print("Введите букву из кириллического алфавита: ");
        char letter = scanner.next().toLowerCase().charAt(0);
        return letter;
    }

    private static void initializeGame() {
        scanner = new Scanner(System.in);
        selectedWord = WORDS[(int) (Math.random() * WORDS.length)];
        currentNumAttempts = MAX_ATTEMPTS;
        wrongLetters = new StringBuilder();
        mask = new StringBuilder("*".repeat(selectedWord.length()));
    }

    private static boolean isLetter(char ch) {
        return (ch >= 'а' && ch <= 'я') || ch == 'ё';
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

    private static void printWelcomeMessage() {
        System.out.println("\nДобро пожаловать в игру!\n" +
                "У вас " + currentNumAttempts + " попыток, чтобы угадать слово.");
    }

    private static void printFinalResult() {
        if (String.valueOf(mask).equals(selectedWord)) {
            System.out.println("Поздравляю! Вы угадали слово " +
                    "\"" + String.valueOf(mask).toUpperCase() + "\"");
        } else if (currentNumAttempts == 0) {
            System.out.println("Все попытки исчерпаны. Вы проиграли! Загаданное слово " +
                    "\"" + selectedWord.toUpperCase() + "\"");
        }
    }
}
