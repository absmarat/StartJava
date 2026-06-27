package com.github.absmarat.graduation.bookcase;

public enum MenuItem {
    ADD("Добавить книгу"),
    FIND("Найти книгу"),
    REMOVE("Удалить книгу"),
    CLEAR("Удалить все книги"),
    EXIT("Завершить работу программы");

    private final String label;
    static final int MIN_ID = 1;

    MenuItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
