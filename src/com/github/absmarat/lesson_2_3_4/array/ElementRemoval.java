package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public class ElementRemoval {

    public static void main(String[] args) {
        int length = 15;
        float[] realNumbers = new float[length];
        int[] ints = {-1, 15, 0, 14};
        for (int index : ints) {
            if (index < 0 || index >= length) {
                System.out.println("Ошибка! В массиве нет элемента с индексом " + index);
                continue;
            }
            float[] modified = fillArrays(realNumbers, index);
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (modified[i] != realNumbers[i]) {
                    count++;
                }
            }
            printArrays(realNumbers, modified, index, count);
        }
    }

    private static float[] fillArrays(float[] realNumbers, int index) {
        int length = realNumbers.length;
        float[] modified;
        for (int i = 0; i < length; i++) {
            realNumbers[i] = (float) Math.random();
        }

        modified = Arrays.copyOf(realNumbers, length);

        for (int i = 0; i < length; i++) {
            modified[i] = realNumbers[i] > realNumbers[index] ? 0 : realNumbers[i];
        }
        return modified;
    }

    private static void printArrays(float[] original, float[] modified, int index, int count) {
        printValuesArray(original, "Исходный массив: ");
        printValuesArray(modified, "Изменённый массив: ");
        System.out.printf("Значение из ячейки по переданному индексу: %.3f \n", original[index]);
        System.out.println("Количество обнулённых ячеек: " + count + "\n");
    }

    private static void printValuesArray(float[] array, String msg) {
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
}
