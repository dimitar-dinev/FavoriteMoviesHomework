package com.example.favoritemovieshomework.repos;

import com.example.favoritemovieshomework.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getAllMovies();

    boolean addMovie(Movie movie);

    boolean addMovies(List<Movie> movies);

    boolean deleteMovie(int index);

    boolean changeRating(int index, int newRating);
}
