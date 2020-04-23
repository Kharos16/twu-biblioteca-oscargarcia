package com.twu.biblioteca.domain;

public class UserInfo {
    private String name;
    private String email;
    private String phoneNumber;

    public UserInfo() {
    }

    public UserInfo(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                ", Email: '" + email + '\'' +
                ", Phone Number'" + phoneNumber + '\'';
    }
}
