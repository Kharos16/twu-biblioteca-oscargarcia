package com.twu.biblioteca;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.databases.MovieDataBase;
import com.twu.biblioteca.databases.UserDataBase;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.utils.Messages;

import java.util.Scanner;

public class Poller {
    private boolean isRunning;
    private final Scanner inputFromUser;
    private final BookDataBase bookDataBase;
    private final MovieDataBase movieDataBase;
    private final UserDataBase userDataBase;
    private User currentLoggedUser;

    public Poller(Scanner inputFromUser, BookDataBase bookDataBase, MovieDataBase movieDataBase, UserDataBase userDataBase) {
        this.isRunning = true;
        this.inputFromUser = inputFromUser;
        this.bookDataBase = bookDataBase;
        this.movieDataBase = movieDataBase;
        this.userDataBase = userDataBase;
        this.currentLoggedUser = new User();
    }

    public void activePoll() {
        do {
            if (!currentLoggedUser.isLoggedIn()) {
                System.out.println(Messages.PLEASE_LOGIN);
                System.out.println(Messages.USERNAME);
                String usr = inputFromUser.next();
                System.out.println(Messages.PASSWORD);
                String pass = inputFromUser.next();
                setCurrentLoggedUser(new User(usr, pass));
            }
            if (validateLogin(currentLoggedUser)) {
                try {
                    System.out.println(Messages.mainMenu());
                    interpretate(Integer.parseInt(inputFromUser.next()), bookDataBase, movieDataBase);
                } catch (ExitException e) {
                    System.out.println(Messages.EXIT_APPLICATION);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println(e.toString());
                    System.out.println(Messages.MENU_INPUT_ERROR);
                }
            } else {
                System.out.println(Messages.CREDENTIALS_INVALID);
                System.out.println(Messages.USER_MUST_LOGIN);
            }
        } while (isRunning);
    }

    public void activePoll(int option) {
        do {
            try {
                System.out.println(Messages.mainMenu());
                interpretate(option, bookDataBase, movieDataBase);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(e.toString());
                System.out.println(Messages.MENU_INPUT_ERROR);
            }
        } while (isRunning);
    }

    private void interpretate(int input, BookDataBase bookDataBase, MovieDataBase movieDataBase) {
        switch (input) {
            case 1:
                System.out.println(bookDataBase.toString());
                break;
            case 2:
                System.out.println(Messages.BOOK_CHECKOUT_MESSAGE);
                System.out.println(Messages.BOOK_CHECKOUTLIST_MESSAGE);
                System.out.println(bookDataBase.shorterString());
                System.out.println(bookDataBase.bookCheckout(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
                break;
            case 3:
                System.out.println(Messages.BOOK_RETURN_MESSAGE);
                System.out.println(Messages.USER_BOOK_RETURN_MESSAGE);
                System.out.println(currentLoggedUser.getUsedBooks());
                System.out.println(bookDataBase.returnBook(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
                break;
            case 4:
                System.out.println(movieDataBase.toString());
                break;
            case 5:
                System.out.println(Messages.MOVIE_CHECKOUT_MESSAGE);
                System.out.println(Messages.MOVIE_CHECKOUTLIST_MESSAGE);
                System.out.println(movieDataBase.shorterString());
                System.out.println(movieDataBase.movieCheckout(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
                break;
            case 6:
                System.out.println(Messages.MOVIE_RETURN_MESSAGE);
                System.out.println(Messages.USER_MOVIE_RETURN_MESSAGE);
                System.out.println(currentLoggedUser.getUsedMovies());
                System.out.println(movieDataBase.returnMovie(currentLoggedUser, Integer.parseInt(inputFromUser.next())));
                break;
            case 7:
                System.out.println(Messages.CURRENT_USER_INFO);
                System.out.println(currentLoggedUser.getUserInfo());
                System.out.println(Messages.USER_BOOK_RETURN_MESSAGE);
                System.out.println(currentLoggedUser.getUsedBooks());
                System.out.println(Messages.USER_MOVIE_RETURN_MESSAGE);
                System.out.println(currentLoggedUser.getUsedMovies());
                break;
            case 8:
                isRunning = false;
                throw new ExitException(Messages.EXIT_APPLICATION);
            default:
                System.out.println(Messages.MENU_INPUT_ERROR);
                break;
        }
    }

    private boolean validateLogin(User user) {
        for (User userFromDb : userDataBase.getUserList()) {
            if (user.getUsername().equalsIgnoreCase(userFromDb.getUsername()) && user.getPassword().equalsIgnoreCase(userFromDb.getPassword())) {
                user.setLoggedIn(true);
                user.setUserInfo(userFromDb.getUserInfo());
                return user.isLoggedIn();
            }
        }
        user.setLoggedIn(false);
        return user.isLoggedIn();
    }

    private void setCurrentLoggedUser(User currentLoggedUser) {
        this.currentLoggedUser = currentLoggedUser;
    }
}
