package com.github.absmarat.lesson_2_3_4.array;

public class SubstringConversion {
    public static void main(String[] args) throws InterruptedException {
        String sentence = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin\n";

        sentence = convertToUpperCase(sentence);
        print(sentence);

        sentence = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling\n";
        sentence = convertToUpperCase(sentence);
        print(sentence);

        //ПРОВЕРОЧНАЯ СТРОКА
        sentence = "Из ума, закалённого былыми горестями и унижениями, рождается мудрость!\n";
        sentence = convertToUpperCase(sentence);
        print(sentence);

        sentence = null;
        convertToUpperCase(sentence);
        print(sentence);

        sentence = "";
        sentence = convertToUpperCase(sentence);
        print(sentence);
    }

    private static String convertToUpperCase(String sentence) {
        if (sentence == null) {
            return null;
        }

        if (sentence.isBlank()) {
            return sentence;
        }

        // УДАЛЕНИЕ (ЗАМЕНА) ЗНАКОВ ПРЕПИНАНИЯ
        String punctuationFreeSentence = sentence.replaceAll("\\p{P}", "");

        // РАЗДЕЛЕНИЕ СТРОКИ НА МАССИВ ПОДСТРОК
        String[] words = punctuationFreeSentence.split(" ");

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
        if (shortestWordIndex < longestWordIndex) {
            for (int i = 0; i < length; i++) {
                if ((i < shortestWordIndex) || (longestWordIndex < i)) {
                    modifiedSentence = modifiedSentence.append(punctuationSentence[i]).append(" ");
                } else {
                    modifiedSentence = modifiedSentence.append(punctuationSentence[i].toUpperCase()).append(" ");
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if ((i < longestWordIndex) || (shortestWordIndex < i)) {
                    modifiedSentence = modifiedSentence.append(punctuationSentence[i]).append(" ");
                } else {
                    modifiedSentence = modifiedSentence.append(punctuationSentence[i].toUpperCase()).append(" ");
                }
            }
        }
        return modifiedSentence.toString();
    }

    private static void print(String sentence) throws InterruptedException {
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
