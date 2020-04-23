package com.twu.biblioteca.domain;

import com.twu.biblioteca.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Book> usedBooks;
    private String username;
    private String password;

    public User() {

    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.usedBooks = new ArrayList<>();
    }

    public List<Book> getUsedBooks() {
        return usedBooks;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addBooks(Book usedBook) {
        this.usedBooks.add(usedBook);
    }
    public void removeBooks(Book returningBook) {
        for (Book usedBook : usedBooks) {
            if (usedBook.getId() == returningBook.getId()){
                usedBooks.remove(returningBook.getId());
            }
        }
    }
}
