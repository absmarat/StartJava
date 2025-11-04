package com.github.absmarat.lesson_2_3_4.array;

public final class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static long[] calFctorial(int... numbers) {
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

    public static String[] convertSubstringToUpperCase(String originalText) {
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

    public static float[] fillArray(float[] floatNumbers, int index) {
        int length = floatNumbers.length;

        for (int i = 0; i < length; i++) {
            floatNumbers[i] = (float) Math.random();
        }

        float[] modified = java.util.Arrays.copyOf(floatNumbers, length);

        for (int i = 0; i < length; i++) {
            modified[i] = floatNumbers[i] > floatNumbers[index] ? 0 : floatNumbers[i];
        }
        return modified;
    }

    public static String hack() throws InterruptedException {
        String msg = "Hacking: ";
        return Console.displayLoading(msg);
    }

    public static void reverse(int[] array) {
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

        if (asc) {
            for (i = 1; i <= chars.length; i++) {
                triangle.append(" ".repeat(chars.length - i))
                        .append(String.valueOf(chars[i - 1]).repeat(i * 2 - 1))
                        .append("\n");
            }
        } else {
            int j = 1;
            for (i = chars.length - 1; i >= 0; j++, i--) {
                triangle.append(" ".repeat(chars.length - j))
                        .append(String.valueOf(chars[i]).repeat(j * 2 - 1))
                        .append("\n");
            }
        }
        return triangle.toString();
    }
}
