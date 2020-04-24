package com.twu.biblioteca.databases;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.enums.Authors;
import com.twu.biblioteca.enums.Editorial;
import com.twu.biblioteca.enums.Genre;
import com.twu.biblioteca.utils.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDataBase {
    private List<Book> bookList;

    public BookDataBase() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and the Sorcerer's Stone", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),1997, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Chamber of Secrets", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),1998, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Prisoner of Azkaban", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),1999, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Goblet of Fire", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),2000, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Order of the Phoenix", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),2003, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Half-Blood Prince", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),2005, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("Harry Potter and the Deathly Hallows", genreNator(new String [] {Genre.FANTASY.getDisplayName(),Genre.DRAMA.getDisplayName()}),
                Editorial.POTTERMORE.getDisplayName(),2007, Authors.JKROWLING.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Fellowship of The Ring", genreNator(new String[]{Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()}),
                Editorial.ALLEN_UNWIN.getDisplayName(),1954, Authors.JRRTOLKIEN.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Two Towers", genreNator(new String[]{Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()}),
                Editorial.ALLEN_UNWIN.getDisplayName(),1954,Authors.JRRTOLKIEN.getDisplayName()));
        bookList.add(new Book("The Lord of The Rings: The Return of The King", genreNator(new String[]{Genre.FANTASY.getDisplayName(),Genre.ADVENTURE.getDisplayName()}),
                Editorial.ALLEN_UNWIN.getDisplayName(),1955,Authors.JRRTOLKIEN.getDisplayName()));
    }

    private String genreNator(String[] genreArray) {
        StringBuilder str = new StringBuilder();
        for (String input : genreArray) {
            str.append(input + " ");
        }
        return str.toString();
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    public String bookCheckout(User user, int bookId) {
            int realId = bookId-1;
            StringBuilder checkoutResult = new StringBuilder();
        if (realId < 0) {
            checkoutResult.append(Messages.MENU_INPUT_ERROR);
            return checkoutResult.toString();
        } else if (realId < bookList.size() && bookList.get(realId).isAvailable()) {
            bookList.get(realId).setAvailable(false);
            user.addBooks(bookList.get(realId));
            checkoutResult.append(Messages.SELECTED_BOOK_MESSAGE + bookList.get(realId).shorterString() + "\n");
            checkoutResult.append(Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
            return checkoutResult.toString();
        }
            checkoutResult.append(Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
            return checkoutResult.toString();
        }

    public String returnBook(User user, int bookId) {
        final int realId = bookId - 1;
        StringBuilder returnResult = new StringBuilder();
        if (realId < 0) {
            returnResult.append(Messages.MENU_INPUT_ERROR);
            return returnResult.toString();
        } else if (doIHaveIt(user, realId) && !bookList.get(realId).isAvailable()) {
            bookList.get(realId).setAvailable(true);
            user.removeBooks(bookList.get(realId));
            returnResult.append(Messages.BOOK_TO_RETURN_MESSAGE).append(bookList.get(realId).shorterString()).append("\n");
            returnResult.append(Messages.RETURN_BOOK_MESSAGE_CORRECT);
            return returnResult.toString();
        }
        returnResult.append(Messages.RETURN_BOOK_MESSAGE_INCORRECT);
        return returnResult.toString();
    }


    private boolean doIHaveIt(User user, int fromDataBase) {
        return user.getBookList().stream().anyMatch(book -> book.getId() == bookList.get(fromDataBase).getId());
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        List<Book> filteredlist =
                bookList.stream().filter(Book::isAvailable)
                        .collect(Collectors.toList());
        filteredlist.forEach(book -> list.append(book.toString() + "\n"));
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