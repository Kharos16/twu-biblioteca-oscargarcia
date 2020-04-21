package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MESSAGE);
        Scanner inputFromUser = new Scanner(System.in);
        BookDataBase dataBase = new BookDataBase();
        System.out.println(Messages.MAIN_MENU());
        boolean isRunning = true;
            do {
                try {
                    /*switch (inputFromUser) {

                    }*/
                    if (inputFromUser.nextInt() == 0) {
                        isRunning = false;
                    }
                } catch (Exception e){
                    System.out.println(e.toString());
                    System.out.println(Messages.MENU_INPUT_ERROR);
                    inputFromUser.next();
                    continue;
                }
            } while (isRunning);
    }
}
