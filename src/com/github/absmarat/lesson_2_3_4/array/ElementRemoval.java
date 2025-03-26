package com.github.absmarat.lesson_2_3_4.array;

public class ElementRemoval {

    public static void main(String[] args) {
        int length = 15;
        float[] realNumbers = new float[length];
        int[] ints = {-1, 15, 0, 14};
        for (int index : ints) {
            if (index < 0 || index >= length) {
                continue;
            }
            float[] modified = fillArrays(realNumbers, index);
            print(realNumbers, modified, index);
        }
    }

    private static float[] fillArrays(float[] realNumbers, int index) {
        int length = realNumbers.length;
        float[] modified = new float[length];
        for (int i = 0; i < length; i++) {
            realNumbers[i] = (float) Math.random();
            modified[i] = realNumbers[i];
        }

        for (int i = 0; i < length; i++) {
            modified[i] = realNumbers[i] > realNumbers[index] ? 0 : realNumbers[i];
        }
        return modified;
    }

    private static void print(float[] original, float[] modified, int index) {
        int count = 0;
        splitArray(original, count, "Исходный массив: ");
        splitArray(modified, count, "Изменённый массив: ");
        System.out.printf("Значение из ячейки по переданному индексу: %.3f \n", original[index]);

        int length = modified.length;
        for (int i = 0; i < length; i++) {
            if (modified[i] != original[i]) {
                count++;
            }
        }
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
