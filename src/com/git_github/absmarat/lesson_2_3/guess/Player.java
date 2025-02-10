package com.git_github.absmarat.lesson_2_3.guess;

public class Player {
    
    private String name;
    private int number;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}