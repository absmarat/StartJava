package com.github.absmarat.graduation.bookcase;

import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    static final int MAX_BOOKS = 10;
    static final int MIN_LENGTH = 10;
    private int maxBookLength;
    private int bookCount;
    private int bookcaseWidth;
    private boolean isActualBookcaseWidth;
    private Book[] books;
    private StringBuilder bookCase;

    public Bookcase() {
        maxBookLength = 0;
        bookCount = 0;
        bookcaseWidth = 0;
        isActualBookcaseWidth = true;
        books = new Book[MAX_BOOKS];
        bookCase = new StringBuilder();
    }

    public int getBookCount() {
        return bookCount;
    }

    public StringBuilder getBookCase() {
        return bookCase;
    }

    boolean addBook(String title, String author, Year year) {
        if (bookCount >= MAX_BOOKS) {
            return false;
        }
        books[bookCount] = new Book(title, author, year);
        String addedBook = books[bookCount].toString();

        if (addedBook.length() > bookcaseWidth) {
            isActualBookcaseWidth = false;
            maxBookLength = 0;
        }

        bookCount++;
        createBookcase();
        return true;
    }

    private void createBookcase() {
        bookCase.setLength(0);
        calculateWidth();

        StringBuilder separator = new StringBuilder("-".repeat(bookcaseWidth));

        for (int i = 0; i < MAX_BOOKS; i++) {
            bookCase.append("|");
            if (books[i] != null) {
                String book = books[i].toString();
                bookCase.append(book);
                int spaces = bookcaseWidth - book.length();
                if (spaces > 0) {
                    bookCase.append(" ".repeat(spaces));
                }
            } else {
                bookCase.append(" ".repeat(bookcaseWidth));
            }
            bookCase.append("|\n");
            bookCase.append("|").append(separator).append("|\n");
        }
    }

    private void calculateWidth() {
        if (isActualBookcaseWidth) {
            return;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                String book = books[i].toString();
                if (book.length() > maxBookLength) {
                    maxBookLength = book.length();
                }
            }
        }
        bookcaseWidth = Math.max(maxBookLength, MIN_LENGTH);
        isActualBookcaseWidth = true;
    }

    boolean findBook(String title) {
        for (int i = 0; i <= bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                return true;
            }
        }
        return false;
    }

    boolean removeBook(String title) {
        int index = -1;
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        String removedBook = books[index].toString();

        System.arraycopy(books, index + 1, books, index, books.length - index - 1);

        if (removedBook.length() == bookcaseWidth) {
            isActualBookcaseWidth = false;
            maxBookLength = 0;
        }
        bookCount--;
        books[bookCount] = null;

        if (bookCount == 0) {
            maxBookLength = 0;
            bookCase.setLength(0);
            return true;
        }

        createBookcase();
        return true;
    }

    void clearBookcase() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        maxBookLength = 0;
        bookCase.setLength(0);
    }
}
