package com.github.absmarat.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = "yes";

        while (!"no".equals(answer)) {
            Calculator calculator = new Calculator();

            if ("yes".equals(answer)) {
                String expression = inputExpression(scan);
                double result = calculator.calculate(expression);
                printResult(expression, result);
                System.out.print("\nХотите продолжить вычисления? [yes/no]:  ");
            }

            if (!"no".equals(answer) && !"yes".equals(answer)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = scan.nextLine().toLowerCase().trim();
        }
    }

    private static String inputExpression(Scanner scan) {
        System.out.print("Введите выражение из трёх аргументов, например, 10 ^ 2: ");
        return scan.nextLine().trim();
    }

    private static void printResult(String expression, double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String formattedNumber = decimalFormat.format(result);

        if (!Double.isNaN(result)) {
            System.out.println(expression + " = " + formattedNumber);
        }
    }
}