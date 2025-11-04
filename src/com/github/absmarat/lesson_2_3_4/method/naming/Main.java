package com.github.absmarat.lesson_2_3_4.method.naming;

public class Main {
    public static void main(String[] args) { 
        execNonBooleanMethods();
        execBooleanMethods();
    }

    private static void execNonBooleanMethods() {
        NonBooleanMethod nonBm = new NonBooleanMethod();
        System.out.println("1. Не boolean-методы\n");
        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.countNumberUiqueWords();
        nonBm.displayErrorMessage();
        nonBm.synchronizeData();
        nonBm.restoreData();
        nonBm.pauseFileDownload();
        nonBm.resetToFactoryDefaults();
        nonBm.writeContentsToFile();
        nonBm.convertTemperature();
        nonBm.enterMathExpression();
        nonBm.determineWinner();
        nonBm.findBookByAuthor();
    }

    private static void execBooleanMethods() {
        BooleanMethod bm = new BooleanMethod();
        System.out.println("\n2. Boolean-методы\n");
        System.out.println(bm.shouldTerminateProgram());
        System.out.println(bm.isDeletedFile());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isEnteredLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasGameAttempts());
        System.out.println(bm.isEmptyLine());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidFile());
        System.out.println(bm.isExistFile());
    }
}