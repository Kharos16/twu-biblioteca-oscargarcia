package com.twu.biblioteca;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MESSAGE);
        Scanner inputFromUser = new Scanner(System.in);
        BookDataBase dataBase = new BookDataBase();
        User user = new User("Current_User", "");
        Poller poller = new Poller(inputFromUser, dataBase, user);
        poller.activePoll();
    }
}
