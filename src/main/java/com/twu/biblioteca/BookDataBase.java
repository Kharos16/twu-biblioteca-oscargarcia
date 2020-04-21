package com.twu.biblioteca;

import com.twu.biblioteca.enums.Authors;
import com.twu.biblioteca.enums.Editorial;
import com.twu.biblioteca.enums.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDataBase {
    private List<Book> bookList;

    public BookDataBase() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and the Sorcerer's Stone", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),1997, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Chamber of Secrets", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),1998, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Prisoner of Azkaban", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),1999, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Goblet of Fire", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),2000, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Order of the Phoenix", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),2003, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Half-Blood Prince", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),2005, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Deathly Hallows", genreNator(Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()), Editorial.POTTERMORE.getDisplayName(),2007, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Fellowship of The Ring", genreNator(Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()), Editorial.ALLEN_UNWIN.getDisplayName(),1954, Authors.JRRTOLKIEN.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Two Towers", genreNator(Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()), Editorial.ALLEN_UNWIN.getDisplayName(),1954,Authors.JRRTOLKIEN.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Return of The King", genreNator(Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()), Editorial.ALLEN_UNWIN.getDisplayName(),1955,Authors.JRRTOLKIEN.getDisplayName()));
    }

    private String genreNator(String... strings) {
        StringBuilder str = new StringBuilder();
        for (String input : strings){
            str.append(input + " ");
        }
        return str.toString();
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Book book: bookList) {
            list.append(book + "\n");
        }
        return list.toString();
    }

    public String shorterString() {
        StringBuilder list = new StringBuilder();
        List<Book>filteredlist =
                bookList.stream().filter(Book::isAvailable)
                        .collect(Collectors.toList());
        filteredlist.forEach(book -> list.append(book.shorterString() + "\n"));
        return list.toString();
    }
}