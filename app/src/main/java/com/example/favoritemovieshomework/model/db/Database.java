package com.example.favoritemovieshomework.model.db;

import com.example.favoritemovieshomework.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Movie> allMovies = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return allMovies;
    }

}
