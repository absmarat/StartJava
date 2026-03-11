package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public final class Console {
    private Console() {
        throw new AssertionError();
    }

    public static void displayPasswordStrengthResult(boolean isStrong, char[] password) {
        if (password.length == 0) {
            return;
        }

        StringBuilder message = new StringBuilder();
        String ansiReset = "\u001B[0m";
        String ansiRed = "\u001B[31m";
        String ansiGreen = "\u001B[32m";
        message = isStrong ?
                message.append(ansiGreen).append("\n✗ Strong password: ").append(ansiReset).append(password)
                : message.append(ansiRed).append("\n✓ Password cracked: ").append(ansiReset).append(password);
        System.out.print("\b" + message);
    }

    public static void displayLoading() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (char element : spins) {
                System.out.print("\b" + element);
                Thread.sleep(100);
            }
        }
    }

    public static void displayReasons(StringBuilder message) {
        System.out.print("\b" + message);
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

    public static void printFactorialExpressions(long[] factorials, int[] originalNumbers) {
        if (originalNumbers == null) {
            System.out.println("null");
            return;
        }

        if (originalNumbers.length == 0) {
            System.out.println("\nМассив нулевой длины!");
            return;
        }

        for (int i = 0; i < originalNumbers.length; i++) {
            if (originalNumbers[i] == 1 || originalNumbers[i] == 0) {
                System.out.println(originalNumbers[i] + "! = 1");
                continue;
            }

            if (originalNumbers[i] < 0) {
                System.out.println("Ошибка: факториал " + originalNumbers[i] + "! не определён!");
                continue;
            }

            if (originalNumbers[i] > 20) {
                System.out.println("Ошибка: " +
                        "факториал " + originalNumbers[i] + "! слишком велик (максимум 20!)");
                continue;
            }

            StringBuilder expr = new StringBuilder(originalNumbers[i] + "! = ");
            for (int j = 1; j <= originalNumbers[i]; j++) {
                expr.append(j);
                expr.append((j < originalNumbers[i]) ? " * " : " = ");
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

    public static void printErrorMessage(String message) {
        System.out.println("\nОшибка!" + message);
    }

    public static void printString(String string) {
        if (string == null) return;
        System.out.println(string);
    }

    public static void reportError(int startSymbol, int endSymbol) {
        System.out.println("Ошибка: левая граница (" + endSymbol + ") > правой (" + startSymbol + ")\n");
    }
}
