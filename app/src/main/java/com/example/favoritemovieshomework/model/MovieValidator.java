package com.example.favoritemovieshomework.model;

public class MovieValidator {

    public static final int TITLE_ERROR = 1;
    public static final int DIRECTOR_ERROR = 2;
    public static final int GENRE_ERROR = 3;
    public static final int YEAR_ERROR = 4;

    private int error;

    public int getError() {
        return error;
    }

    public boolean validate(String title, String director, String genre, String year) {
        if (!validateTitle(title)) {
            error = TITLE_ERROR;
            return false;
        }

        if (!validateDirector(director)) {
            error = DIRECTOR_ERROR;
            return false;
        }

        if (!validateGenre(genre)) {
            error = GENRE_ERROR;
            return false;
        }

        if (!validateYear(year)) {
            error = YEAR_ERROR;
            return false;
        }

        return true;
    }


    public boolean validateTitle(String title) {
        return title != null && title.length() > 0;
    }

    public boolean validateDirector(String director) {
        return director != null && director.length() > 4;
    }

    public boolean validateGenre(String genre) {
        return genre != null && genre.length() > 2;
    }

    public boolean validateYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            return yearInt >= 1930 && yearInt <= 2020;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
