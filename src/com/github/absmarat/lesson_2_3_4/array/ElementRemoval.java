package com.github.absmarat.lesson_2_3_4.array;

public class ElementRemoval {

    public static void main(String[] args) {
        int[] ints = {-1, 15, 0, 14};
        float[] realNumbers = new float[15];

        for (int number : ints) {
            float[] modified = fillArray(realNumbers, number);
            print(realNumbers, modified, number);
        }
    }

    private static float[] fillArray(float[] realNumbers, int number) {
        int length = realNumbers.length;
        float[] modified = new float[length];
        for (int i = 0; i < length; i++) {
            realNumbers[i] = (float) Math.random();
            modified[i] = realNumbers[i] > number ? 0 : realNumbers[i];
        }
        return modified;
    }

    private static void print(float[] original, float[] modified, int number) {
        int count = 0;
        splitArray(original, count, "Исходный массив: ");
        splitArray(modified, count, "Изменённый массив: ");

        int length = modified.length;
        for (int i = 0; i < length; i++) {
            if (modified[i] != original[i]) {
                count++;
            }
        }
        System.out.println("Значение из ячейки по переданному индексу: " + number);
        System.out.println("Количество обнулённых ячеек: " + count + "\n");
    }

    private static void splitArray(float[] array, int count, String msg) {
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
