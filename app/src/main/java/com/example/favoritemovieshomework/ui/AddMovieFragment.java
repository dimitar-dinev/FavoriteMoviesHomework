package com.example.favoritemovieshomework.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.favoritemovieshomework.R;
import com.example.favoritemovieshomework.model.Movie;
import com.example.favoritemovieshomework.model.MovieValidator;

public class AddMovieFragment extends DialogFragment {

    public interface AddMovieListener {
        void onMovieAdd(Movie movie);
    }

    private AddMovieFragment() {}

    public static AddMovieFragment newInstance() {
        return new AddMovieFragment();
    }

    private MovieValidator validator;

    public void setValidator(MovieValidator validator) {
        this.validator = validator;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnCancelListener(d -> dismiss());
            dialog.setCanceledOnTouchOutside(false);
        }

        EditText titleEditText = view.findViewById(R.id.titleEditText);
        EditText directorEditText = view.findViewById(R.id.directorEditText);
        EditText genreEditText = view.findViewById(R.id.genreEditText);
        EditText yearEditText = view.findViewById(R.id.yearEditText);

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(l -> dismiss());

        Button confirmButton = view.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(l -> {

            String title = titleEditText.getText().toString();
            String director = directorEditText.getText().toString();
            String genre = genreEditText.getText().toString();
            String year = yearEditText.getText().toString();

            if (validator.validate(title, director, genre, year)) {
                AddMovieListener listener = ((AddMovieListener) getActivity());
                if (listener != null) {
                    listener.onMovieAdd(new Movie(title, director, genre, Integer.parseInt(year)));
                    dismiss();
                }
            } else {
                displayError();
            }
        });
    }
    
    private void displayError() {
        switch (validator.getError()) {
            case MovieValidator.DIRECTOR_ERROR:
                Toast.makeText(getActivity(), R.string.director_error, Toast.LENGTH_SHORT).show(); break;
            case MovieValidator.TITLE_ERROR:
                Toast.makeText(getActivity(), R.string.title_error, Toast.LENGTH_SHORT).show(); break;
            case MovieValidator.GENRE_ERROR:
                Toast.makeText(getActivity(), R.string.genre_error, Toast.LENGTH_SHORT).show(); break;
            case MovieValidator.YEAR_ERROR:
                Toast.makeText(getActivity(), R.string.year_error, Toast.LENGTH_SHORT).show(); break;
        }
    }
}
