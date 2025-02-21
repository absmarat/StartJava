package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {

    public static void main(String[] args) {
        int[] numbers = {};
        enumerateArray(numbers);

        int[] numbers1 = null;
        enumerateArray(numbers1);

        int[] numbers2 = {6, 8, 9, 1};
        enumerateArray(numbers2);

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        enumerateArray(numbers3);
    }

    private static void enumerateArray(int[] array) {
        if (array == null) {
            System.out.println(array);
            return;
        }
        System.out.println("   До реверса: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("После реверса: " + Arrays.toString(array));
    }

    private static void reverseArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len--; i++) {
            int temp = array[i];
            array[i] = array[len];
            array[len] = temp;
        }
    }
}
