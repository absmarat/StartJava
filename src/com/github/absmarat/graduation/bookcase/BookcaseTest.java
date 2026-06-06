package com.github.absmarat.graduation.bookcase;

import static com.github.absmarat.graduation.bookcase.Book.MIN_YEAR;
import static com.github.absmarat.graduation.bookcase.Bookcase.CAPACITY;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final int MIN_MENU_ITEM = 1;
    private static final int MAX_MENU_ITEM = 5;
    private static final String FIRST_PHRASE = "название книги";
    private static final String SECOND_PHRASE = "имя автора книги";

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
            displayBookcaseStatus(bookcase);
            pressEnterToContinue(scanner);
            createBookcase(bookcase);
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
                4.Очистить шкаф
                5.Завершить работу
                """;
        System.out.print(menu);
    }

    private static boolean makeChoice(Scanner scanner, Bookcase bookcase) {
        int item = enterMenuItem(scanner);

        switch (item) {
            case 1:
                addBook(scanner, bookcase);
                break;
            case 2:
                findBook(scanner, bookcase);
                break;
            case 3:
                removeBook(scanner, bookcase);
                break;
            case 4:
                clearBookcase(bookcase);
                break;
            case 5:
                System.out.println("Работа завершена!");
                return true;
            default:
        }
        return false;
    }

    private static void addBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, FIRST_PHRASE);
        String author = inputBookInfo(scanner, SECOND_PHRASE);
        Year year = inputYear(scanner);
        Book book = new Book(title, author, year);
        boolean isDone = bookcase.addBook(book);
        System.out.println((isDone) ? "Книга успешно добавлена!" :
                "Не удалось добавить книгу. Шкаф заполнен.");
    }

    private static void findBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, FIRST_PHRASE);
        Book book = bookcase.findBook(title);
        System.out.println((book != null) ? "Искомая книга: " + book : "Книга не найдена!");
    }

    private static void removeBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, FIRST_PHRASE);
        boolean isDone = bookcase.removeBook(title);
        System.out.println((isDone) ? "Книга удалена!" : "Книги с таким названием нет в наличии!");
    }

    private static void clearBookcase(Bookcase bookcase) {
        bookcase.clearBookcase();
    }

    private static int enterMenuItem(Scanner scanner) {
        while (true) {
            System.out.print("\nВыберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int item = scanner.nextInt();
                scanner.nextLine();
                if (item >= MIN_MENU_ITEM && item <= MAX_MENU_ITEM) {
                    return item;
                } else {
                    System.out.println("Ошибка: в меню пункт " + item + " не предусмотрен.");
                }
            } else {
                System.out.println("Ошибка: необходимо ввести целое число.");
                scanner.nextLine();
            }
        }
    }

    private static String inputBookInfo(Scanner scanner, String line) {
        String bookInfo;
        while (true) {
            System.out.print("Введите " + line + ": ");
            bookInfo = scanner.nextLine().trim();
            if (!bookInfo.isBlank()) {
                return bookInfo;
            }
            System.out.println("Ошибка: " + line + " не может быть пустым.");
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
                    System.out.println("Ошибка: введите год издания от " + MIN_YEAR + " г. до " +
                            currentYear + "г.");
                }
            } else {
                System.out.println("Ошибка: введите числовое значение года");
                scanner.nextLine();
            }
        }
    }

    private static void displayBookcaseStatus(Bookcase bookcase) {
        int currBookCount = bookcase.getBookCount();
        System.out.println("Количество книг в шкафу: " + currBookCount +
                "   Количество пустых полок: " + (CAPACITY - currBookCount));
        if (currBookCount == 0) {
            displayEmptyBookcaseMsg();
        }
    }

    private static void pressEnterToContinue(Scanner scanner) {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }

    private static void createBookcase(Bookcase bookcase) {
        StringBuilder bookshelves = new StringBuilder();
        StringBuilder separator = new StringBuilder("-".repeat(bookcase.getWidth()));
        Book[] books = bookcase.getBooks();
        int bookCount = bookcase.getBookCount();

        if (bookCount == 0) {
            bookshelves.setLength(0);
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            bookshelves.append("|");
            String book = books[i].toString();
            bookshelves.append(book);
            int spaces = bookcase.getWidth() - book.length();

            if (spaces > 0) {
                bookshelves.append(" ".repeat(spaces));
            }
            bookshelves.append("|\n");
            bookshelves.append("|").append(separator).append("|\n");
        }

        int emptyBookshelves = CAPACITY - bookCount;

        for (int i = 0; i < emptyBookshelves; i++) {
            bookshelves.append("|").append(" ".repeat(bookcase.getWidth())).append("|\n");
            bookshelves.append("|").append(separator).append("|\n");
        }
        System.out.print("\n" + bookshelves);
    }
}
