package com.github.absmarat.graduation.bookcase;

import static com.github.absmarat.graduation.bookcase.Book.MIN_YEAR;
import static com.github.absmarat.graduation.bookcase.Bookcase.CAPACITY;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final int MIN_MENU_ITEM = 1;
    private static final int MAX_MENU_ITEM = 5;
    private static final String BOOK_TITLE_PROMT = "название книги";
    private static final String AUTHOR_NAME_PROMT = "имя автора книги";

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
        char[] charsMsg = "ДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!".toCharArray();

        for (char ch : charsMsg) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
    }

    private static void displayEmptyBookcaseMsg() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
    }

    private static void displayMenu() {
        System.out.print("""
                  
                  == MEНЮ ==
                1.Добавить книгу
                2.Найти книгу
                3.Удалить книгу
                4.Очистить шкаф
                5.Завершить работу программы
                """);
    }

    private static boolean makeChoice(Scanner scanner, Bookcase bookcase) {
        while (true) {
            try {
                int item = enterMenuItem(scanner);
                return switch (item) {
                    case 1 -> {
                        addBook(scanner, bookcase);
                        yield false;
                    }
                    case 2 -> {
                        findBook(scanner, bookcase);
                        yield false;
                    }
                    case 3 -> {
                        removeBook(scanner, bookcase);
                        yield false;
                    }
                    case 4 -> {
                        clearBookcase(bookcase);
                        yield false;
                    }
                    case 5 -> {
                        System.out.println("Работа программы завершена!");
                        yield true;
                    }
                    default -> throw new IllegalArgumentException("выбран несуществующий пункт меню." +
                            " Допустимые значения от " + MIN_MENU_ITEM + " до " + MAX_MENU_ITEM + ".");
                };
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static int enterMenuItem(Scanner scanner) {
        while (true) {
            System.out.print("\nВыберите пункт меню: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: необходим ввод целого числа.");
                scanner.nextLine();
                continue;
            }
            int item = scanner.nextInt();
            scanner.nextLine();
            return item;
        }
    }

    private static void addBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, BOOK_TITLE_PROMT);
        String author = inputBookInfo(scanner, AUTHOR_NAME_PROMT);
        Year year = inputYear(scanner);
        Book book = new Book(title, author, year);
        boolean isSaved = bookcase.addBook(book);
        System.out.println((isSaved) ? "Книга успешно добавлена!" :
                "Не удалось добавить книгу. Шкаф заполнен.");
    }

    private static void findBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, BOOK_TITLE_PROMT);
        Book foundBook = bookcase.findBook(title);
        System.out.println((foundBook != null) ? "Искомая книга: " + foundBook : "Книга не найдена!");
    }

    private static void removeBook(Scanner scanner, Bookcase bookcase) {
        String title = inputBookInfo(scanner, BOOK_TITLE_PROMT);
        boolean isRemoved = bookcase.removeBook(title);
        System.out.println((isRemoved) ? "Книга удалена!" : "Книги с таким названием нет в наличии!");
    }

    private static void clearBookcase(Bookcase bookcase) {
        bookcase.clearBookcase();
    }

    private static String inputBookInfo(Scanner scanner, String prompt) {
        String bookInfo;
        while (true) {
            System.out.print("Введите " + prompt + ": ");
            bookInfo = scanner.nextLine().trim();
            if (!bookInfo.isBlank()) {
                return bookInfo;
            }
            System.out.println("Ошибка: " + prompt + " не может быть пустым.");
        }
    }

    private static Year inputYear(Scanner scanner) {
        Year currentYear = Year.now();
        while (true) {
            System.out.print("Введите год издания книги: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите числовое значение года");
                scanner.nextLine();
                continue;
            }

            int yearValue = scanner.nextInt();
            scanner.nextLine();

            if (yearValue < MIN_YEAR || yearValue > currentYear.getValue()) {
                System.out.println("Ошибка: введите год издания от " + MIN_YEAR + " г. до " +
                        currentYear + "г.");
                continue;
            }
            return Year.of(yearValue);
        }
    }

    private static void displayBookcaseStatus(Bookcase bookcase) {
        int currBookCount = bookcase.getBookCount();

        if (currBookCount == 0) {
            displayEmptyBookcaseMsg();
            return;
        }
        System.out.println("Количество книг в шкафу: " + currBookCount +
                "   Количество пустых полок: " + (CAPACITY - currBookCount));
    }

    private static void pressEnterToContinue(Scanner scanner) {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }

    private static void createBookcase(Bookcase bookcase) {
        int bookCount = bookcase.getBookCount();

        if (bookCount == 0) return;

        String filledShelves = createFilledShelves(bookcase);
        String emptyShelves = createEmptyShelves(bookcase);
        System.out.print("\n" + filledShelves + emptyShelves);
    }

    private static String createFilledShelves(Bookcase bookcase) {
        int shelfWidth = bookcase.getWidth();
        StringBuilder filledShelves = new StringBuilder();
        Book[] books = bookcase.getBooks();

        for (Book bookInfo : books) {
            filledShelves.append("|")
                    .append(bookInfo)
                    .append(" ".repeat(shelfWidth - bookInfo.toString().length()))
                    .append("|\n")
                    .append("|")
                    .append("-".repeat(shelfWidth))
                    .append("|\n");
        }
        return filledShelves.toString();
    }

    private static String createEmptyShelves(Bookcase bookcase) {
        int bookCount = bookcase.getBookCount();
        int shelfWidth = bookcase.getWidth();
        StringBuilder shelf = new StringBuilder();
        shelf.append("|")
                .append(" ".repeat(shelfWidth))
                .append("|\n")
                .append("|")
                .append("-".repeat(shelfWidth))
                .append("|\n");
        String emptyShelf = shelf.toString();
        int emptyShelfCount = CAPACITY - bookCount;
        return emptyShelf.repeat(emptyShelfCount);
    }
}
