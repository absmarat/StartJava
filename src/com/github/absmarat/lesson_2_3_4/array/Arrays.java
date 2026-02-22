package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public final class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static long[] calFctorial(int... numbers) {
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

    public static float[] fillArray(float[] floatNumbers, int length) {
        for (int i = 0; i < length; i++) {
            floatNumbers[i] = (float) Math.random();
        }
        return floatNumbers;
    }

    public static char[] generateRandomSymbols(String[] ranges) {
        StringBuilder password = new StringBuilder();
        Random rdm = new Random();
        int passwordLength = rdm.nextInt(6, 13);

        for (int i = 0; i < passwordLength; i++) {
            String range = ranges[rdm.nextInt(ranges.length)];
            String[] bounds = range.split(",");
            int lowBound = Integer.parseInt(bounds[0]);
            int highBound = Integer.parseInt(bounds[1]);
            char symbol = (char) rdm.nextInt(lowBound, highBound + 1);
            password.append(symbol);
        }
        return password.toString().toCharArray();
    }

    public static int[] reverse(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int temp = array[i];
            array[i] = array[--len];
            array[len] = temp;
        }
        return array;
    }

    public static String sortSymbols(char startSymbol, char endSymbol, boolean asc) {
        if (startSymbol > endSymbol) {
            Console.reportError(endSymbol, startSymbol);
            return null;
        }

        char[] chars = new char[endSymbol - startSymbol];
        int i = 0;

        for (char ch = startSymbol; ch < endSymbol; ch++) {
            chars[i++] = ch;
        }

        StringBuilder triangle = new StringBuilder();

        for (i = 1; i <= chars.length; i++) {
            int index = asc ? i - 1 : chars.length - i;
            triangle.append(" ".repeat(chars.length - i))
                    .append(String.valueOf(chars[index]).repeat(i * 2 - 1))
                    .append("\n");
        }
        return triangle.toString();
    }

    public static String[] toUpperCaseRange(String originalText) {
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

    public static float[] zeroOutSomeValues(float[] floatNumbers, int index, int length) {
        float[] modified = java.util.Arrays.copyOf(floatNumbers, length);

        for (int i = 0; i < length; i++) {
            modified[i] = floatNumbers[i] > floatNumbers[index] ? 0 : floatNumbers[i];
        }
        return modified;
    }
}
