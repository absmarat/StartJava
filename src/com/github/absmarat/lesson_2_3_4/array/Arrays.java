package com.github.absmarat.lesson_2_3_4.array;


public final class Arrays {

    private Arrays() {
        throw new AssertionError();
    }

    // АНИМАЦИЯ ЗАГРУЗКИ
    public static void simulateHacking(char[] animationElements, String msg) throws InterruptedException {
        Console.displayThrobber(animationElements, msg);
    }

    // ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОЛВ В ВИДЕ ТРЕУГОЛЬНИКА
    public static String sortSymbols(int startPoint, int endPoint, boolean isAscendingSort) {
        if (startPoint > endPoint) {
            Console.reportError(startPoint, endPoint);
        }

        int count = 1;
        int space = endPoint - startPoint;
        StringBuilder triangle = new StringBuilder();
        if (isAscendingSort) {
            for (int i = startPoint; i <= endPoint; i++) {
                triangle = triangle.append(" ".repeat(space)).repeat(startPoint, count).append("\n");
                space--;
                count += 2;
                startPoint++;
            }
        } else {
            for (int i = endPoint; i >= startPoint; i--) {
                triangle = triangle.append(" ".repeat(space)).repeat(endPoint, count).append("\n");
                count += 2;
                space--;
                endPoint--;
            }
        }
        return triangle.toString();
    }

    // УДАЛЕНИЕ ЭЛЕМЕНТОВ МАССИВА, ПРЕВЫШАЮЩИХ ЗАДАННОЕ ЗНАЧЕНИЕ
    public static float[] fillArrays(float[] realNumbers, int index) {
        int length = realNumbers.length;

        for (int i = 0; i < length; i++) {
            realNumbers[i] = (float) Math.random();
        }

        float[] modified = java.util.Arrays.copyOf(realNumbers, length);

        for (int i = 0; i < length; i++) {
            modified[i] = realNumbers[i] > realNumbers[index] ? 0 : realNumbers[i];
        }
        return modified;
    }

    // ВЫЧИСЛЕНИЕ ФАКТОРИАЛА
    public static long[] calculate(int... numbers) {
        if (numbers == null) {
            return null;
        }

        int length = numbers.length;
        long[] factorials = new long[length];
        for (int i = 0; i < length; i++) {
            long factorial = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    // РЕВЕРС ЭЛЕМЕНТОВ МАССИВА
    public static void reverseArrayValues(int[] array) {
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

    // ЭФФЕКТ ПЕЧАТНОЙ МАШИНКИ
    public static String[] convertToUpperCaseRange(String originalText) {
        if (originalText == null || originalText.isBlank()) {
            return null;
        }

        String[] words = originalText.split(" ");
        String shortestWord = words[0];
        String longestWord = words[0];
        int shortestWordIndex = 0;
        int longestWordIndex = 0;

        for (int i = 0; i < words.length; i++) {
            String noPunctuation = words[i].replaceAll("[\\p{P}\\s]+", "");
            if (noPunctuation.isEmpty()) continue;

            if (noPunctuation.length() < shortestWord.length()) {
                shortestWord = noPunctuation;
                shortestWordIndex = i;
            } else if (noPunctuation.length() > longestWord.length()) {
                longestWord = noPunctuation;
                longestWordIndex = i;
            }
        }

        if (shortestWordIndex > longestWordIndex) {
            int swap = shortestWordIndex;
            shortestWordIndex = longestWordIndex;
            longestWordIndex = swap;
        }

        for (int i = shortestWordIndex; i <= longestWordIndex; i++) {
            words[i] = words[i].toUpperCase();
        }
        return words;
    }
}
