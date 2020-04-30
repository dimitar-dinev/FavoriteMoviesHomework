package com.example.favoritemovieshomework.repos;

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
        return database.getAllMovies();
    }

    @Override
    public boolean addMovie(Movie movie) {
        try {
            database.getAllMovies().add(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addMovies(List<Movie> movies) {
        try {
            database.getAllMovies().addAll(movies);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteMovie(int index) {
        try {
            database.getAllMovies().remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean changeRating(int index, int newRating) {
        try {
            database.getAllMovies().get(index).setRating(newRating);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
