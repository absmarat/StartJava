package com.github.absmarat.lesson_2_3_4.array;


public final class Arrays {

    private Arrays() {
        throw new AssertionError();
    }

     //АНИМАЦИЯ ЗАГРУЗКИ
    public static void simulateHacking() throws InterruptedException {
        char[] animationElements = {'-', '\\', '|', '/'};
        String msg = "Hacking: ";
        Console.displayThrobber(animationElements, msg);
    }

    // ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОВ В ВИДЕ ТРЕУГОЛЬНИКА
    public static String sortSymbols(char startSymbol, char endSymbol) {
        boolean asc = true;

        if (startSymbol > endSymbol) {
            Console.reportError(startSymbol, endSymbol);
        }

        int count = 1;
        int space = endSymbol - startSymbol;
        StringBuilder triangle = new StringBuilder();

        if (asc) {
            for (int i = startSymbol; i <= endSymbol; i++) {
                triangle.append(" ".repeat(space)).repeat(startSymbol, count).append("\n");
                space--;
                count += 2;
                startSymbol++;
            }
        } else {
            for (int i = endSymbol; i >= startSymbol; i--) {
                triangle.append(" ".repeat(space)).repeat(endSymbol, count).append("\n");
                count += 2;
                space--;
                endSymbol--;
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
