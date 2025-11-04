package com.github.absmarat.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        // ЗАДАНИЕ 1
        System.out.println("1. Вывод характеристик компьютера в консоль.\n");
        byte ramSizeGb = 16;
        short coreCount = 4;
        char systemDisc = 'C';
        int pcPrice = 70_000;
        long ssdSizeGb = 128;
        float monitorWidthPx = 1024F;
        double monitorHeightPx = 768;
        boolean isPc = true;
        System.out.println("Размер ОЗУ - " + ramSizeGb + " Гб" +
                "\nКоличество ядер - " + coreCount +
                "\nСистемный диск - " + systemDisc +
                "\nСтоимость ПК - " + pcPrice + " руб." +
                "\nОбъём SSD - " + ssdSizeGb + " Гб" +
                "\nРазрешение монитора - " + monitorWidthPx + "x" + monitorHeightPx + " пикселей" +
                "\nЭто ПК? - " + isPc);

        // ЗАДАНИЕ 2
        System.out.println("\n2. Расчёт стоимости товара со скидкой.\n");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double percent = 0.11;

        double basePrice = penPrice + bookPrice;
        double discountAmount = basePrice * percent;
        double discountPrice = basePrice - discountAmount;
        System.out.printf("Стоимость товара без скидки: %.2f руб.%n", basePrice);
        System.out.printf("Сумма скидки: %.2f руб.%n", discountAmount);
        System.out.printf("Стоимость товара со скидкой: %.2f руб.%n%n", discountPrice);

        // ЗАДАНИЕ 3
        System.out.println("3. Вывод слова JAVA.\n");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ a       a V a       a\n");

        // ЗАДАНИЕ 4
        System.out.println("4. Вывод min и max значений целых числовых типов\n");
        byte byteType = 127;
        short shortType = 32_767;
        int intType = 2_147_483_647;
        long longType = 9_223_372_036_854_775_807L;
        char charType = 65_535;
        System.out.println("Максимальное значение типа byte: " + byteType + "\n" +
                "Инкрементирование значения типа byte: " + (++byteType) + "\n" +
                "Декрементирование значения типа byte: " + (--byteType));
        System.out.println("Максимальное значение типа short: " + shortType + "\n" +
                "Инкрементирование значения типа short: " + (++shortType) + "\n" +
                "Декрементирование значения типа short: " + (--shortType));
        System.out.println("Максимальное значение типа int: " + intType + "\n" +
                "Инкрементирование значения типа int: " + (++intType) + "\n" +
                "Декрементирование значения типа int: " + (--intType));
        System.out.println("Максимальное значение типа long: " + longType + "\n" +
                "Инкрементирование значения типа long: " + (++longType) + "\n" +
                "Декрементирование значения типа long: " + (--longType));
        System.out.println("Максимальное значение типа char: " + (int) charType + "\n" +
                "Инкрементирование значения типа char: " + (int) (++charType) + "\n" +
                "Декрементирование значения типа char: " + (int) (--charType) + "\n");

        // ЗАДАНИЕ 5
        System.out.println("5. Перестановка значений переменных.\n");
        int num1 = 2;
        int num2 = 5;
        System.out.println("Исходные значения:\nnum1 = " + num1 + "\nnum2 = " + num2 + "\n");

        // способ 1
        System.out.println("Перестановка с помощью третьей переменной.");
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1 + "\nnum2 = " + num2 + "\n");

        // способ 2
        System.out.println("Перестановка с помощью арифметических операций.");
        num2 += num1;
        num1 = num2 - num1;
        num2 -= num1;
        System.out.println("num1 = " + num1 + "\nnum2 = " + num2 + "\n");

        // способ 3
        System.out.println("Перестановка с помощью побитовой операции.");
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println("num1 = " + num1 + "\nnum2 = " + num2 + "\n");

        // ЗАДАНИЕ 6
        System.out.println("6. Вывод символов и их кодов\n");
        char dollarSymbol = '$';
        char asterix = '*';
        char commercialAt = '@';
        char verticalLine = '|';
        char tilde = '~';
        System.out.println((byte) (dollarSymbol) + "    " + dollarSymbol);
        System.out.println((byte) (asterix) + "    " + asterix);
        System.out.println((byte) (commercialAt) + "    " + commercialAt);
        System.out.println((byte) (verticalLine) + "   " + verticalLine);
        System.out.println((byte) (tilde) + "   " + tilde + "\n");

        // ЗАДАНИЕ 7
        System.out.println("7. Вывод в консоль ASCII-арт Дюка\n");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underscore + leftParenthesis + " " +
                rightParenthesis + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underscore + underscore + underscore +
                underscore + slash + backslash + underscore + underscore + backslash + "\n");

        // ЗАДАНИЕ 8
        System.out.println("8. Манипуляции с сотнями, десятками и единицами числа\n");
        int num = 123;
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int ones = num % 10;
        System.out.printf("Число 123 содержит: %n  сотен -%2d%n  десятков -%2d%n  единиц -%2d%n",
                 hundreds, tens, ones);
        System.out.println("Сумма разрядов = " + (hundreds + tens + ones));
        System.out.println("Произведение разрядов = " + (hundreds * tens * ones + "\n"));

        // ЗАДАЧА 9
        System.out.println("9. Перевод секунд в часы, минуты и секунды\n");
        int totalSeconds = 86399;
        int hh = totalSeconds / 3600;
        int mm = (totalSeconds % 3600) / 60;
        int ss = totalSeconds % 60;
        System.out.printf("%02d:%02d:%02d", hh, mm, ss);
    }
}