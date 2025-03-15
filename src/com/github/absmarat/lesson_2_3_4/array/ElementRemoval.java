package com.github.absmarat.lesson_2_3_4.array;

public class ElementRemoval {

    public static void main(String[] args) {
        int[] ints = {-1, 15, 0, 14};

        int index = 0;
        int[] overwritten = overwrite(ints, ints[index]);
        print(ints, overwritten, ints[index]);

        index = 1;
        overwritten = overwrite(ints, ints[index]);
        print(ints, overwritten, ints[index]);

        index = 2;
        overwritten = overwrite(ints, ints[index]);
        print(ints, overwritten, ints[index]);

        index = 3;
        overwritten = overwrite(ints, ints[index]);
        print(ints, overwritten, ints[index]);
    }

    private static int[] overwrite(int[] nums, int index) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (nums[i] > index) ? 0 : nums[i];
        }
        return result;
    }

    private static void print(int[] nums, int[] overwritten, int index) {
        System.out.print("Исходный массив: ");
        for (int x : overwritten) {
            System.out.print(x + " ");
        }
        System.out.println();

        int count = 0;
        float[] realNumbers = new float[15];
        int length = realNumbers.length;
        System.out.println("Изменённый массив: ");
        for (int i = 0; i < length; i++) {
            count++;
            realNumbers[i] = (float) Math.random();
            System.out.printf("%.3f ", realNumbers[i]);
            if (count == 8) {
                System.out.println();
            }
        }
        System.out.println();

        count = 0;
        length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != overwritten[i]) {
                count++;
            }
        }
        System.out.println("Значение из ячейки по переданному индексу: " + index);
        System.out.println("Количество обнулённых ячеек: " + count + "\n");
    }
}
