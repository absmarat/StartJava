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
            long[] newArray = new long[length];
            for (int i = 0; i < length; i++) {
                long factorial = 1;
                for (int j = 1; j <= numbers[i]; j++) {
                    factorial = factorial * j;
                    newArray[i] = factorial;
                }
            }
            return newArray;
        }
        return null;
    }

    private static void print(long[] factorials, int[] originalArray) {
        if (originalArray == null) {
            System.out.println("null");
            return;
        }

        int length = originalArray.length;
        if (length == 0) {
            System.out.println("Массив нулевой длины!");
        }

        for (int i = 0; i < length; i++) {
            if (originalArray[i] == 1 || originalArray[i] == 0) {
                System.out.println(originalArray[i] + "! = 1");
                continue;
            }

            if (originalArray[i] < 0) {
                System.out.println("Ошибка: факториал " + originalArray[i] + " не определён!");
                continue;
            }

            System.out.printf("%d! = ", originalArray[i]);
            for (int j = 1; j <= originalArray[i]; j++) {
                System.out.print(j + " ");
                System.out.print((j < originalArray[i])? "* ": "= ");
            }
            System.out.println(factorials[i]);
        }
    }
}
