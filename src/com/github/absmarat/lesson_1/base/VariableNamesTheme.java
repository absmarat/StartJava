package com.github.absmarat.lesson_1.base;

public class VariableNamesTheme {
    
    public static void main(String[] args) {
        System.out.println("\n1. Разные переменные.");

        // ЗАДАНИЕ 1
        // Цифра
        int digit = 2;
        System.out.println("Цифра = " + digit);

        // Сумма чисел
        int numbersSum = 5;
        System.out.println("Сумма чисел = " + numbersSum);

        // Произведение цифр
        int digitsProduct = 10;
        System.out.println("Произведение цифр = " + digitsProduct);

        // Максимальное число
        int maxNumber = 2_147_483_647;
        System.out.println("Максимальное число = " + maxNumber);

        // Количество десятков
        int tensCount = 4;
        System.out.println("Количество десятков = " + tensCount);

        // Вес собаки
        double dogWeight = 15.2;
        System.out.println("Вес собаки = " + dogWeight);

        // Исходное число
        int originalNumber = 200;
        System.out.println("Исходное число = " + originalNumber);

        // Процент по вкладу
        double interestRate = 12;
        System.out.println("Процент по вкладу = " + interestRate + "%");

        // Переменная хранит символ &
        char ampersand = '&';
        System.out.println("Переменная хранит символ = " + ampersand);

        // Код ошибки
        String errorCode = "404";
        System.out.println("Код ошибки = " + errorCode);

        // Тип сообщения
        String messageType = "ERROR_MESSAGE";
        System.out.println("Тип сообщения = " + messageType);

        // Число нулей
        int zeroCount = 7;
        System.out.println("Число нулей = " + zeroCount);

        // Уникальное число
        int uniqueNumber = 55;
        System.out.println("Уникальное число = " + uniqueNumber);

        // Случайной число
        int randomNumber = 25;
        System.out.println("Случайное число = " + randomNumber);

        // Математическое выражение
        int mathExpression = 2 + 2;
        System.out.println("Математическое выражение = " + mathExpression);

        // Счёт в игре
        String gameScore = "5 : 2";
        System.out.println("Счёт в игре: " + gameScore);

        // Максимальная длина
        int maxLength = 15;
        System.out.println("Максимальная длина (длина) = " + maxLength);

        // Пункт меню
        String menuItem = "File";
        System.out.println("Пункт меню: " + menuItem);

        // Стоимость кофе
        int coffePrice = 200;
        System.out.println("Стоимость кофе = " + coffePrice + " руб.");

        // Дата начала
        String startDate = "25.10.2024";
        System.out.println("Дата начала: " + startDate);

        // Окончание диапазона
        int endRange = 32_767;
        System.out.println("Окончание диапазона = " + endRange);

        // Полное имя работника месяца
        String employeeFullNameOfMonth = "Иванов Иван Иванович";
        System.out.println("Полное имя работника месяца: " + employeeFullNameOfMonth);

        // Заголовок электронной книги
        String ebookTitle = "Энхиридион";
        System.out.println("Заголовок электронной книги: " + ebookTitle);

        // Размер
        char size = 'L';
        System.out.println("Размер: " + size);

        // Вместимость
        int capacity = 20;
        System.out.println("Вместимость: " + capacity);

        // Счётчик
        int counter = 52;
        System.out.println("Счётчик: " + counter);

        // Путь до файла
        String filePath = "C:\\StartJava\\Lesson1\\MyFirstApp.java";
        System.out.println("Путь до файла: " + filePath);

        // Количество чисел в каждой строке
        int numbersInRow = 6;
        System.out.println("Количество чисел в каждой строке: " + numbersInRow);

        // ЗАДАНИЕ 2
        System.out.println("\n2. Boolean-переменные.");

        // Сотни равны?
        boolean isEqualHundreds = false;
        System.out.println("Сотни равны? " + isEqualHundreds);

        // Компьютер включён?
        boolean isPcOn = true;
        System.out.println("Компьютер включён? " + isPcOn);

        // Есть равные цифры?
        boolean hasEqualDigits = false;
        System.out.println("Есть равные цифры? " + hasEqualDigits);

        // Создано?
        boolean isCreated = false;
        System.out.println("Создано? " + isCreated);

        // Пустое?
        boolean isEmpty = true;
        System.out.println("Пустое? " + isEmpty);

        // Активное?
        boolean isActive = true;
        System.out.println("Активное? " + isActive);

        // Новое?
        boolean isNew = false;
        System.out.println("Новое? " + isNew);

        // Электронная почта действительная?
        boolean isValidEmail = true;
        System.out.println("Электронная почта действительная? " + isValidEmail);

        // Имеются уникальные строки?
        boolean hasUniqueStrings = false;
        System.out.println("Имеются уникальные строки " + hasUniqueStrings);

        // ЗАДАНИЕ 3
        System.out.println("\n3. Аббревиатуры.");

        // Старый universally unique identifier
        String oldUuid = "f81d4fae-7dec-11d0-a765-00a0c91e6bf6";
        System.out.println("Старый universally unique identifier: " + oldUuid);

        // Производитель оперативной памяти
        String ramVendor = "Samsung";
        System.out.println("Производитель оперативной памяти: " + ramVendor);

        // Ёмкость жёсткого диска
        int hddCapacity = 1000000;
        System.out.println("Ёмкость жёсткого диска: " + hddCapacity + "Мб");

        // Протокол передачи гипертекста
        String http = "HTTP";
        System.out.println("Протокол передачи гипертекста: " + http);

        // Сокращенный uniform resource locator
        String shortUrl = "https://short.url/123";
        System.out.println("Сокращённый uniform resource locator: " + shortUrl);

        // Новый идентификатор клиента
        String newClientId = "_ym_uid=14363376548734874281";
        System.out.println("Идентификатор клиента: " + newClientId);

        // American standard code for information interchange
        String ascii = "ASCII";
        System.out.println("Кодировка: " + ascii);
    }
}