package com.example.favoritemovieshomework.repository;

import com.example.favoritemovieshomework.model.Movie;
import com.example.favoritemovieshomework.model.db.Database;

import java.util.List;

public class DBMovieRepository implements MovieRepository {

    private Database database;

    public DBMovieRepository(Database database) {
        this.database = database;
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.database.getAllMovies();
    }

    @Override
    public void addMovie(Movie movie) {
        this.database.getAllMovies().add(movie);
    }

    @Override
    public void addMovies(List<Movie> movies) {
        this.database.getAllMovies().addAll(movies);
    }

    @Override
    public void deleteMovie(int index) {
        this.database.getAllMovies().remove(index);
    }

    @Override
    public void changeRating(int index, int newRating) {
        this.database.getAllMovies().get(index).setRating(newRating);
    }
}
