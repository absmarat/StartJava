package com.github.absmarat.graduation.bookcase;

import static com.github.absmarat.graduation.bookcase.Book.MIN_YEAR;
import static com.github.absmarat.graduation.bookcase.Bookcase.MAX_BOOKS;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
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
        int delay = 10;
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
        String msg = "";

        switch (item) {
            case 1:
                msg = addBookToBookcase(scanner, bookcase);
                break;
            case 2:
                msg = findBookToBookcase(scanner, bookcase);
                break;
            case 3:
                msg = removeBookToBookcase(scanner, bookcase);
                break;
            case 4:
                msg = clearBookcase(bookcase);
                break;
            case 5:
                System.out.println("Работа завершена!");
                return true;
            default:
        }
        System.out.println(msg);
        return false;
    }

    private static String addBookToBookcase(Scanner scanner, Bookcase bookcase) {
        String title = inputTitle(scanner);
        String author = inputAuthorName(scanner);
        Year year = inputYear(scanner);
        boolean isDone = bookcase.addBook(title, author, year);
        return isDone ? "Книга успешно добавлена!" : "Не удалось добавить книгу. Шкаф заполнен.";
    }

    private static String findBookToBookcase(Scanner scanner, Bookcase bookcase) {
        String title = inputTitle(scanner);
        boolean isDone = bookcase.findBook(title);
        return isDone ? "Книга найдена!" : "Книга не найдена!";
    }

    private static String removeBookToBookcase(Scanner scanner, Bookcase bookcase) {
        String title = inputTitle(scanner);
        boolean isDone = bookcase.removeBook(title);
        return isDone ? "Книга удалена!" : "Книги с таким названием нет в наличии!";
    }

    private static String clearBookcase(Bookcase bookcase) {
        bookcase.clearBookcase();
        return "Шкаф очищен!";
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
            if (!title.isBlank()) {
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
            if (!author.isBlank()) {
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
                "   Количество пустых полок: " + (MAX_BOOKS - currBookCount));
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
        calculateBookcaseWidth(bookcase);
        StringBuilder separator = new StringBuilder("-".repeat(bookcase.getBookcaseWidth()));

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
            int spaces = bookcase.getBookcaseWidth() - book.length();

            if (spaces > 0) {
                bookshelves.append(" ".repeat(spaces));
            }
            bookshelves.append("|\n");
            bookshelves.append("|").append(separator).append("|\n");
        }

        int emptyBookshelves = MAX_BOOKS - bookCount;
        for (int i = 0; i < emptyBookshelves; i++) {
            bookshelves.append("|").append(" ".repeat(bookcase.getBookcaseWidth())).append("|\n");
            bookshelves.append("|").append(separator).append("|\n");
        }
        displayBookcase(bookshelves);
    }

    private static void calculateBookcaseWidth(Bookcase bookcase) {
        if (bookcase.isActualWidth()) {
            return;
        }

        Book[] books = bookcase.getBooks();
        int maxBookLength = bookcase.getMaxBookLength();

        for (Book book : books) {
            int bookLength = book.toString().length();
            if (bookLength > maxBookLength) {
                maxBookLength = bookLength;
            }
        }
        bookcase.setBookcaseWidth(Math.max(maxBookLength, Bookcase.MIN_BOOKCASE_WIDTH));
        bookcase.setActualWidth(true);
    }

    private static void displayBookcase(StringBuilder bookshelvs) {
        System.out.print("\n" + bookshelvs);
    }
}
