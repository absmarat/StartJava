package com.github.absmarat.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        String[] exprElements = expression.split(" ");

        if (exprElements.length != 3) {
            System.out.println("Ошибка: выражение должно содержать три аргумента, например: 2 ^ 10");
            return Double.NaN;
        }

        try {
            int firstNumber = Integer.parseInt(exprElements[0]);
            char operation = exprElements[1].charAt(0);
            int secondNumber = Integer.parseInt(exprElements[2]);

            switch (operation) {
                case '+':
                    return firstNumber + secondNumber;
                case '-':
                    return firstNumber - secondNumber;
                case '*':
                    return firstNumber * secondNumber;
                case '/':
                    if (secondNumber == 0) {
                        System.out.println("Ошибка: деление на ноль запрещено!");
                        return Double.NaN;
                    }
                    return (double) firstNumber / secondNumber;
                case '%':
                    if (secondNumber == 0) {
                        System.out.println("Ошибка: деление на ноль запрещено!");
                        return Double.NaN;
                    }
                    return Math.floorMod(firstNumber, secondNumber);
                case '^':
                    return Math.pow(firstNumber, secondNumber);
                default:
                    System.out.println("Ошибка! Операция " + operation + " не поддерживается.");
                    return Double.NaN;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный формат числа в выражении");
            return Double.NaN;
        }
    }
}