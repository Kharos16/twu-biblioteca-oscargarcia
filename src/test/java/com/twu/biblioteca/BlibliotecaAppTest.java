package com.twu.biblioteca;


import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.*;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.utils.Messages;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class BlibliotecaAppTest {
    private BookDataBase dataBase;
    private Poller poller;

    @Before
    public void setUp() {
        Scanner sc = new Scanner("");
        User testUser = new User("Test", "");
        dataBase = new BookDataBase();
        poller = new Poller(sc,dataBase,testUser);
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
        assertFalse(dataBase.getBookList().isEmpty());
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
    public void listOfBooksShouldHaveAuthorAndYearOfPublication() {
        assertTrue(dataBase.getBookList().stream().allMatch(book -> book.toString().contains("Author") && book.toString().contains("Year Of Publication")));
    }

    @Test
    public void menuShouldHaveNOptions() {
        assertThat((int)Messages.mainMenu().chars().filter(str -> str == '.').count(), is(equalTo(4)));
    }

    @Test
    public void ifInputIsNotAValidNumberIShouldGetAMessage() {
        assertThat(Messages.MENU_INPUT_ERROR, is(equalTo("Please select a valid option!")));
    }

    @Test(expected = ExitException.class)
    public void ifMenuOption4IsSelectedThenApplicationExits() {
        poller.activePoll(4);
    }

    @Test
    public void ifISelectABookForCheckoutItShouldNotShowAnymore() {
        dataBase.bookCheckout(new User("test", "test"), 9);
        assertThat(dataBase.shorterString().contains("id: 9"), is(not(true)));
    }

    @Test
    public void ifISelectABookForCheckoutItShouldNotBeAvailableAnymore() {
        int realId = 9-1;
        dataBase.bookCheckout(new User("test", "test"), 9);
        assertThat(dataBase.getBookList().get(realId).isAvailable(), is(false));
        assertThat(dataBase.bookCheckout(new User("test", "test"), 9), containsString(Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE));
    }

    @Test
    public void ifIInput0ToCheckoutAnIdIShouldGetAnInvalidOptionMessage() {
        assertThat(dataBase.bookCheckout(new User("test", "test"), 0), containsString(Messages.MENU_INPUT_ERROR));
    }
}