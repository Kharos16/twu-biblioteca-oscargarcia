package com.twu.biblioteca.enums;

public enum Directors {
    THE_WACHOWSKIS("The Wachowskis");

    private String displayName;

    Directors(String displayName) {
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
