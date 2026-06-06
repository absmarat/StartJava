package com.github.absmarat.graduation.bookcase;

import java.time.Year;

public class Book {
    static final int MIN_YEAR = 1800;
    private String title;
    private String author;
    private Year publicationYear;

    public Book(String title, String author, Year publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\"" + title + "\", " + author + ", " + publicationYear;
    }
}
