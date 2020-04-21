package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MESSAGE);
        Scanner inputFromUser = new Scanner(System.in);
        BookDataBase dataBase = new BookDataBase();
        System.out.println(Messages.mainMenu());
        Poller poller = new Poller();
        poller.activePoll(inputFromUser,dataBase);
    }
}
