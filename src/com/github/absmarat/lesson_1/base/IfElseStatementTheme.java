package com.github.absmarat.lesson_1.base;

public class IfElseStatementTheme {

    public static void main(String[] args) {
        // ЗАДАНИЕ 1
        System.out.println("1. Перевод псевдокода на язык Java\n");
        boolean isMale = false;
        if (!isMale) {
            System.out.print("Ты - женского пола,");
        } else {
            System.out.print("Ты - мужского пола,");
        }

        int age = 17;
        if (age >= 18) {
            System.out.print(" совершеннолетний,");
        } else {
            System.out.print(" не совершеннолетний,");
        }

        double height = 1.75;
        if (height < 1.80) {
            System.out.print(" рост меньше 180 см.,");
        } else {
            System.out.print(" рост больше 180 см.,");
        }

        char capitalLetter = 'X';
        if (capitalLetter == 'M') {
            System.out.println(" имя начинается на 'M'");
        } else if (capitalLetter == 'I') {
            System.out.println(" имя начинается на 'I'");
        } else {
            System.out.println(" имя начинается на " + "'" + capitalLetter + "'");
        }

        // ЗАДАНИЕ 2
        System.out.println("\n2. Поиск большего числа\n");
        int num1 = 200;
        int num2 = 100;
        if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " > " + num1);
        } else {
            System.out.println("Числа равны");
        }

        // ЗАДАНИЕ 3
        System.out.println("\n3. Проверка числа\n");
        int originalNum = -11;
        if (originalNum == 0) {
            System.out.println(originalNum);
        } else {
            String positivity = originalNum > 0 ? "положительным" : "отрицательным";
            String parity = originalNum % 2 == 0 ? "чётным" : "нечётным";
            System.out.printf("%d является %s и %s\n", originalNum, positivity, parity);
        }

        // ЗАДАНИЕ 4
        System.out.println("\n4. Поиск одинаковых цифр в числах\n");
        num1 = 123;
        num2 = 223;
        int hudredsNum1 = num1 / 100;
        int tensNum1 = num1 % 100 / 10;
        int onesNum1 = num1 % 10;
        int hundredsNum2 = num2 / 100;
        int tensNum2 = num2 % 100 / 10;
        int onesNum2 = num2 % 10;
        boolean isEqualNumbers = ((hudredsNum1 == hundredsNum2) ||
                (tensNum1 == tensNum2) || (onesNum1 == onesNum2));
        if (isEqualNumbers) {
            System.out.println("Исходные числа: " + num1 + " и " + num2);
            System.out.println("Одинаковые цифры в разрядах чисел: ");
            if (onesNum1 == onesNum2) {
                System.out.println(onesNum1 + " - разряд единиц");
            }
            if (tensNum1 == tensNum2) {
                System.out.println(tensNum1 + " - разряд десятков");
            }
            if (hudredsNum1 == hundredsNum2) {
                System.out.println(hudredsNum1 + " - разряд сотен");
            }
        } else {
            System.out.println("Ни одна цифра в разрядах чисел " + 
                    num1 + " и " + num2 + " не совпадает");
        }

        // ЗАДАНИЕ 5
        System.out.println("\n5. Определение символа по его коду\n");
        char symbol = '\u0057';
        if (symbol >= 'a' && symbol <= 'z') {
            System.out.println(symbol + " - строчная буква");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println(symbol + " - прописная буква");
        } else if (symbol >= '0' && symbol <= '9') {
            System.out.println(symbol + " - цифра");
        } else {
            System.out.println(symbol + " - ни буква и ни цифра");
        }

        // ЗАДАНИЕ 6
        System.out.println("\n6. Подсчет начисленных банком %\n");
        double amountOfDeposite = 321123.59;
        double interestRate = 10;
        if (amountOfDeposite < 100000) {
            interestRate = 5;
        } else if (amountOfDeposite >= 100000 && amountOfDeposite <= 300000) {
            interestRate = 7;
        }
        int interestPeriod = 365;
        int numberOfCalenderDays = 365;
        double amountOfInterest = (amountOfDeposite * interestRate * interestPeriod / 
                numberOfCalenderDays) / 100;
        System.out.printf("Сумма вклада: %.2f руб.\n" + 
                "Сумма начисленных процентов за год: %.2f руб.\n" +
                "Сумма вклада в конце срока: %.2f руб.\n", 
                amountOfDeposite, amountOfInterest, amountOfDeposite + amountOfInterest);

        // ЗАДАНИЕ 7
        System.out.println("\n7. Определение оценки по предметам\n");
        double historyPercentScore = 59;
        int historyGrade = 5;
        if (historyPercentScore <= 60) {
            historyGrade = 2;
        } else if (historyPercentScore > 60 && historyPercentScore <= 73) {
            historyGrade = 3;
        } else if (historyPercentScore > 73 && historyPercentScore <= 91) {
            historyGrade = 4;
        } 
        int csGrade = 5;
        double csPercentScore = 92;
        if (csPercentScore <= 60) {
            csGrade = 2;
        } else if (csPercentScore > 60 && csPercentScore <= 73) {
            csGrade = 3;
        } else if (csPercentScore > 73 && csPercentScore <= 91) {
            csGrade = 4;
        }
        System.out.println("История - " + historyGrade);
        System.out.println("Программирование - " + csGrade);
        System.out.println("Средний балл оценок по предмету: " + (historyGrade + csGrade) / 2F);
        System.out.println("Средний процент баллов: " + 
                (historyPercentScore + csPercentScore) / 2F);

        // ЗАДАНИЕ 8
        System.out.println("\n8. Расчет годовой прибыли\n");
        double monthlySales = 13025.233;
        double monthlyRent = 5123.018;
        double monthlyProductionCosts = 9001.729;
        double annualProfit = (monthlySales - monthlyRent - monthlyProductionCosts) * 12;
        if (annualProfit > 0) {
            System.out.printf("Прибыль за год: %+.2f%n", annualProfit);
        } else {
            System.out.printf("Прибыль за год: %.2f%n", annualProfit);
        }
    }
}