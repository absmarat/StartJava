package com.github.absmarat.graduation.bookcase;

import static com.github.absmarat.graduation.bookcase.Bookcase.MAX_BOOKS;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final int MIN_YEAR = 1800;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();

        displayWelcomeMsg();
        displayEmptyBookcaseMsg();

        while (true) {
            displayMenu();
            if (makeChoice(scanner, bookcase)) {
                return;
            }
            displayMessage(bookcase);
            pressEnter(scanner);
            displayBookcase(bookcase);
        }
    }

    private static void displayWelcomeMsg() throws InterruptedException {
        int delay = 100;
        String msg = "ДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!";
        char[] characters = msg.toCharArray();

        for (char ch : characters) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    private static void displayEmptyBookcaseMsg() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
    }

    private static void displayMenu() {
        String menu = """
                  
                  == MEНЮ ==
                1.Добавить книгу
                2.Найти книгу
                3.Удалить книгу
                4.Очистить полку
                5.Завершить работу
                """;
        System.out.print(menu);
    }

    private static boolean makeChoice(Scanner scanner, Bookcase bookcase) {
        int item = enterMenuItem(scanner);

        String title;
        String author;
        String msg = "";
        boolean isDone;

        switch (item) {
            case 1:
                title = inputTitle(scanner);
                author = inputAuthorName(scanner);
                Year year = inputYear(scanner);
                isDone = bookcase.addBook(title, author, year);
                msg = isDone ? "Книга успешно добавлена!" : "Не удалось добавить книгу. Полка заполнена.";
                break;
            case 2:
                title = inputTitle(scanner);
                isDone = bookcase.findBook(title);
                msg = isDone ? "Книга найдена!" : "Книга не найдена!";
                break;
            case 3:
                title = inputTitle(scanner);
                isDone = bookcase.removeBook(title);
                msg = isDone ? "Книга удалена!" : "Книги с таким названием нет в наличии!";
                break;
            case 4:
                bookcase.clearBookcase();
                msg = "Полка очищена!";
                break;
            case 5:
                System.out.println("Работа завершена!");
                return true;
            default:
        }
        System.out.println(msg);
        return false;
    }

    private static int enterMenuItem(Scanner scanner) {
        while (true) {
            System.out.print("\nВыберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int item = scanner.nextInt();
                scanner.nextLine();
                if (item >= 1 && item <= 5) {
                    return item;
                } else {
                    System.out.println("Ошибка! В меню пункт " + item + " не предусмотрен.");
                }
            } else {
                System.out.println("Ошибка! Необходимо ввести целое число.");
                scanner.nextLine();
            }
        }
    }

    private static String inputTitle(Scanner scanner) {
        String title;
        while (true) {
            System.out.print("Введите название книги: ");
            title = scanner.nextLine().trim();
            if (!title.isEmpty()) {
                return title;
            }
            System.out.println("Ошибка: название не может быть пустым.");
        }
    }

    private static String inputAuthorName(Scanner scanner) {
        String author;
        while (true) {
            System.out.print("Введите имя автора книги: ");
            author = scanner.nextLine().trim();
            if (!author.isEmpty()) {
                return author;
            }
            System.out.println("Ошибка: имя автора не может быть пустым.");
        }
    }

    private static Year inputYear(Scanner scanner) {
        Year currentYear = Year.now();

        while (true) {
            System.out.print("Введите год издания книги: ");

            if (scanner.hasNextInt()) {
                int yearValue = scanner.nextInt();
                scanner.nextLine();

                if (yearValue >= MIN_YEAR && yearValue <= currentYear.getValue()) {
                    return Year.of(yearValue);
                } else {
                    System.out.println("Ошибка: введите год издания от " + MIN_YEAR + " г. " +
                            "до " + currentYear + "г.");
                }
            } else {
                System.out.println("Ошибка: введите числовое значение года");
                scanner.nextLine();
            }
        }
    }

    private static void displayMessage(Bookcase bookcase) {
        int currBookCount = bookcase.getBookCount();
        System.out.println("Количество книг в шкафу: " + currBookCount +
                "   Количество пустых полок: " + (MAX_BOOKS - currBookCount));
        if (currBookCount == 0) {
            displayEmptyBookcaseMsg();
        }
    }

    private static void pressEnter(Scanner scanner) {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }

    private static void displayBookcase(Bookcase bookcase) {
        System.out.print("\n" + bookcase.getBookCase());
    }
}
