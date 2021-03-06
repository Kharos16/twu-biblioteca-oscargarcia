package com.twu.biblioteca.domain;


public class Book {
    private static int count;
    private int id;
    private String title;
    private String genre;
    private String author;
    private String editorial;
    private int yearOfPublication;
    private boolean isAvailable;

    public Book() {}

    public Book(String title, String genre, String editorial, int yearOfPublication, String author) {
        this.id = ++count;
        this.title = title;
        this.genre = genre;
        this.editorial = editorial;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.isAvailable = true;
    }

    public Book(String title,  int yearOfPublication, String author) {
        this.id = ++count;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
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
                ", Author: '" + author + '\'' +
                ", Editorial: '" + editorial + '\'' +
                ", Year Of Publication: " + yearOfPublication + '\'' +
                ", isAvailable: " + isAvailable;
    }

    public String shorterString() {
        StringBuilder str = new StringBuilder();
        str.append("Id: " + id);
        str.append(" Title: " + title);
        return str.toString();
    }
}
