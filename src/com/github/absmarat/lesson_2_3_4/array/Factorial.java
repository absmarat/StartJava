package com.github.absmarat.lesson_2_3_4.array;

public class Factorial {

    public static void main(String[] args) {
        int[] numbers = {};
        calculateFactorial(numbers);

        int[] numbers1 = null;
        calculateFactorial(numbers1);

        int[] numbers2 = {8, 0, 9};
        calculateFactorial(numbers2);

        int[] numbers3 = {-3, 1, 7, 13};
        calculateFactorial(numbers3);

        int[] numbers4 = {-22, -0};
        calculateFactorial(numbers4);
    }

    private static void calculateFactorial (int... numbers) {
        if (numbers == null) {
            System.out.println("Массив ссылается на null!");
            return;
        }

        if (numbers.length == 0) {
            System.out.println("Массив является пустым!");
            return;
        }

        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Ошибка: факториал " + numbers[i] + " не определён!");
                continue;
            }

            if (numbers[i] == 1 || numbers[i] == 0) {
                System.out.println(numbers[i] + "! = " + 1);
                continue;
            }

            int[] newArray = new int[length];
            System.out.printf("%d! = ", numbers[i]);
            int factorial = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
                newArray[i] = factorial;
                System.out.print(j + " ");
                System.out.print(j < numbers[i]? "* ": "= ");
            }
            System.out.println(newArray[i] + " ");
        }
    }
}
