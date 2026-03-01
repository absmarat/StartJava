package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public final class Console {
    private Console() {
        throw new AssertionError();
    }

    public static void displayPasswordStrengthResult(StringBuilder result) throws InterruptedException {
        displayLoading();
        System.out.println(result);
    }

    private static void displayLoading() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (char element : spins) {
                System.out.print("\b" + element);
                Thread.sleep(100);
            }
        }
    }

    public static void displayTypewriterEffect(String[] words) throws InterruptedException {
        if (words == null) {
            System.out.println("Ошибка: входной массив не может быть null или пустой.");
            return;
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.printf("%n");
    }

    public static void printNumbers(int[] array, String msg) {
        System.out.println(msg + Arrays.toString(array));
    }

    public static void printExpr(long[] factorials, int[] original) {
        if (original == null) {
            System.out.println("null");
            return;
        }

        if (original.length == 0) {
            System.out.println("\nМассив нулевой длины!");
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

            if (original[i] > 20) {
                System.out.println("Ошибка: факториал " + original[i] + "! слишком велик (максимум 20!)");
                continue;
            }

            StringBuilder expr = new StringBuilder(original[i] + "! = ");
            for (int j = 1; j <= original[i]; j++) {
                expr.append(j);
                expr.append((j < original[i]) ? " * " : " = ");
            }
            System.out.println(expr.append(factorials[i]));
        }
    }

    public static void printArrays(float[] original, float[] modified, int index, int count) {
        printValues(original, "Исходный массив: ");
        printValues(modified, "Изменённый массив: ");
        System.out.printf("Значение из ячейки по переданному индексу: %.3f \n", original[index]);
        System.out.println("Количество обнулённых ячеек: " + count + "\n");
    }

    public static void printValues(float[] array, String msg) {
        int count = 0;
        System.out.println(msg);
        for (float element : array) {
            if (count == 8) {
                System.out.println();
            }
            count++;
            System.out.printf("%.3f ", element);
        }
        System.out.println();
    }

    public static void printErrorMessage(int index) {
        System.out.println("\n" + "Ошибка! В массиве нет элемента с индексом " + index);
    }

    public static void printString(String string) {
        if (string == null) return;
        System.out.println(string);
    }

    public static void reportError(int startSymbol, int endSymbol) {
        System.out.println("Ошибка: левая граница (" + endSymbol + ") > правой (" + startSymbol + ")\n");
    }
}
