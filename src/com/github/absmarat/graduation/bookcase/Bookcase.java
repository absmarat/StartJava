package com.github.absmarat.graduation.bookcase;

import java.util.Arrays;

public class Bookcase {
    static final int CAPACITY = 10;
    private int bookCount;
    private int width;
    private Book[] books;

    public Bookcase() {
        bookCount = 0;
        width = 0;
        books = new Book[CAPACITY];
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getWidth() {
        return width;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    boolean addBook(Book book) {
        if (bookCount >= CAPACITY) {
            return false;
        }
        books[bookCount] = book;
        int length = books[bookCount].toString().length();
        bookCount++;

        if (length > width) {
            calculateWidth();
        }
        return true;
    }

    Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return books[i];
            }
        }
        return null;
    }

    boolean removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                int length = books[i].toString().length();

                System.arraycopy(books, i + 1, books, i, bookCount - i - 1);

                books[--bookCount] = null;

                if (length == width) {
                    width = 0;
                    calculateWidth();
                }
                return true;
            }
        }
        return false;
    }

    void clearBookcase() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        width = 0;
    }

    private void calculateWidth() {
        for (int i = 0; i < bookCount; i++) {
            int length = books[i].toString().length();
            if (length > width) {
                width = length;
            }
        }
    }
}
