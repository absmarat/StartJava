package com.github.absmarat.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int num1 = console.nextInt();
        System.out.print("Укажите арифметическую операцию (+, -, *, /, %, ^): ");
        char operation = console.next().charAt(0);
        System.out.print("Введите целое число: ");
        int num2 = console.nextInt();
        int result = 0;
        if (operation == '+') {
            result = num1 + num2;
        } else if (operation == '-') {
            result = num1 - num2;
        } else if (operation == '*') {
            result = num1 * num2;
        } else if (operation == '/') {
            result = num1 / num2;
        } else if (operation == '%') {
            result = num1 % num2;
        } else if (operation == '^') {
            result = 1;
            for (int i = 1; i <= num2; i++) {
                result *= num1;
            }
        }
        System.out.printf("%d%2c%4d = %4d\n", num1, operation, num2, result);
    }
}