package com.twu.biblioteca;


import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class BlibliotecaAppTest {
    private static BookDataBase dataBase;


    @BeforeClass
    public static void setUp() {
        dataBase = new BookDataBase();
    }

    @Test
    public void thereShouldBeAHelloMessage() {
        assertTrue(Messages.HELLO_MESSAGE.length() > 0);
    }

    @Test
    public void helloMessageShouldBeAsRequested() {
        assertThat(Messages.HELLO_MESSAGE, is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")));
    }

    @Test
    public void listOfBooksShouldNotBeEmpty(){
        assertTrue(dataBase.getBookList().size() > 0);
    }

    @Test
    public void listOfBooksShouldBePrinted(){
        assertTrue(dataBase.toString().chars().count() > 10);
    }

    @Test
    public void listOfBooksSizeShouldBeN() {
        assertThat(dataBase.getBookList().size(), is(equalTo(10)));
    }

    @Test
    public void menuShouldHaveNOptions() {
        assertThat((int)Messages.MAIN_MENU().chars().filter(str -> str == '.').count(), is(equalTo(4)));
    }

    @Test
    public void ifInputIsNotANumberIShouldGetAMessage() {
        assertThat(Messages.MENU_INPUT_ERROR, is(equalTo("You must enter a valid number!")));
    }

    @Test
    public void ifIsRunningIsFalse() {
    }
}