package com.github.absmarat.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        reverseArray();
        simulateHacking();
        calculateFactorial();
        deleteArrayElement();
        createTriangle();
        createTypewriterEffect();
    }

    // РЕВЕРС ЭЛЕМЕНТОВ МАССИВА
    private static void reverseArray() {
        String beforeMsg = "   До реверса: ";
        String afterMsg = "После реверса: ";

        int[] numbers = {};
        Console.printNumbers(numbers, beforeMsg);
        Arrays.reverseArrayValues(numbers);
        Console.printNumbers(numbers, afterMsg);

        int[] numbers1 = null;
        Console.printNumbers(numbers1, beforeMsg);
        Arrays.reverseArrayValues(numbers1);
        Console.printNumbers(numbers1, afterMsg);

        int[] numbers2 = {6, 8, 9, 1};
        Console.printNumbers(numbers2, beforeMsg);
        Arrays.reverseArrayValues(numbers2);
        Console.printNumbers(numbers2, afterMsg);

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        Console.printNumbers(numbers3, beforeMsg);
        Arrays.reverseArrayValues(numbers3);
        Console.printNumbers(numbers3, afterMsg);
    }

    // АНИМАЦИЯ ЗАГРУЗКИ
    private static void simulateHacking() throws InterruptedException {
        String result = Arrays.determineHackResult();
        Console.displayThrobber(result);
    }

    // ВЫЧИСЛЕНИЕ ФАКТОРИАЛА
    private static void calculateFactorial() {
        int[] numbers = {};
        long[] factorials = Arrays.getFactorial(numbers);
        Console.printExpr(factorials, numbers);

        int[] numbers1 = null;
        factorials = Arrays.getFactorial(numbers1);
        Console.printExpr(factorials, numbers1);

        int[] numbers2 = {8, 0, 9};
        factorials = Arrays.getFactorial(numbers2);
        Console.printExpr(factorials, numbers2);

        int[] numbers3 = {-3, 1, 7, 13};
        factorials = Arrays.getFactorial(numbers3);
        Console.printExpr(factorials, numbers3);

        int[] numbers4 = {-22, -0};
        factorials = Arrays.getFactorial(numbers4);
        Console.printExpr(factorials, numbers4);
    }

    // УДАЛЕНИЕ ЭЛЕМЕНТОВ МАССИВА, ПРЕВЫШАЮЩИХ ЗАДАННОЕ ЗНАЧЕНИЕ
    private static void deleteArrayElement() {
        int length = 15;
        float[] floatNumbers = new float[length];
        int[] ints = {-1, 15, 0, 14};
        float[] modified;
        for (int index : ints) {
            if (index < 0 || index == length) {
                Console.printErrorMessage(index);
                continue;
            }
            modified = Arrays.fillArray(floatNumbers, index);
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (modified[i] != floatNumbers[i]) {
                    count++;
                }
            }
            Console.printArrays(floatNumbers, modified, index, count);
        }
    }

    // ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОВ В ВИДЕ ТРЕУГОЛЬНИКА
    private static void createTriangle() {
        String triangle = Arrays.sortSymbols('0', '9', false);
        Console.printString(triangle);

        triangle = Arrays.sortSymbols('i', '/', true);
        Console.printString(triangle);

        triangle = Arrays.sortSymbols('A', 'J', true);
        Console.printString(triangle);
    }

    // ЭФФЕКТ ПЕЧАТНОЙ МАШИНКИ
    private static void createTypewriterEffect() throws InterruptedException {
        String enteredText = """
                Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
                - James Gosling
                """;
        String[] modifiedText = Arrays.convertToUppercase(enteredText);
        Console.printText(modifiedText);

        enteredText = """
                Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
                - Robert Martin
                """;
        modifiedText = Arrays.convertToUppercase(enteredText);
        Console.printText(modifiedText);

        enteredText = null;
        modifiedText = Arrays.convertToUppercase(enteredText);
        Console.printText(modifiedText);

        enteredText = "";
        modifiedText = Arrays.convertToUppercase(enteredText);
        Console.printText(modifiedText);
    }
}
