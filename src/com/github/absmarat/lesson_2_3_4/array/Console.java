package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public final class Console {
    private Console() {
        throw new AssertionError();
    }

    public static void displayLoading(char[] characterSet) throws InterruptedException {
        System.out.println();
        String symbols = new String(characterSet);
        char[] spins = {'-', '\\', '|', '/'};

        for (int i = 0; i < 3; i++) {
            for (char element : spins) {
                System.out.print("\b" + element);
                Thread.sleep(100);
            }
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char symbol : characterSet) {
            if (symbol >= '0' && symbol <= '9') {
                hasDigit = true;
            } else if (symbol >= 'a' && symbol <= 'z') {
                hasLower = true;
            } else if (symbol >= 'A' && symbol <= 'Z') {
                hasUpper = true;
            } else {
                hasSpecial = true;
            }
        }

        boolean isStrong;

        if (characterSet == null || characterSet.length == 0) {
            System.out.println("\bПароль не может быть пустым!");
            return;
        }

        if (characterSet.length < 8) {
            System.out.println("\bПароль должен содержать не менее 8 символов!");
            isStrong = false;
        }

        if (hasDigit && !hasLower && !hasUpper && !hasSpecial) {
            System.out.println("\bПароль содержит только цифры");
            isStrong = false;
        }

        if ((hasLower || hasUpper) && !hasDigit && !hasSpecial) {
            System.out.println("\bПароль содержит только буквы!");
            isStrong = false;
        }

        if (hasSpecial && !hasDigit && !hasLower && !hasUpper) {
            System.out.println("\bПароль содержит только специальные символы!");
            isStrong = false;
        }

        if (!hasSpecial) {
            System.out.println("\bПароль не содержит специальные символы!");
            isStrong = false;
        }

        if (!hasLower && !hasUpper) {
            System.out.println("Пароль не содержит буквы нижнего и верхнего регистров!");
            isStrong = false;
        }

        isStrong = (characterSet.length >= 8 && hasLower && hasUpper && hasSpecial && hasDigit) ?
                true : false;
        displayMsg(isStrong, symbols);
    }

    private static void displayMsg(boolean isStrong, String symbols) {
        String ansiReset = "\u001B[0m";
        String ansiRed = "\u001B[31m";
        String ansiGreen = "\u001B[32m";
        if (isStrong) {
            System.out.println(ansiRed + "\b✗ Strong password: " + ansiReset + symbols);
        } else {
            System.out.println(ansiGreen + "\b✓ Password cracked: " + ansiReset + symbols);
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
            System.out.println("\n" + "Массив нулевой длины!");
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
