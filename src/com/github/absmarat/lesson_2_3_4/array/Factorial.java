package com.github.absmarat.lesson_2_3_4.array;

public class Factorial {

    public static void main(String[] args) {
        int[] numbers = {};
        long[] factorials = calculate(numbers);
        printExpr(factorials, numbers);

        int[] numbers1 = null;
        factorials = calculate(numbers1);
        printExpr(factorials, numbers1);

        int[] numbers2 = {8, 0, 9};
        factorials = calculate(numbers2);
        printExpr(factorials, numbers2);

        int[] numbers3 = {-3, 1, 7, 13};
        factorials = calculate(numbers3);
        printExpr(factorials, numbers3);

        int[] numbers4 = {-22, -0};
        factorials = calculate(numbers4);
        printExpr(factorials, numbers4);
    }

    private static long[] calculate(int... numbers) {
        if (numbers == null) {
            return null;
        }

        int length = numbers.length;
        long[] factorials = new long[length];
        for (int i = 0; i < length; i++) {
            long factorial = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void printExpr(long[] factorials, int[] original) {
        if (original == null) {
            System.out.println("null");
            return;
        }

        if (original.length == 0) {
            System.out.println("Массив нулевой длины!");
            return;
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] == 1 || original[i] == 0) {
                System.out.println(original[i] + "! = 1");
                continue;
            }

            if (original[i] < 0) {
                System.out.println("Ошибка: факториал " + original[i] + "! не определён!");
                continue;
            }

            StringBuilder expr = new StringBuilder(original[i] + "! = ");
            for (int j = 1; j <= original[i]; j++) {
                expr.append(j);
                expr = (j < original[i]) ? expr.append(" * ") : expr.append(" = ");
            }
            System.out.println(expr.append(factorials[i]));
        }
    }
}
