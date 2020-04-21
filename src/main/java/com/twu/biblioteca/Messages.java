package com.twu.biblioteca;

public class Messages {
    public static final String HELLO_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String MAIN_MENU() {
        StringBuilder mainMenu = new StringBuilder();
        mainMenu.append("1. List all Books \n");
        mainMenu.append("2. Checkout a Book \n");
        mainMenu.append("3. Return a Book \n");
        mainMenu.append("4. Quit the application");
        return mainMenu.toString();
    }
    public static final String MENU_INPUT_ERROR = "You must enter a valid number!";
}
