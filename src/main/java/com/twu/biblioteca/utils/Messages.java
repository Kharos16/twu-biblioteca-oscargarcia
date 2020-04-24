package com.twu.biblioteca.utils;

public class Messages {


    private Messages() {
        throw new IllegalStateException("Utility class");
    }
    public static final String HELLO_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles and movies in Bangalore!";
    public static final String mainMenu() {
        StringBuilder mainMenu = new StringBuilder();
        mainMenu.append("\n1. List all Books \n");
        mainMenu.append("2. Checkout a Book \n");
        mainMenu.append("3. Return a Book \n");
        mainMenu.append("4. List all Movies\n");
        mainMenu.append("5. Checkout a Movie\n");
        mainMenu.append("6. Return a Movie\n");
        mainMenu.append("7. See User Information\n");
        mainMenu.append("8. Quit the application");
        return mainMenu.toString();
    }

    public static final String CREDENTIALS_INVALID = "The credentials you used do not match a record from the database!";
    public static final String USERNAME = "Input your Username: ";
    public static final String PASSWORD = "Input your Password: ";
    public static final String USER_MUST_LOGIN = "You must login to use the Biblioteca!";
    public static final String PLEASE_LOGIN = "Please Login!";
    public static final String CURRENT_USER_INFO = "The current user's information is:";
    public static final String SELECTED_BOOK_MESSAGE = "The selected book is: ";
    public static final String BOOK_TO_RETURN_MESSAGE = "The book to return is: ";
    public static final String BOOK_CHECKOUT_MESSAGE = "To checkout a book please input the id of the book you want to use";
    public static final String BOOK_CHECKOUTLIST_MESSAGE = "This is a short list of the available books";
    public static final String SUCCESSFUL_BOOK_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE = "Sorry that book is not available!";
    public static final String BOOK_RETURN_MESSAGE = "To return a book please input the id of the book you want to return";
    public static final String USER_BOOK_RETURN_MESSAGE = "This is a short list of the books for the current user: ";
    public static final String RETURN_BOOK_MESSAGE_CORRECT = "Thank you for returning the book!";
    public static final String RETURN_BOOK_MESSAGE_INCORRECT = "That is not a valid book to return.";
    public static final String SELECTED_MOVIE_MESSAGE = "The selected movie is: ";
    public static final String MOVIE_TO_RETURN_MESSAGE = "The movie to return is: ";
    public static final String MOVIE_CHECKOUT_MESSAGE = "To checkout a movie please input the id of the movie you want to rent";
    public static final String MOVIE_CHECKOUTLIST_MESSAGE = "This is a short list of the available Movies";
    public static final String SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE = "Thank you! Enjoy the Movie";
    public static final String UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE = "Sorry that movie is not available!";
    public static final String MOVIE_RETURN_MESSAGE = "To return a movie please input the id of the movie you want to return";
    public static final String USER_MOVIE_RETURN_MESSAGE = "This is a short list of the movies for the current user: ";
    public static final String RETURN_MOVIE_MESSAGE_CORRECT = "Thank you for returning the movie!";
    public static final String RETURN_MOVIE_MESSAGE_INCORRECT = "That is not a valid movie to return.";
    public static final String MENU_INPUT_ERROR = "Please select a valid option!";
    public static final String EXIT_APPLICATION = "Exiting application!";
}
