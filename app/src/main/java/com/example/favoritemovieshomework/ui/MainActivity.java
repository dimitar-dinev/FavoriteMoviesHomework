package com.example.favoritemovieshomework.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.favoritemovieshomework.R;
import com.example.favoritemovieshomework.model.Database;
import com.example.favoritemovieshomework.model.Movie;
import com.example.favoritemovieshomework.model.MoviesGenerator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddMovieFragment.AddMovieListener, MovieAdapter.MovieRatingListener {

    public static final String TAG = "MAINACTIVITY";
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private MovieAdapter movieAdapter;

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(MoviesGenerator.generateMovies());

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(l -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            AddMovieFragment addMovieFragment = AddMovieFragment.newInstance();
            addMovieFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
            addMovieFragment.show(fragmentManager, "addMovieFragment");
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter(database.getAllMovies(), this);

        recyclerView.setAdapter(movieAdapter);

        addOnItemSwipeDelete(recyclerView);
    }

    private void addOnItemSwipeDelete(final RecyclerView recyclerView) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (database.deleteMovie(position)) {
                    movieAdapter.notifyDataSetChanged();
                }
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onMovieAdd(Movie movie) {
        if (database.addMovie(movie)) {
            movieAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRatingChanged(int position, int newRating) {
        if (database.changeRating(position, newRating)) {
            movieAdapter.notifyDataSetChanged();
        }
    }
}
