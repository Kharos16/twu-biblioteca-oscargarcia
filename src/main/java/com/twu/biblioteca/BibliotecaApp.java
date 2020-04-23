package com.twu.biblioteca;

import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MESSAGE);
        Scanner inputFromUser = new Scanner(System.in);
        BookDataBase dataBase = new BookDataBase();
        Poller poller = new Poller(inputFromUser, dataBase);
        poller.activePoll();
    }
}
