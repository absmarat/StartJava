package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {

    public static void main(String[] args) {
        String str1 = "   До реверса: ";
        String str2 = "После реверса: ";

        int[] numbers = {};
        print(numbers, str1);
        reverseArray(numbers);
        print(numbers, str2);

        int[] numbers1 = null;
        print(numbers1, str1);
        reverseArray(numbers1);
        print(numbers1, str2);

        int[] numbers2 = {6, 8, 9, 1};
        print(numbers2, str1);
        reverseArray(numbers2);
        print(numbers2, str2);

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        print(numbers3, str1);
        reverseArray(numbers3);
        print(numbers3, str2);
    }

    private static void print(int[] array, String str) {
        System.out.println(str + Arrays.toString(array));
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
}
