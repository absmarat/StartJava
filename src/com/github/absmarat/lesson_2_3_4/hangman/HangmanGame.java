package com.github.absmarat.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private String[] gallows;
    private int maxAttempts;
    private String[] words;
    private Scanner scanner;
    private String selectedWord;
    private int currAttempt;
    private StringBuilder wrongLetters;
    private StringBuilder mask;

    public HangmanGame() {
        gallows = new String[] {
                "_______",
                "|     |",
                "|     @",
                "|    /|\\",
                "|    / \\",
                "| GAME OVER!"
        };
        maxAttempts = gallows.length;
        words = new String[] {"ВИСЕЛИЦА", "КОМПЬЮТЕР", "ИГРА", "АЛГОРИТМ", "ПРОГРАММИРОВАНИЕ"};
        scanner = new Scanner(System.in);
        selectedWord = words[(int) (Math.random() * words.length)];
        currAttempt = maxAttempts;
        wrongLetters = new StringBuilder();
        mask = new StringBuilder("*".repeat(selectedWord.length()));
    }

    public void start() {
        printWelcomeMessage(currAttempt);

        while (!selectedWord.contentEquals(mask) && currAttempt > 0) {
            displayGameState(mask, wrongLetters);
            char guess = enterLetter(scanner);

            if (isReEnteredLetter(guess, mask)) {
                System.out.println("Буква " + "\"" + guess + "\"" + " уже угадана!");
                continue;
            }

            if (isReEnteredLetter(guess, wrongLetters)) {
                System.out.println("Буква " + "\"" + guess + "\"" + " уже вводилась!");
                continue;
            }

            boolean found = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (guess == selectedWord.charAt(i)) {
                    mask.setCharAt(i, guess);
                    found = true;

                    if (currAttempt < maxAttempts) {
                        System.out.printf("""
                                Буква "%s" верна! Количество попыток: %d
                                 """, guess, ++currAttempt);
                        displayHangmanElements(maxAttempts, currAttempt, gallows);
                    }
                }
            }

            if (!found) {
                wrongLetters.append(guess).append(",");
                System.out.printf("""
                        Буквы "%s" нет в угадываемом слове! Количество попыток: %d
                        """, guess, --currAttempt);
                displayHangmanElements(maxAttempts, currAttempt, gallows);
            }
            printGameResult(mask, selectedWord, currAttempt);
        }
    }

    private static void printWelcomeMessage(int currAttempt) {
        System.out.printf("""
                Добро пожаловать в игру!
                У вас %d попыток, чтобы угадать слово.
                """, currAttempt);
    }

    private static void displayGameState(StringBuilder mask, StringBuilder wrongLetters) {
        System.out.println("Угадываемое слово: " + mask);
        System.out.println("Неверно введённые буквы: " + wrongLetters);
    }

    private static char enterLetter(Scanner scanner) {
        char letter;
        while (true) {
            System.out.print("Введите букву из кириллического алфавита: ");
            letter = scanner.next().toUpperCase().charAt(0);

            if ((letter >= 'А' && letter <= 'Я') || letter == 'Ё') {
                break;
            } else {
                System.out.printf("""
                        Символ "%s" не корректен, введите букву кириллического алфавита!
                        """, letter);
            }
        }
        return letter;
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

    private static void displayHangmanElements(int maxAttempts, int currAttempt, String[] gallows) {
        StringBuilder elements = new StringBuilder();
        int hangmanElementsAmount = maxAttempts - currAttempt;

        for (int i = 0; i < hangmanElementsAmount; i++) {
            elements.append(gallows[i]).append("\n");
        }
        System.out.print(elements);
    }

    private static void printGameResult(StringBuilder mask, String selectedWord, int currAttempt) {
        System.out.println(selectedWord.contentEquals(mask) ? provideVictoryMessage(mask)
                : currAttempt == 0 ? provideDefeatMessage(selectedWord) : "");
    }

    private static String provideVictoryMessage(StringBuilder mask) {
        return "Поздравляю! Вы угадали слово \"" + mask + "\"";
    }

    private static String provideDefeatMessage(String selectedWord) {
        return "Все попытки исчерпаны. Вы проиграли! Загаданное слово \"" + selectedWord + "\"";
    }
}
