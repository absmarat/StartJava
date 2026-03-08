package com.github.absmarat.lesson_2_3_4.array;

import java.util.Random;

public final class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static long[] calcFactorials(int... numbers) {
        int length = numbers.length;
        long[] factorials = new long[length];

        for (int i = 0; i < length; i++) {
            factorials[i] = (numbers[i] < 0 || numbers[i] > 20) ? -1 : factorial(numbers[i]);
        }
        return factorials;
    }

    public static float[] createRandomArray(int length) {
        float[] randomNumbers = new float[length];
        for (int i = 0; i < length; i++) {
            randomNumbers[i] = (float) Math.random();
        }
        return randomNumbers;
    }

    public static void checkPasswordStrength(char[] password) throws InterruptedException {
        String[][] blacklist = {
                {"admin"},
                {"qwerty"},
                {"123456"}
        };

        StringBuilder reasonWeakness = new StringBuilder();

        if (password.length == 0) {
            reasonWeakness.append("\nПароль пуст.");
            Console.displayPasswordStrengthResult(reasonWeakness, password);
            return;
        }

        if (isPasswordInBlacklist(password, blacklist)) {
            reasonWeakness.append("\nПароль находится в чёрном списке.");
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
        status = (password.length >= 8 && (hasLower && hasUpper) && hasSpecial && hasDigit) ?
                status.append(ansiGreen).append("\b✗ Strong password: ").append(ansiReset).append(password) :
                status.append(ansiRed).append("\b✓ Password cracked: ").append(ansiReset).append(password);
        status.append(reasonWeakness);
        Console.displayPasswordStrengthResult(status, password);
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static char[] genaratePassword(int[][] asciiRange) {
        Random random = new Random();
        int passwordLength = random.nextInt(6, 13);
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int indexRange = random.nextInt(asciiRange.length);
            int lowBound = asciiRange[indexRange][0];
            int highBound = asciiRange[indexRange][1];
            char symbol = (char) random.nextInt(lowBound, highBound + 1);
            password.append(symbol);
        }
        return password.toString().toCharArray();
    }

    private static boolean isPasswordInBlacklist(char[] password, String[][] blacklist) {
        String passwordStr = new String(password);
        for (String[] blacklistedPassword : blacklist) {
            if (passwordStr.equals(blacklistedPassword[0])) {
                return true;
            }
        }
        return false;
    }

    public static float[] overwriteWithZerosIfGreaterThanIndex(float[] original, int index, int length) {
        float[] modified = original.clone();

        for (int i = 0; i < length; i++) {
            modified[i] = original[i] > original[index] ? 0 : original[i];
        }
        return modified;
    }

    public static int[] reverse(int[] array) {
        int length = array.length;
        int index = 0;
        int[] reversed = new int[length];

        for (int value : array) {
            reversed[length - 1 - index++] = value;
        }
        return reversed;
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
}
