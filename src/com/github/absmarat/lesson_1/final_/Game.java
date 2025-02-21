package com.github.absmarat.lesson_1.final_;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int randomNumber = 1 + (int) (Math.random() * 100);
        System.out.print("Введите число в диапазоне от 1 до 100: ");
        Scanner console = new Scanner(System.in);
        int playerNumber = 0;
        while (playerNumber != randomNumber) {
            playerNumber = console.nextInt();
            if (playerNumber > randomNumber) {
                System.out.print(playerNumber + " больше загаданного. Введите другое число: ");
            } else if (playerNumber < randomNumber) {
                System.out.print(playerNumber + " меньше загаданного. Введите другое число: ");
            }
        }
        System.out.println("Вы угадали!");
    }
}