package com.github.absmarat.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    public static double calculate(String expression) {
        String[] expressionElements = expression.split(" ");

        if (expressionElements.length != EXPRESSION_LENGTH) {
            throw new InvalidExpressionLengthException(
                    "Ошибка: выражение должно содержать три аргумента, например: 2 ^ 10");
        }

        try {
            int firstNumber = Integer.parseInt(expressionElements[0]);
            int secondNumber = Integer.parseInt(expressionElements[2]);
            String operation = expressionElements[1];

            if (operation.length() != 1) {
                throw new UnsupportedOperationException(
                        "Ошибка: оператор \"" + operation + "\" не поддерживается." +
                        " Допустимые операторы: +, -, *, /, %, ^");
            }

            return switch (operation) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                case "/", "%" -> {
                    if (secondNumber == 0) {
                        throw new ArithmeticException("Ошибка: деление на ноль запрещено!");
                    }
                    yield divOrMod(firstNumber, secondNumber, operation);
                }
                case "^" -> Math.pow(firstNumber, secondNumber);
                default -> throw new UnsupportedOperationException(
                        "Ошибка: операция " + operation + " не поддерживается.");
            };
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Ошибка: в выражении содержится не целое число.");
        }
    }

    private static double divOrMod(int firstNumber, int secondNumber, String operation) {
        return operation.equals("/") ? (double) firstNumber / secondNumber
                : Math.floorMod(firstNumber, secondNumber);
    }
}
