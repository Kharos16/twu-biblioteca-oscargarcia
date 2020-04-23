package com.twu.biblioteca;


import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.*;

import com.twu.biblioteca.databases.BookDataBase;
import com.twu.biblioteca.databases.MovieDataBase;
import com.twu.biblioteca.databases.UserDataBase;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.utils.Messages;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class BlibliotecaAppTest {
    private BookDataBase dataBase;
    private MovieDataBase movieDataBase;
    private UserDataBase userDataBase;
    private User testUser;
    private Poller poller;

    @Before
    public void setUp() {
        Scanner sc = new Scanner("");
        testUser = new User("Current_User", "1");
        dataBase = new BookDataBase();
        movieDataBase = new MovieDataBase();
        userDataBase = new UserDataBase();
        poller = new Poller(sc, dataBase, movieDataBase, userDataBase, testUser);
    }

    @Test
    public void thereShouldBeAHelloMessage() {
        assertTrue(Messages.HELLO_MESSAGE.length() > 0);
    }

    @Test
    public void helloMessageShouldBeAsRequested() {
        assertThat(Messages.HELLO_MESSAGE, is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles and movies in Bangalore!")));
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
        assertThat((int) Messages.mainMenu().chars().filter(str -> str == '.').count(), is(equalTo(8)));
    }

    @Test
    public void ifInputIsNotAValidNumberIShouldGetAMessage() {
        assertThat(Messages.MENU_INPUT_ERROR, is(equalTo("Please select a valid option!")));
    }

    @Test(expected = ExitException.class)
    public void ifMenuOption4IsSelectedThenApplicationExits() {
        poller.activePoll(7);
    }

    @Test
    public void ifISelectABookForCheckoutItShouldNotShowAnymore() {
        dataBase.bookCheckout(testUser, 9);
        assertThat(dataBase.shorterString().contains("id: 9"), is(not(true)));
    }

    @Test
    public void ifISelectABookForCheckoutItShouldNotBeAvailableAnymore() {
        int realId = 9-1;
        dataBase.bookCheckout(testUser, 9);
        assertThat(dataBase.getBookList().get(realId).isAvailable(), is(false));
        assertThat(dataBase.bookCheckout(testUser, 9), containsString(Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE));
    }

    @Test
    public void ifIInput0ToCheckoutAnIdIShouldGetAnInvalidOptionMessage() {
        assertThat(dataBase.bookCheckout(testUser, 0), containsString(Messages.MENU_INPUT_ERROR));
    }
}