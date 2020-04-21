package com.twu.biblioteca.enums;

public enum Authors {
    JKROWLING("J. K. Rowling"),
    JRRTOLKIEN("J. R. R Tolkien");


    private String displayName;

    Authors(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
