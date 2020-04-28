package com.example.favoritemovieshomework.model;

import java.util.ArrayList;
import java.util.List;

public class MoviesGenerator {

    public static List<Movie> generateMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2013));
        list.add(new Movie("The Fellowship of The Ring", "Peter Jackson", "Fantasy", 2001));
        list.add(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010));
        return list;
    }
}
