package com.twu.biblioteca;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.databases.MovieDataBase;
import com.twu.biblioteca.databases.UserDataBase;
import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MESSAGE);
        Scanner inputFromUser = new Scanner(System.in);
        BookDataBase bookDataBase = new BookDataBase();
        MovieDataBase movieDataBase = new MovieDataBase();
        UserDataBase userDataBase = new UserDataBase();
        Poller poller = new Poller(inputFromUser, bookDataBase, movieDataBase, userDataBase);
        poller.activePoll();
    }
}
