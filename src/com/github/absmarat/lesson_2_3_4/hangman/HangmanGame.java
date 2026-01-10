package com.github.absmarat.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private String[] words = {"ВИСЕЛИЦА", "АЛГОРИТМ", "КОМПЬЮТЕР", "ИГРА", "ПРОГРАММА"};
    private String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private int maxAttempts;
    private int currAttempt;

    private String selectedWord;

    private Scanner scanner;
    private StringBuilder wrongLetters;
    private StringBuilder mask;

    public HangmanGame() {
        maxAttempts = gallows.length;
        currAttempt = maxAttempts;
        selectedWord = words[(int) (Math.random() * words.length)];
        scanner = new Scanner(System.in);
        wrongLetters = new StringBuilder();
        mask = new StringBuilder("*".repeat(selectedWord.length()));
    }

    public void start() {
        printWelcomeMessage();

        while (!selectedWord.contentEquals(mask) && currAttempt > 0) {
            displayGameState();
            char guess = enterLetter();

            if (isReEnteredLetter(guess, mask)) {
                System.out.println("Буква " + "\"" + guess + "\"" + " уже угадана!");
                continue;
            }

            if (isReEnteredLetter(guess, wrongLetters)) {
                System.out.println("Буква " + "\"" + guess + "\"" + " уже вводилась!");
                continue;
            }

            processGuess(guess);
            displayHangmanElements();
        }
        printGameResult();
    }

    private void printWelcomeMessage() {
        System.out.printf("""
                
                Добро пожаловать в игру!
                У вас %d попыток, чтобы угадать слово.
                """, currAttempt);
    }

    private void displayGameState() {
        System.out.println("Угадываемое слово: " + mask);
        System.out.println("Неверно введённые буквы: " + wrongLetters);
    }

    private char enterLetter() {
        char letter;
        while (true) {
            System.out.print("\nВведите букву из кириллического алфавита: ");
            letter = scanner.next().toUpperCase().charAt(0);

            if (isCyrillicLetter(letter)) {
                break;
            }
            System.out.println("Символ " + "\"" + letter + "\"" + " не корректен.");
        }
        return letter;
    }

    private boolean isCyrillicLetter(char letter) {
        return (letter >= 'А' && letter <= 'Я') || letter == 'Ё';
    }

    private boolean isReEnteredLetter(char letter, StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if (letter == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private void processGuess(char guess) {
        boolean found = false;

        for (int i = 0; i < selectedWord.length(); i++) {
            if (guess == selectedWord.charAt(i)) {
                mask.setCharAt(i, guess);
                found = true;
            }
        }

        if (found) {
            if (currAttempt < maxAttempts) {
                System.out.println("Буква " + "\"" + guess + "\" верна! " +
                        "Количество попыток: " + (++currAttempt));
            }
        } else {
            wrongLetters.append(guess).append(",");
            System.out.println("Буквы " + "\"" + guess + "\"" + " нет в угадываемом слове!" +
                    " Количество попыток: " + (--currAttempt));
        }
    }

    private void displayHangmanElements() {
        StringBuilder elements = new StringBuilder();
        int hangmanElementsAmount = maxAttempts - currAttempt;

        for (int i = 0; i < hangmanElementsAmount; i++) {
            elements.append(gallows[i]).append("\n");
        }
        System.out.print(elements);
    }

    private void printGameResult() {
        System.out.println(currAttempt > 0 ? provideVictoryMessage() : provideDefeatMessage());
    }

    private String provideVictoryMessage() {
        return "Поздравляю! Вы угадали слово \"" + mask + "\"";
    }

    private String provideDefeatMessage() {
        return "Все попытки исчерпаны. Вы проиграли! Загаданное слово \"" + selectedWord + "\"";
    }
}
