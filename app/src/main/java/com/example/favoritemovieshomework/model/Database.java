package com.example.favoritemovieshomework.model;

import java.util.List;

public class Database {

    private List<Movie> allMovies;

    public Database(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public boolean addMovie(Movie movie) {
        try {
            allMovies.add(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteMovie(int index) {
        try {
            allMovies.remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean changeRating(int index, int newRating) {
        try {
            allMovies.get(index).setRating(newRating);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
