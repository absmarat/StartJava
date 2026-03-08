package com.github.absmarat.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        reverseTransactions();
        calculateFactorial();
        replaceWithZerosIfGreaterThanIndexValue();
        createTriangle();
        simulatePasswordHacking();
        createTypewriterEffect();
    }

    private static void reverseTransactions() {
        String beforeMsg = "   До реверса: ";
        String afterMsg = "После реверса: ";
        int[][] inputTransactions = {
                {},
                null,
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] transactions : inputTransactions) {
            Console.printNumbers(transactions, beforeMsg);
            int[] reversed = (transactions == null) ? null : Arrays.reverse(transactions);
            Console.printNumbers(reversed, afterMsg);
        }
    }

    private static void calculateFactorial() {
        int[][] inputNumbers = {
                {},
                null,
                {-5},
                {7, 0, 21},
                {1, 20, 5, -3}
        };

        for (int[] numbers : inputNumbers) {
            long[] factorials = (numbers == null) ? null : Arrays.calcFactorials(numbers);
            Console.printFactorialExpressions(factorials, numbers);
        }
    }

    private static void replaceWithZerosIfGreaterThanIndexValue() {
        int length = 15;
        int[] indexes = {-1, 15, 0, 14};
        for (int index : indexes) {
            if (index < 0 || index == length) {
                Console.printErrorMessage("В массиве нет элемента с индексом " + index);
                continue;
            }
            float[] created = Arrays.createRandomArray(length);
            float[] modified = Arrays.overwriteWithZerosIfGreaterThanIndex(created, index, length);
            int count = 0;

            for (int i = 0; i < length; i++) {
                if (modified[i] != created[i]) {
                    count++;
                }
            }
            Console.printArrays(created, modified, index, count);
        }
    }

    private static void createTriangle() {
        boolean[] sortFlags = {true, true, false};
        char[][] symbolRanges = {
                {'0', '9'},
                {'i', '/'},
                {'A', 'J'}
        };
        int index = 0;

        for (char[] symbols : symbolRanges) {
            char startSymbol = symbols[0];
            char endSymbol = symbols[1];
            String triangle = Arrays.sortSymbols(startSymbol, endSymbol, sortFlags[index++]);
            Console.printString(triangle);
        }
    }

    private static void simulatePasswordHacking() throws InterruptedException {
        int[][] asciiRanges = {
                {48, 57},
                {65, 90},
                {97, 122},
                {33, 47},
                {58, 64},
                {91, 96},
                {123, 126}
        };

        Arrays.checkPasswordStrength("123456".toCharArray());

        for (int i = 0; i < 3; i++) {
            char[] password = (asciiRanges.length == 0) ? new char[0] : Arrays.genaratePassword(asciiRanges);
            Arrays.checkPasswordStrength(password);
        }
    }

    private static void createTypewriterEffect() throws InterruptedException {
        String[] quotes = {"\nJava - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James Gosling\n",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin\n",
                null,
                " "};

        for (String quote : quotes) {
            String[] modifiedText = (quote == null || quote.isBlank()) ? null
                    : Arrays.toUpperCaseRange(quote);
            Console.displayTypewriterEffect(modifiedText);
        }
    }
}
