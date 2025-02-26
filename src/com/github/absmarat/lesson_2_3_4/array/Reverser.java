package com.github.absmarat.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {

    public static void main(String[] args) {
        int[] numbers = {};
        print(numbers);
        reverseArray(numbers);
        System.out.println("После реверса: " + Arrays.toString(numbers));

        int[] numbers1 = null;
        print(numbers1);
        reverseArray(numbers1);
        System.out.println("После реверса: " + Arrays.toString(numbers1));

        int[] numbers2 = {6, 8, 9, 1};
        print(numbers2);
        reverseArray(numbers2);
        System.out.println("После реверса: " + Arrays.toString(numbers2));

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        print(numbers3);
        reverseArray(numbers3);
        System.out.println("После реверса: " + Arrays.toString(numbers3));
    }

    private static void print(int[] array) {
        System.out.println("   До реверса: " + Arrays.toString(array));
    }

    private static void reverseArray(int[] array) {
        if (array == null) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len--; i++) {
            int temp = array[i];
            array[i] = array[len];
            array[len] = temp;
        }
    }
}
