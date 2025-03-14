package com.github.absmarat.lesson_2_3_4.array;

public class Factorial {

    public static void main(String[] args) {
        int[] numbers = {};
        long[] factorials = calculate(numbers);
        print(factorials, numbers);

        int[] numbers1 = null;
        factorials = calculate(numbers1);
        print(factorials, numbers1);

        int[] numbers2 = {8, 0, 9};
        factorials = calculate(numbers2);
        print(factorials, numbers2);

        int[] numbers3 = {-3, 1, 7, 13};
        factorials = calculate(numbers3);
        print(factorials, numbers3);

        int[] numbers4 = {-22, -0};
        factorials = calculate(numbers4);
        print(factorials, numbers4);
    }

    private static long[] calculate(int... numbers) {
        if (numbers != null) {
            int length = numbers.length;
            long[] result = new long[length];
            for (int i = 0; i < length; i++) {
                long factorial = 1;
                for (int j = 1; j <= numbers[i]; j++) {
                    factorial *= j;
                }
                result[i] = factorial;
            }
            return result;
        }
        return null;
    }

    private static void print(long[] factorials, int[] original) {
        if (original == null) {
            System.out.println("null");
            return;
        }

        int length = original.length;
        if (length == 0) {
            System.out.println("Массив нулевой длины!");
            return;
        }

        for (int i = 0; i < length; i++) {
            if (original[i] == 1 || original[i] == 0) {
                System.out.println(original[i] + "! = 1");
                continue;
            }

            if (original[i] < 0) {
                System.out.println("Ошибка: факториал " + original[i] + " не определён!");
                continue;
            }

            System.out.printf("%d! = ", original[i]);
            for (int j = 1; j <= original[i]; j++) {
                System.out.print(j + " ");
                System.out.print((j < original[i]) ? " * " : " = ");
            }
            System.out.println(factorials[i]);
        }
    }
}
