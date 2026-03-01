package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public final class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static long[] calcFactorial(int... numbers) {
        int length = numbers.length;
        long[] factorials = new long[length];

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = -1;
            } else  if (numbers[i] > 20) {
                factorials[i] = -2;
            } else {
                factorials[i] = factorial(numbers[i]);
            }
        }
        return factorials;
    }

    public static StringBuilder checkPasswordStrength(char[] password) throws InterruptedException {
        StringBuilder reasonWeakness = new StringBuilder();

        if (password == null) {
            reasonWeakness.append("Ошибка: массив равен null или пустой.");
            return reasonWeakness;
        }

        boolean isBlacklisted = comparePasswordWithBlacklist(password);

        if (isBlacklisted) {
            reasonWeakness.append("Пароль находится в чёрном списке!");
        }

        if (password.length == 0) {
            reasonWeakness.append("Пароль не может быть пустым!");
            return reasonWeakness;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char symbol : password) {
            if (symbol >= '0' && symbol <= '9') {
                hasDigit = true;
            } else if (symbol >= 'a' && symbol <= 'z') {
                hasLower = true;
            } else if (symbol >= 'A' && symbol <= 'Z') {
                hasUpper = true;
            } else {
                hasSpecial = true;
            }
        }

        if (password.length <= 7) {
            reasonWeakness.append("\nПароль должен быть не менее 8 символов");
        }

        if (hasDigit && !hasLower && !hasUpper && !hasSpecial) {
            reasonWeakness.append("\nПароль содержит только цифры");
        }

        if ((hasLower && hasUpper) && !hasDigit && !hasSpecial) {
            reasonWeakness.append("\nПароль содержит только буквы");
        }

        if (hasSpecial && !hasLower && !hasUpper && !hasDigit) {
            reasonWeakness.append("\nПароль содержит только специальные символы");
        }

        if (!hasSpecial && hasLower && hasUpper && hasDigit) {
            reasonWeakness.append("\nПароль не содержит специальные символы");
        }

        if (!hasLower && !hasUpper) {
            reasonWeakness.append("\nПароль не содержит буквы нижнего и верхнего регистров");
        }

        if (!hasDigit) {
            reasonWeakness.append("\nПароль не содержит цифр");
        }

        String ansiReset = "\u001B[0m";
        String ansiRed = "\u001B[31m";
        String ansiGreen = "\u001B[32m";

        StringBuilder status = new StringBuilder();
        status = (password.length >= 8 && hasLower && hasUpper && hasSpecial && hasDigit) ?
                status.append(ansiGreen).append("\b✗ Strong password: ").append(ansiReset).append(password) :
                status.append(ansiRed).append("\b✓ Password cracked: ").append(ansiReset).append(password);
        return status.append(reasonWeakness);
    }

    private static boolean comparePasswordWithBlacklist(char[] password) {
        boolean isEquals = false;

        String[][] blacklistedPasswords = {
                {"123456", "1/?*6]^8"},
                {"%@(#0-P=9;2", "{Acnu`Gl^{?"},

        };

        char[] symbols = new char[0];
        for (int i = 0; i < blacklistedPasswords.length; i++) {
            String[] blacklistedPassword = blacklistedPasswords[i];
            for (String element : blacklistedPassword) {
                symbols = element.toCharArray();
                if (java.util.Arrays.equals(password, symbols)) return true;
            }
        }
        return isEquals;
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static float[] fillArray(float[] floatNumbers, int length) {
        for (int i = 0; i < length; i++) {
            floatNumbers[i] = (float) Math.random();
        }
        return floatNumbers;
    }

    public static char[] generatePassword(String[] ranges) {
        Random rdm = new Random();
        int passwordLength = rdm.nextInt(6, 13);
        StringBuilder password = new StringBuilder();

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
        int[] reversedArray = new int[len];

        for (int i = 0; i < len; i++) {
            reversedArray[i] = array[len - i - 1];
        }
        return reversedArray;
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

    public static float[] zeroValuesAboveIndexValue(float[] floatNumbers, int index, int length) {
        float[] modified = java.util.Arrays.copyOf(floatNumbers, length);

        for (int i = 0; i < length; i++) {
            modified[i] = floatNumbers[i] > floatNumbers[index] ? 0 : floatNumbers[i];
        }
        return modified;
    }
}
