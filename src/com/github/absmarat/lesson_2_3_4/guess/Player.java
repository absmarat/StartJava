package com.github.absmarat.lesson_2_3_4.guess;

import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_NUMBER;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MIN_NUMBER;

import java.util.Arrays;

public class Player {
    private String name;
    private int attempts;
    private int[] guesses;

    Player(String name) {
        this.name = name;
        guesses = new int[MAX_ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public void reset() {
        Arrays.fill(guesses, 0, attempts, 0);
        attempts = 0;
    }

    public void addNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от " +
                    MIN_NUMBER + " до " + MAX_NUMBER + ". ");
        }
        guesses[attempts] = number;
        attempts++;
    }

    public int[] receiveGuesses() {
        return Arrays.copyOf(guesses, attempts);
    }
}