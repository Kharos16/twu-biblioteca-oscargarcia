package com.twu.biblioteca.databases;


import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.enums.Directors;
import com.twu.biblioteca.enums.Genre;
import com.twu.biblioteca.utils.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieDataBase {
    private List<Movie> movieList;

    public MovieDataBase() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("The Matrix", Genre.SCIENCE_FICTION.getDisplayName(),
                Directors.THE_WACHOWSKIS.getDisplayName(), 10));
        movieList.add(new Movie("The Matrix Reloaded", Genre.SCIENCE_FICTION.getDisplayName(),
                Directors.THE_WACHOWSKIS.getDisplayName(), 10));
    }


    public List<Movie> getMovieList() {
        return this.movieList;
    }

    public String movieCheckout(User user, int movieId) {
            int realId = movieId-1;
            StringBuilder checkoutResult = new StringBuilder();
            if (realId < 0){
                checkoutResult.append(Messages.MENU_INPUT_ERROR);
                return checkoutResult.toString();
            }else if (movieList.get(realId).isAvailable()) {
                movieList.get(realId).setAvailable(false);
                user.addMovie(movieList.get(realId));
                checkoutResult.append(Messages.SELECTED_MOVIE_MESSAGE + movieList.get(realId).shorterString() + "\n");
                checkoutResult.append(Messages.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
                return checkoutResult.toString();
            }
        checkoutResult.append(Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
        return checkoutResult.toString();
    }

    public String returnMovie(User user, int movieId) {
        int realId = movieId - 1;
        StringBuilder returnResult = new StringBuilder();
        if (realId < 0) {
            returnResult.append(Messages.MENU_INPUT_ERROR);
            return returnResult.toString();
        } else if (!movieList.get(realId).isAvailable()) {
            movieList.get(realId).setAvailable(true);
            user.removeMovie(movieList.get(realId));
            returnResult.append(Messages.MOVIE_TO_RETURN_MESSAGE + movieList.get(realId).shorterString() + "\n");
            returnResult.append(Messages.RETURN_MOVIE_MESSAGE_CORRECT);
            return returnResult.toString();
        }
        returnResult.append(Messages.RETURN_MOVIE_MESSAGE_INCORRECT);
        return returnResult.toString();
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        List<Movie>filteredlist =
                movieList.stream().filter(Movie::isAvailable)
                        .collect(Collectors.toList());
        filteredlist.forEach(movie -> list.append(movie.toString() + "\n"));
        return list.toString();
    }

    public String shorterString() {
        StringBuilder list = new StringBuilder();
        List<Movie>filteredlist =
                movieList.stream().filter(Movie::isAvailable)
                        .collect(Collectors.toList());
        filteredlist.forEach(movie -> list.append(movie.shorterString() + "\n"));
        return list.toString();
    }
}
