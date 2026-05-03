package com.github.absmarat.lesson_2_3_4.guess;

import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MAX_NUMBER;
import static com.github.absmarat.lesson_2_3_4.guess.GuessNumber.MIN_NUMBER;

import java.util.Arrays;

public class Player {
    private String name;
    private int attempts;
    private int[] guesses;
    private int guess;
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
        return guess;
    }

    public void setGuess(int guess) {
        if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от " +
                    MIN_NUMBER + " до " + MAX_NUMBER + ".");
        }
        this.guess = guess;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void resetPlayerWins() {
        wins = 0;
    }

    public void recordGuess(int guess) {
        guesses[attempts] = guess;
        attempts++;
    }

    public void reset() {
        Arrays.fill(guesses, 0, attempts, 0);
        attempts = 0;
        guess = 0;
    }

    public int[] receiveGuesses() {
        return Arrays.copyOf(guesses, attempts);
    }
}