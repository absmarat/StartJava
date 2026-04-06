package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int usedAttempts;
    private int[] guesses;

    Player(String name) {
        this.name = name;
        this.guesses = new int[GuessNumber.MAX_ATTEMPTS];
        this.usedAttempts = 0;
        Arrays.fill(guesses, 0);
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от " +
                    GuessNumber.MIN_NUMBER + " до " + GuessNumber.MAX_NUMBER + ". ");
        }
        guesses[usedAttempts] = number;
    }

    public void incrementUsedAttempt() {
        usedAttempts++;
    }

    public void reset() {
        usedAttempts = 0;
        Arrays.fill(guesses, 0);
    }

    public String buildGuessesString() {
        int[] currentNumbers = Arrays.copyOf(guesses, usedAttempts);
        return Arrays.toString(currentNumbers).replaceAll("[\\[\\]]", "");
    }
}