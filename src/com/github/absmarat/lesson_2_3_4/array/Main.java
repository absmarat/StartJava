package com.github.absmarat.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        simulateHackingProcess();
        createTriangle();
        deleteArrayElement();
        calculateFactorial();
        reverseArray();
        createTypewriterEffect();
    }

    // АНИМАЦИЯ ЗАГРУЗКИ
    private static void simulateHackingProcess() throws InterruptedException {
        Arrays.simulateHacking();
        Console.determainStatus();
    }

    // ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОВ В ВИДЕ ТРЕУГОЛЬНИКА
    private static void createTriangle() {
        String triangle = Arrays.sortSymbols('0', '9');
        Console.printString(triangle);

        triangle = Arrays.sortSymbols('i', '/');
        Console.printString(triangle);

        triangle = Arrays.sortSymbols('A', 'J');
        Console.printString(triangle);
    }

    // УДАЛЕНИЕ ЭЛЕМЕНТОВ МАССИВА, ПРЕВЫШАЮЩИХ ЗАДАННОЕ ЗНАЧЕНИЕ
    private static void deleteArrayElement() {
        int length = 15;
        float[] realNumbers = new float[length];
        int[] ints = {-1, 15, 0, 14};
        float[] modified;
        for (int index : ints) {
            if (index < 0 || index >= length) {
                Console.printErrorMessage(index);
                continue;
            }
            modified = Arrays.fillArrays(realNumbers, index);
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (modified[i] != realNumbers[i]) {
                    count++;
                }
            }
            Console.printArrays(realNumbers, modified, index, count);
        }
    }

    // ВЫЧИСЛЕНИЕ ФАКТОРИАЛА
    private static void calculateFactorial() {
        int[] numbers = {};
        long[] factorials = Arrays.calculate(numbers);
        Console.printExpr(factorials, numbers);

        int[] numbers1 = null;
        factorials = Arrays.calculate(numbers1);
        Console.printExpr(factorials, numbers1);

        int[] numbers2 = {8, 0, 9};
        factorials = Arrays.calculate(numbers2);
        Console.printExpr(factorials, numbers2);

        int[] numbers3 = {-3, 1, 7, 13};
        factorials = Arrays.calculate(numbers3);
        Console.printExpr(factorials, numbers3);

        int[] numbers4 = {-22, -0};
        factorials = Arrays.calculate(numbers4);
        Console.printExpr(factorials, numbers4);
    }

    // РЕВЕРС ЭЛЕМЕНТОВ МАССИВА
    private static void reverseArray() {
        String beforeMsg = "   До реверса: ";
        String afterMsg = "После реверса: ";

        int[] numbers = {};
        Console.outputArrayValues(numbers, beforeMsg);
        Arrays.reverseArrayValues(numbers);
        Console.outputArrayValues(numbers, afterMsg);

        int[] numbers1 = null;
        Console.outputArrayValues(numbers1, beforeMsg);
        Arrays.reverseArrayValues(numbers1);
        Console.outputArrayValues(numbers1, afterMsg);

        int[] numbers2 = {6, 8, 9, 1};
        Console.outputArrayValues(numbers2, beforeMsg);
        Arrays.reverseArrayValues(numbers2);
        Console.outputArrayValues(numbers2, afterMsg);

        int[] numbers3 = {13, 8, 5, 3, 2, 1, 1};
        Console.outputArrayValues(numbers3, beforeMsg);
        Arrays.reverseArrayValues(numbers3);
        Console.outputArrayValues(numbers3, afterMsg);
    }

    // ЭФФЕКТ ПЕЧАТНОЙ МАШИНКИ
    private static void createTypewriterEffect() throws InterruptedException {
        String enteredText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling\n";
        String[] modifiedText = Arrays.convertToUpperCaseRange(enteredText);
        Console.printTextWithTypewriterEffect(modifiedText);

        enteredText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin\n";
        modifiedText = Arrays.convertToUpperCaseRange(enteredText);
        Console.printTextWithTypewriterEffect(modifiedText);

        enteredText = null;
        modifiedText = Arrays.convertToUpperCaseRange(enteredText);
        Console.printTextWithTypewriterEffect(modifiedText);

        enteredText = "";
        modifiedText = Arrays.convertToUpperCaseRange(enteredText);
        Console.printTextWithTypewriterEffect(modifiedText);
    }
}
