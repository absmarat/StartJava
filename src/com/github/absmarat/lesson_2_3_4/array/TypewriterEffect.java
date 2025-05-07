package com.github.absmarat.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String enteredTxt = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling\n";
        enteredTxt = toUpperCaseRange(enteredTxt);
        type(enteredTxt);

        enteredTxt = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin\n";
        enteredTxt = toUpperCaseRange(enteredTxt);
        type(enteredTxt);

        enteredTxt = null;
        toUpperCaseRange(enteredTxt);
        type(enteredTxt);

        enteredTxt = "";
        enteredTxt = toUpperCaseRange(enteredTxt);
        type(enteredTxt);
    }

    private static String toUpperCaseRange(String sentence) {
        if (sentence == null) {
            return null;
        }

        if (sentence.isBlank()) {
            return sentence;
        }

        // УДАЛЕНИЕ (ЗАМЕНА) ЗНАКОВ ПРЕПИНАНИЯ
        String noPunctuation = sentence.replaceAll("[\\p{P}\\s]+", " ");

        // РАЗДЕЛЕНИЕ СТРОКИ НА МАССИВ ПОДСТРОК
        String[] words = noPunctuation.split(" ");

        // ОПРЕДЕЛЕНИЕ САМОГО КОРОТКОГО И САМОГО ДЛИННОГО СЛОВА В СТРОКЕ И ИХ ИНДЕКСОВ
        String shortestWord = words[0];
        String longestWord = words[0];
        int shortestWordIndex = 0;
        int longestWordIndex = 0;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (words[i].length() < shortestWord.length()) {
                shortestWord = words[i];
                shortestWordIndex = i;
            } else if (words[i].length() > longestWord.length()){
                longestWord = words[i];
                longestWordIndex = i;
            }
        }

        // ПРЕОБРАЗОВАНИЕ ПОДСТРОКИ В ВЕРХНИЙ РЕГИСТР
        String[] punctuationSentence = sentence.split(" ");
        StringBuilder modifiedSentence = new StringBuilder();
        length = punctuationSentence.length;
        for (int i = 0; i < length; i++) {
            if (shortestWordIndex < longestWordIndex) {
                modifiedSentence = ((i < shortestWordIndex) || (longestWordIndex < i))
                        ? modifiedSentence.append(punctuationSentence[i]).append(" ")
                        : modifiedSentence.append(punctuationSentence[i].toUpperCase()).append(" ");
            } else {
                modifiedSentence = ((i < longestWordIndex) || (shortestWordIndex < i))
                        ? modifiedSentence.append(punctuationSentence[i]).append(" ")
                        : modifiedSentence.append(punctuationSentence[i].toUpperCase()).append(" ");
            }
        }
        return modifiedSentence.toString();
    }

    private static void type(String sentence) throws InterruptedException {
        if (sentence == null) {
            System.out.println("null");
            return;
        }

        if (sentence.isBlank()) {
            System.out.println("Пустая строка.");
            return;
        }

        char[] chars = sentence.toCharArray();
        for (char ch : chars) {
            System.out.print(ch);
            //Thread.sleep(100);
        }
        System.out.println();
    }

}
