package com.github.absmarat.graduation.bookcase;

import static com.github.absmarat.graduation.bookcase.Book.MIN_YEAR;
import static com.github.absmarat.graduation.bookcase.Bookcase.CAPACITY;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final String BOOK_TITLE_PROMT = "название книги";
    private static final String AUTHOR_NAME_PROMT = "имя автора книги";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bookcase bookcase = new Bookcase();

    public static void main(String[] args) throws InterruptedException {
        displayWelcomeMsg();
        displayEmptyBookcaseMsg();

        while (true) {
            MenuItem[] items = formMenu();
            displayMenu(items);
            if (makeChoice(items)) {
                return;
            }
            displayBookcaseStatus();
            pressEnterToContinue();
            createBookcase();
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

    private static MenuItem[] formMenu() {
        if (bookcase.getBookCount() == 0) {
            return new MenuItem[]{MenuItem.ADD, MenuItem.EXIT};
        }

        if (bookcase.getBookCount() >= CAPACITY) {
            return new MenuItem[]{MenuItem.FIND, MenuItem.REMOVE, MenuItem.CLEAR, MenuItem.EXIT};
        }
        return MenuItem.values();
    }

    private static void displayMenu(MenuItem[] items) {
        System.out.println("\n  == МЕНЮ ==");
        for (int i = 1; i <= items.length; i++) {
            System.out.println(i + ". " + items[i - 1].getLabel());
        }
    }

    private static boolean makeChoice(MenuItem[] items) {
        while (true) {
            MenuItem item = enterMenuItem(items);
            return switch (item) {
                case ADD -> {
                    addBook();
                    yield false;
                }
                case FIND -> {
                    findBook();
                    yield false;
                }
                case REMOVE -> {
                    removeBook();
                    yield false;
                }
                case CLEAR -> {
                    clearBookcase();
                    yield false;
                }
                case EXIT -> {
                    System.out.println("Работа программы завершена!");
                    yield true;
                }
            };
        }
    }

    private static MenuItem enterMenuItem(MenuItem[] items) {
        while (true) {
            System.out.print("\nВыберите пункт меню: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: необходим ввод целого числа.");
                scanner.nextLine();
                continue;
            }
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id < MenuItem.MIN_ID || id > items.length) {
                System.out.println("Ошибка: выбран несуществующий пункт меню." +
                            " Допустимые значения: " + MenuItem.MIN_ID + "-" + items.length + ".");
                continue;
            }
            return items[id - 1];
        }
    }

    private static void addBook() {
        String title = inputBookInfo(BOOK_TITLE_PROMT);
        String author = inputBookInfo(AUTHOR_NAME_PROMT);
        Year year = inputYear();
        Book book = new Book(title, author, year);
        boolean isSaved = bookcase.addBook(book);
        System.out.println((isSaved) ? "Книга успешно добавлена!" :
                "Не удалось добавить книгу. Шкаф заполнен.");
    }

    private static void findBook() {
        String title = inputBookInfo(BOOK_TITLE_PROMT);
        Book foundBook = bookcase.findBook(title);
        System.out.println((foundBook != null) ? "Искомая книга: " + foundBook : "Книга не найдена!");
    }

    private static void removeBook() {
        String title = inputBookInfo(BOOK_TITLE_PROMT);
        boolean isRemoved = bookcase.removeBook(title);
        System.out.println((isRemoved) ? "Книга удалена!" : "Книги с таким названием нет в наличии!");
    }

    private static void clearBookcase() {
        bookcase.clearBookcase();
    }

    private static String inputBookInfo(String prompt) {
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

    private static Year inputYear() {
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
                        currentYear + " г.");
                continue;
            }
            return Year.of(yearValue);
        }
    }

    private static void displayBookcaseStatus() {
        int currBookCount = bookcase.getBookCount();

        if (currBookCount == 0) {
            displayEmptyBookcaseMsg();
            return;
        }
        System.out.println("Количество книг в шкафу: " + currBookCount +
                "   Количество пустых полок: " + (CAPACITY - currBookCount));
    }

    private static void pressEnterToContinue() {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }

    private static void createBookcase() {
        int bookCount = bookcase.getBookCount();

        if (bookCount == 0) return;

        String filledShelves = createFilledShelves();
        String emptyShelves = createEmptyShelves();
        System.out.print("\n" + filledShelves + emptyShelves);
    }

    private static String createFilledShelves() {
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

    private static String createEmptyShelves() {
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
