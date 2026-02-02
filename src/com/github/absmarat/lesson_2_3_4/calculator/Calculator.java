package com.github.absmarat.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    public static double calculate(String expression) {
        String cleanedExcpression = expression.trim().replaceAll("\\s+", " ");
        String[] expressionElements = cleanedExcpression.split(" ");

        if (expressionElements.length != EXPRESSION_LENGTH) {
            throw new InvalidExpressionException("""
                    Ошибка: выражение должно содержать три аргумента, например: 2 ^ 10""");
        }

        if (!expressionElements[0].matches("-?\\d+")) {
            throw new InvalidNumberException("Ошибка: первый операнд не является целым числом.");
        }

        if (!expressionElements[2].matches("-?\\d+")) {
            throw new InvalidNumberException("Ошибка: второй операнд не является целым числом.");
        }

        String checkedOperator = expressionElements[1];
        if (checkedOperator.length() != 1) {
            throw new UnsupportedOperationException("Ошибка: " +
                    "оператор \"" + checkedOperator + "\" не поддерживается." +
                    " Допустимые операторы: +, -, *, /, %, ^");
        }

        int firstNumber = Integer.parseInt(expressionElements[0]);
        char operation = expressionElements[1].charAt(0);
        int secondNumber = Integer.parseInt(expressionElements[2]);

        return switch (operation) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/', '%' -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль запрещено!");
                }
                // Является ли тернарный оператор после оператора yield оптимальной альтернативой
                // вспомогательному методу divOrMod()?
                yield (operation == '/') ? (double) firstNumber / secondNumber
                        : Math.floorMod(firstNumber, secondNumber);
            }
            case '^' -> Math.pow(firstNumber, secondNumber);
            default -> throw new UnsupportedOperationException("Ошибка: " +
                    "операция " + operation + " не поддерживается.");
        };
    }
}
