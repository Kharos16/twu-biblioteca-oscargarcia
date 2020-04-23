package com.twu.biblioteca;

import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class Poller {
    private boolean isRunning;
    private final Scanner inputFromUser;
    private final BookDataBase dataBase;

    public Poller(Scanner inputFromUser, BookDataBase dataBase){
        this.isRunning = true;
        this.inputFromUser = inputFromUser;
        this.dataBase = dataBase;
    }

    public void activePoll() {
        do {
            try {
                System.out.println(Messages.mainMenu());
                interpretate(Integer.parseInt(inputFromUser.next()), dataBase);
            } catch (ExitException e) {
                System.out.println(Messages.EXIT_APPLICATION);
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                System.out.println(Messages.MENU_INPUT_ERROR);
            }
        } while (isRunning);
    }

    public void activePoll(int option) {
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
                System.out.println(dataBase.bookCheckout(new User("Current_User", ""), Integer.valueOf(inputFromUser.next())));
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
