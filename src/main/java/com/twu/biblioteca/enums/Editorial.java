package com.twu.biblioteca.enums;

public enum Editorial {
    POTTERMORE("Pottermore"),
    ALLEN_UNWIN("Allen & Unwin");


    private String displayName;

    Editorial(String displayName) {
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
