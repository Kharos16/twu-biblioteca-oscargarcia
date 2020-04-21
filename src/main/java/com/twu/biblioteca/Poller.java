package com.twu.biblioteca;

import java.util.Scanner;

public class Poller {
    private boolean isRunning = true;

    public void activePoll(Scanner inputFromUser , BookDataBase dataBase) {
        do {
            try {
                interpretate(inputFromUser.nextInt(), dataBase);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } while (isRunning);
    }

    public void activePoll(int option , BookDataBase dataBase) {
        do {
            interpretate(option, dataBase);
        } while (isRunning);
    }

    private void interpretate(int input, BookDataBase dataBase) {
        switch (input){
            case 1:
                System.out.println(dataBase.toString());
                break;
            case 2:
                System.out.println(Messages.CHECKOUT_MESSAGE);
                System.out.println(Messages.CHECKOUTLIST_MESSAGE);
                System.out.println(dataBase.shorterString());
                break;
            case 3:
                System.out.println(Messages.RETURN_MESSAGE_CORRECT);
                break;
            case 4:
                isRunning = false;
                throw new ExitException(Messages.EXIT_APPLICATION);
            default:
                System.out.println(Messages.MENU_INPUT_ERROR);
                break;
        }
    }
}
