package com.twu.biblioteca;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class Poller {
    private boolean isRunning;
    private final Scanner inputFromUser;
    private final BookDataBase dataBase;
    private final User currentLoggedUser;

    public Poller(Scanner inputFromUser, BookDataBase dataBase, User currentLoggedUser){
        this.isRunning = true;
        this.inputFromUser = inputFromUser;
        this.dataBase = dataBase;
        this.currentLoggedUser = currentLoggedUser;
    }

    public void activePoll() {
        do {
            try {
                System.out.println(Messages.mainMenu());
                interpretate(Integer.parseInt(inputFromUser.next()), dataBase);
            } catch (ExitException e) {
                System.out.println(Messages.EXIT_APPLICATION);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
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
                System.out.println(Messages.BOOK_CHECKOUT_MESSAGE);
                System.out.println(Messages.BOOK_CHECKOUTLIST_MESSAGE);
                System.out.println(dataBase.shorterString());
                System.out.println(dataBase.bookCheckout(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
                break;
            case 3:
                System.out.println(Messages.BOOK_RETURN_MESSAGE);
                System.out.println(Messages.USER_BOOK_RETURN_MESSAGE);
                System.out.println(currentLoggedUser.getUsedBooks());
                System.out.println(dataBase.returnBook(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
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
