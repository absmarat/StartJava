package com.github.absmarat.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        reverseArray();
        simulatePasswordHacking();
        calculateFactorial();
        fillArrayFloatNumbers();
        createTriangle();
        createTypewriterEffect();
    }

    private static void reverseArray() {
        String beforeMsg = "   До реверса: ";
        String afterMsg = "После реверса: ";
        int[][] initialData = {
                {},
                null,
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] numbers : initialData) {
            Console.printNumbers(numbers, beforeMsg);
            int[] reversed = (numbers == null) ? null : Arrays.reverse(numbers);
            Console.printNumbers(reversed, afterMsg);
        }
    }

    private static void simulatePasswordHacking() throws InterruptedException {
        String[] ranges = {"48,57", "65,90", "97,122", "65,90", "33,47", "58,64", "123,126"};
        char[] generatedPassword = Arrays.generateRandomSymbols(ranges);
        Console.displayLoading(generatedPassword);
    }

    private static void calculateFactorial() {
        int[][] initialData = {
                {},
                null,
                {8, 0, 9},
                {-3, 1, 7, 13},
                {-22, -0}
        };

        for (int[] numbers : initialData) {
            long[] facrorials = (numbers == null) ? null : Arrays.calFctorial(numbers);
            Console.printExpr(facrorials, numbers);
        }
    }

    private static void fillArrayFloatNumbers() {
        int length = 15;
        float[] floatNumbers = new float[length];
        int[] ints = {-1, 15, 0, 14};
        float[] filled;
        float[] modified;
        for (int index : ints) {
            if (index < 0 || index == length) {
                Console.printErrorMessage(index);
                continue;
            }
            filled = Arrays.fillArray(floatNumbers, length);
            modified = Arrays.zeroOutSomeValues(filled, index, length);

            int count = 0;
            for (int i = 0; i < length; i++) {
                if (modified[i] != floatNumbers[i]) {
                    count++;
                }
            }
            Console.printArrays(floatNumbers, modified, index, count);
        }
    }

    private static void createTriangle() {
        boolean[] sortFlags = {true, true, false};
        char[][] initialData = {
                {'0', '9'},
                {'i', '/'},
                {'A', 'J'}
        };
        int index = 0;

        for (char[] symbols : initialData) {
            char startSymbol = symbols[0];
            char endSymbol = symbols[1];
            String triangle = Arrays.sortSymbols(startSymbol, endSymbol, sortFlags[index++]);
            Console.printString(triangle);
        }
    }

    private static void createTypewriterEffect() throws InterruptedException {
        String[] quotes = {"Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
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
