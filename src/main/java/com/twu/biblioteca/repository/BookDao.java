package com.twu.biblioteca.repository;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.domain.Book;

import java.util.List;

public class BookDao implements Dao<Book> {
    private BookDataBase dataBase;

    public BookDao(BookDataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public List<Book> getAll() {
        return dataBase.getBookList();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }
}
