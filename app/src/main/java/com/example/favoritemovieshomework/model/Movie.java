package com.example.favoritemovieshomework.model;

public class Movie {

    private String title;
    private String director;
    private String genre;
    private int year;

    private int rating;

    public Movie(String title, String director, String genre, int year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
