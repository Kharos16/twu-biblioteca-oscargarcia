package com.twu.biblioteca.utils;

public class Messages {
    private Messages() {
        throw new IllegalStateException("Utility class");
    }
    public static final String HELLO_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String mainMenu() {
        StringBuilder mainMenu = new StringBuilder();
        mainMenu.append("\n1. List all Books \n");
        mainMenu.append("2. Checkout a Book \n");
        mainMenu.append("3. Return a Book \n");
        mainMenu.append("4. Quit the application");
        return mainMenu.toString();
    }
    public static final String SELECTED_BOOK_MESSAGE = "The selected book is: ";
    public static final String BOOK_TO_RETURN_MESSAGE = "The book to return is: ";
    public static final String CHECKOUT_MESSAGE = "To checkout a book please input the id of the book you want to use";
    public static final String CHECKOUTLIST_MESSAGE = "This is a short list of the available books";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "Sorry that book is not available!";
    public static final String RETURN_MESSAGE = "";
    public static final String USER_RETURN_MESSAGE = "";
    public static final String RETURN_MESSAGE_CORRECT = "Thank you for returning the book!";
    public static final String RETURN_MESSAGE_INCORRECT = "That is not a valid book to return.";
    public static final String MENU_INPUT_ERROR = "Please select a valid option!";
    public static final String EXIT_APPLICATION = "Exiting application!";
}
