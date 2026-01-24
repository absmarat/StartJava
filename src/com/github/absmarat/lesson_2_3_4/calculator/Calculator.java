package com.github.absmarat.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    public double calculate(String expression) {
        String[] expressionElements = expression.split(" ");

        if (expressionElements.length != EXPRESSION_LENGTH) {
            System.out.println("Ошибка: выражение должно содержать три аргумента, например: 2 ^ 10");
            return Double.NaN;
        }

        try {
            int firstNumber = Integer.parseInt(expressionElements[0]);
            char operation = expressionElements[1].charAt(0);
            int secondNumber = Integer.parseInt(expressionElements[2]);

            switch (operation) {
                case '+':
                    return firstNumber + secondNumber;
                case '-':
                    return firstNumber - secondNumber;
                case '*':
                    return firstNumber * secondNumber;
                case '/':
                case '%':
                    if (secondNumber == 0) {
                        System.out.println("Ошибка: деление на ноль запрещено!");
                        return Double.NaN;
                    }
                    return divOrMod(firstNumber, secondNumber, operation);
                case '^':
                    return Math.pow(firstNumber, secondNumber);
                default:
                    System.out.println("Ошибка! Операция " + operation + " не поддерживается.");
                    return Double.NaN;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введён нечисловой символ.");
            return Double.NaN;
        }
    }

    private double divOrMod(int firstNumber, int secondNumber, char operation) {
        return (operation == '/') ? (double) firstNumber / secondNumber
                : Math.floorMod(firstNumber, secondNumber);
    }
}