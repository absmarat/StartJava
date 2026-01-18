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
            displayGallows();
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
        System.out.printf("\nУгадываемое слово: %s\n", mask);
        System.out.printf("Неверно введённые буквы: %s\n", wrongLetters);
        System.out.printf("Количество попыток: %s\n", currAttempt);
    }

    private char enterLetter() {
        char letter;
        while (true) {
            System.out.print("\nВведите букву из кириллического алфавита: ");
            letter = scanner.next().toUpperCase().charAt(0);

            if (isCyrillicLetter(letter)) {
                break;
            }
            System.out.printf("Символ \"%c\" не корректен.\n", letter);
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
                currAttempt++;
                System.out.printf("Буква \"%c\" верна!\n", guess);
            }
        } else {
            wrongLetters.append(guess).append(",");
            currAttempt--;
            System.out.printf("Буквы \"%c\" нет в угадываемом слове!\n", guess);
        }
    }

    private void displayGallows() {
        StringBuilder elements = new StringBuilder();
        int elementAmount = maxAttempts - currAttempt;

        for (int i = 0; i < elementAmount; i++) {
            elements.append(gallows[i]).append("\n");
        }
        System.out.print(elements);
    }

    private void printGameResult() {
        String victoryMessage = "Поздравляю! Вы угадали слово \"" + mask + "\"";
        String defeatMessage = "Все попытки исчерпаны. Вы проиграли! Загаданное слово \"" +
                selectedWord + "\"";
        System.out.println(currAttempt > 0 ? victoryMessage : defeatMessage);
    }
}
