package com.github.absmarat.lesson_2_3_4.guess;

import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_NUMBER;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MIN_NUMBER;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] guesses;
    private int attempts;
    private int wins;

    Player(String name) {
        this.name = name;
        guesses = new int[MAX_ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getGuess() {
        return guesses[attempts - 1];
    }

    public void addGuess(int guess) {
        if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от " +
                    MIN_NUMBER + " до " + MAX_NUMBER + ".");
        }
        guesses[attempts] = guess;
        attempts++;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        wins++;
    }

    public void resetPlayerWins() {
        wins = 0;
    }

    public void reset() {
        Arrays.fill(guesses, 0, attempts, 0);
        attempts = 0;
    }

    public int[] receiveGuesses() {
        return Arrays.copyOf(guesses, attempts);
    }
}