package com.twu.biblioteca.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Book> bookList;
    private List<Movie> movieList;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private UserInfo userInfo;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookList = new ArrayList<>();
        this.movieList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void addBooks(Book usedBook) {
        this.bookList.add(usedBook);
    }

    public void removeBooks(Book returningBook) {
        for (Book usedBook : bookList) {
            if (usedBook.getId() == returningBook.getId()) {
                bookList.remove(returningBook.getId());
            }
        }
    }

    public String getUsedBooks() {
        StringBuilder str = new StringBuilder();
        bookList.forEach(book -> {
            str.append("Id: " + book.getId());
            str.append(" Title: " + book.getTitle() + "\n");
        });
        return str.toString();
    }

    public void addMovie(Movie rentedMovie){
        this.movieList.add(rentedMovie);
    }

    public void removeMovie(Movie returningMovie) {
        for (Movie rentedMovie : movieList) {
            if (rentedMovie.getId() == returningMovie.getId()){
                movieList.remove(returningMovie.getId());
            }
        }
    }

    public String getUsedMovies() {
        StringBuilder str = new StringBuilder();
        movieList.forEach(movie -> {
            str.append("Id: " + movie.getId());
            str.append(" Title: " + movie.getTitle() + "\n");
        });
        return str.toString();
    }

    @Override
    public String toString() {
        return "Username:'" + username + '\'' +
                ", isLoggedIn:" + isLoggedIn;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
