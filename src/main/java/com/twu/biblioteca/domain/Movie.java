package com.twu.biblioteca.domain;

public class Movie {
    private static int count;
    private int id;
    private String title;
    private String genre;
    private String director;
    private int movieRating;
    private boolean isAvailable;

    public Movie() {}

    public Movie(String title, String genre, String director, int movieRating){
        this.id = ++count;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.movieRating = movieRating;
        this.isAvailable = true;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return  "Id: " + id +
                ", Title: '" + title + '\'' +
                ", Genre: '" + genre + '\'' +
                ", Director: '" + director + '\'' +
                ", Movie Rating " + movieRating + '\'' +
                ", isAvailable: " + isAvailable;
    }

    public String shorterString() {
        StringBuilder str = new StringBuilder();
        str.append("Id: " + id);
        str.append(" Title: " + title);
        return str.toString();
    }
}
