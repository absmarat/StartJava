package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {

    public static void main(String[] args) {
        String beforeMsg = "   До реверса: ";
        String afterMsg = "После реверса: ";

        int[] numbers = {};
        print(numbers, beforeMsg);
        reverseArray(numbers);
        print(numbers, afterMsg);

        int[] numbers1 = null;
        print(numbers1, beforeMsg);
        reverseArray(numbers1);
        print(numbers1, afterMsg);

        int[] numbers2 = {6, 8, 9, 1};
        print(numbers2, beforeMsg);
        reverseArray(numbers2);
        print(numbers2, afterMsg);

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        print(numbers3, beforeMsg);
        reverseArray(numbers3);
        print(numbers3, afterMsg);
    }

    private static void reverseArray(int[] array) {
        if (array == null) {
            return;
        }

        int len = array.length;
        for (int i = 0; i < len; i++) {
            int temp = array[i];
            array[i] = array[--len];
            array[len] = temp;
        }
    }

    private static void print(int[] array, String msg) {
        System.out.println(msg + Arrays.toString(array));
    }
}
