package com.github.absmarat.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String enteredText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling\n";
        String[] modifiedText = toUpperCaseRange(enteredText);
        type(modifiedText);

        enteredText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        modifiedText = toUpperCaseRange(enteredText);
        type(modifiedText);

        enteredText = null;
        modifiedText = toUpperCaseRange(enteredText);
        type(modifiedText);

        enteredText = "";
        modifiedText = toUpperCaseRange(enteredText);
        type(modifiedText);
    }

    private static String[] toUpperCaseRange(String originalText) {
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

    private static void type(String[] words) throws InterruptedException {
        if (words == null) {
            System.out.println("\nОшибка: входной массив не может быть null.");
            return;

        }
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.printf("%n");
    }
}
