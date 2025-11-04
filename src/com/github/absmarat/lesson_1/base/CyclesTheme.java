package com.github.absmarat.lesson_1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        // ЗАДАНИЕ 1
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int evenSum = 0;
        int oddSum = 0;
        int min = -10;
        int max = 21;
        int counter = min;
        do {
            if (counter % 2 == 0) {
                evenSum = evenSum + counter;
            } 
            if (counter % 2 != 0) {
                oddSum = oddSum + counter;
            }
            counter++;
        } while (counter <= max);
        System.out.println("\nВ отрезке [" + min + ";" + max + "] сумма чётных чисел = " + evenSum + 
                ", а нечетных = " + oddSum);

        // ЗАДАНИЕ 2
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания\n");
        int number1 = 10;
        int number2 = 5;
        max = number1;
        min = number2;
        if (number1 < number2) {
            min = number1;
            max = number2;
        }
        int number3 = -1;
        if (number3 > max) {
            max = number3;
        }
        if (number3 < min) {
            min = number3;
        }
        for (max -= 1; max > min; max--) {
            System.out.print(max + " ");
        }

        // ЗАДАНИЕ 3
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");
        int originalNumber = 1234;
        int currentNumber = originalNumber;
        int reversedNumber = 0;
        int sum = 0;
        while (currentNumber > 0) {
            int remainder = currentNumber % 10;
            currentNumber /= 10;
            reversedNumber = reversedNumber * 10 + remainder;
            sum += remainder;
        }
        System.out.println("Число: " + reversedNumber);
        System.out.println("Сумма: " + sum);

        // ЗАДАНИЕ 4
        System.out.println("\n4. Вывод чисел в несколько строк\n");
        int number = 200;
        int lineLength = 30;
        for (int i = 1; i < number; i += lineLength * 2) {
            System.out.printf("%3d", i);
            for (int j = i + 2; j < i + lineLength * 2; j += 2) {
                if (j < number) {
                    System.out.printf("%4d", j);
                } else {
                    System.out.printf("%4d", 0);
                }
            }
            System.out.println();
        }
        
        // ЗАДАНИЕ 5
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность\n");
        originalNumber = 3_242_592;
        currentNumber = originalNumber;
        int twosCount = 0;
        while (currentNumber > 0) {
            if ((currentNumber % 10) == 2) {
                twosCount++;
            }
            currentNumber /= 10;
        }
        String state = (twosCount % 2 == 0) ? "чётное" : "нечётное";
        System.out.println("В " + originalNumber + " " + state +
                " (" + twosCount + ") количество двоек");

        // ЗАДАНИЕ 6
        System.out.println("\n6. Вывод геометрических фигур\n");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        int row = 1;
        while (row <= 5) {
            int elementCounter = row;
            while (elementCounter <= 5) {
                System.out.print("#");
                elementCounter++;
            }
            System.out.println();
            row++;
        }
        System.out.println();

        int maxStringLength = 5;
        int totalLines = 2 * maxStringLength - 1;
        int elementReduction = 1;
        int currentStringLength = 1;
        row = 1;
        do {
            int elementCounter = 0;
            do {
                System.out.print("$");
                elementCounter++;
            } while (elementCounter < currentStringLength);
            System.out.println();
            if (elementCounter == maxStringLength) {
                elementReduction = -1;
            }
            currentStringLength += elementReduction;
            row++;
        } while (row <= totalLines);

        // ЗАДАНИЕ 7
        System.out.println("\n7. Вывод ASCII-символов\n");
        System.out.printf("%-10s%-13s%-3s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 122; i += 2) {
            if (i <= 47) {
                System.out.printf("  %-12d%-14c%-20s%n", i, i, Character.getName(i));
            } else if ((i >= 97) && (i <= 122)) {
                System.out.printf("  %-12d%-14c%-20s%n", i, i, Character.getName(i));
            }
        }

        // ЗАДАНИЕ 8
        System.out.println("\n8. Проверка, является ли число палиндромом\n");
        originalNumber = 1234321;
        currentNumber = originalNumber;
        reversedNumber = 0;
        while (currentNumber > 0) {
            int remainder = currentNumber % 10;
            currentNumber /= 10;
            reversedNumber = reversedNumber * 10 + remainder;
        }
        state = (originalNumber == reversedNumber) ? 
                " - палиндром" : " - не является палиндромом";
        System.out.println("Число " + originalNumber + state);

        // ЗАДАНИЕ 9
        System.out.println("\n9. Проверка, является ли число счастливым\n");
        originalNumber = 123321;
        number1 = originalNumber % 1000;
        number2 = originalNumber / 1000;
        int firstHalfNumber = number1;
        int secondHalfNumber = number2;
        int sum1 = 0;
        int sum2 = 0;
        while (secondHalfNumber > 0) {
            int remainder = firstHalfNumber % 10;
            sum1 += remainder;
            firstHalfNumber /= 10;
            remainder = secondHalfNumber % 10;
            sum2 += remainder;
            secondHalfNumber /= 10;
        }
        state = (sum1 == sum2) ? "счастливое" : "несчастливое";
        System.out.println("Число " + originalNumber + " - " + state);
        System.out.println("Сумма цифр " + number1 + " равна " + sum1);
        System.out.println("Сумма цифр " + number2 + " равна " + sum2);

        // ЗАДАНИЕ 10
        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");
        System.out.print("_|");
        for (int i = 1; i < 9; i++) {
            System.out.printf("__%1d", i + 1);
        }
        System.out.println();
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%1d|", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}