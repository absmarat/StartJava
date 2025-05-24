package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public final class Console {

    private Console(){
        throw new AssertionError();
    }

    // АНИМАЦИЯ ЗАГРУЗКИ
    public static void determainStatus(String msg) {
        Random rdm = new Random();
        int number = rdm.nextInt(100);
        System.out.print(msg);
        String result = (number > 70) ? (Main.ANSI_RED + "Access Granted!") : (Main.ANSI_GREEN + "Access Denied!");
        System.out.print(result + Main.ANSI_RESET + "\n\n");
    }

    public static void displayThrobber(char[] array, String msg) throws InterruptedException {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (char element : array) {
                System.out.print(msg + element + "\r");
                Thread.sleep(200);
            }
        }
    }

    // ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОЛВ В ВИДЕ ТРЕУГОЛЬНИКА
    public static void printTriangle(String triangle) {
        System.out.println(triangle);
    }

    public static void reportError(int startPoint, int endPoint) {
        System.out.println("Ошибка: левая граница (" + startPoint + ") > правой (" + endPoint + ")");
    }

    // УДАЛЕНИЕ ЭЛЕМЕНТОВ МАССИВА, ПРЕВЫШАЮЩИХ ЗАДАННОЕ ЗНАЧЕНИЕ
    public static void printArrays(float[] original, float[] modified, int index, int count) {
        printArrayValues(original, "Исходный массив: ");
        printArrayValues(modified, "Изменённый массив: ");
        System.out.printf("Значение из ячейки по переданному индексу: %.3f \n", original[index]);
        System.out.println("Количество обнулённых ячеек: " + count + "\n");
    }

    public static void printArrayValues(float[] array, String msg) {
        int count = 0;
        System.out.println(msg);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (count == 8) {
                System.out.println();
            }
            count++;
            System.out.printf("%.3f ", array[i]);
        }
        System.out.println();
    }

    public static void printErrorMessage(int index) {
        System.out.println("Ошибка! В массиве нет элемента с индексом " + index);

    }

    // ВЫЧИСЛЕНИЕ ФАКТОРИАЛА
    public static void printExpr(long[] factorials, int[] original) {
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
        System.out.println();
    }

    // РЕВЕРС ЭЛЕМЕНТОВ МАССИВА
    public static void outputArrayValues(int[] array, String msg) {
        System.out.println(msg + Arrays.toString(array));
    }

    // ЭФФЕКТ ПЕЧАТНОЙ МАШИНКИ
    public static void printTextWithTypewriterEffect(String[] words) throws InterruptedException {
        System.out.printf("%n");
        if (words == null) {
            System.out.println("Ошибка: входной массив не может быть null.");
            return;
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                System.out.print(ch);
                //Thread.sleep(100);
            }
            System.out.print(" ");
        }
        //System.out.printf("%n");
    }
}
