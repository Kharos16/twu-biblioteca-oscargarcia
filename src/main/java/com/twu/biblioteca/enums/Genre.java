package com.twu.biblioteca.enums;

public enum Genre {
    FANTASY("Fantasy"),
    DRAMA("Drama"),
    ADVENTURE("Adventure"),
    SCIENCE_FICTION("Science Fiction");

    private String displayName;

    Genre(String displayName) {
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
