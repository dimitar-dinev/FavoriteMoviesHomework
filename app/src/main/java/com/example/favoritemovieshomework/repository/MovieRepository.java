package com.example.favoritemovieshomework.repository;

import com.example.favoritemovieshomework.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getAllMovies();

    void addMovie(Movie movie);

    void addMovies(List<Movie> movies);

    void deleteMovie(int index);

    void changeRating(int index, int newRating);
}
