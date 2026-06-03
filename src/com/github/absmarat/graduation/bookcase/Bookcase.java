package com.github.absmarat.graduation.bookcase;

import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    static final int MAX_BOOKS = 3;
    static final int MIN_BOOKCASE_WIDTH = 10;
    private int maxBookLength;
    private int bookCount;
    private int bookcaseWidth;
    private boolean isActualWidth;
    private Book[] books;

    public Bookcase() {
        maxBookLength = 0;
        bookCount = 0;
        bookcaseWidth = 0;
        isActualWidth = true;
        books = new Book[MAX_BOOKS];
    }

    public int getMaxBookLength() {
        return maxBookLength;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getBookcaseWidth() {
        return bookcaseWidth;
    }

    public void setBookcaseWidth(int bookcaseWidth) {
        this.bookcaseWidth = bookcaseWidth;
    }

    public boolean isActualWidth() {
        return isActualWidth;
    }

    public void setActualWidth(boolean actualWidth) {
        isActualWidth = actualWidth;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    boolean addBook(String title, String author, Year year) {
        if (bookCount >= MAX_BOOKS) {
            return false;
        }
        books[bookCount] = new Book(title, author, year);
        String addedBook = books[bookCount].toString();

        if (addedBook.length() > bookcaseWidth) {
            isActualWidth = false;
            maxBookLength = 0;
        }
        bookCount++;
        return true;
    }

    boolean findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                return true;
            }
        }
        return false;
    }

    boolean removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                String removedBook = books[i].toString();

                System.arraycopy(books, i + 1, books, i, bookCount - i - 1);

                books[--bookCount] = null;

                if (removedBook.length() == bookcaseWidth) {
                    isActualWidth = false;
                    maxBookLength = 0;
                }

                if (bookCount == 0) {
                    maxBookLength = 0;
                    return true;
                }

                return true;
            }
        }
        return false;
    }

    void clearBookcase() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        maxBookLength = 0;
    }
}
