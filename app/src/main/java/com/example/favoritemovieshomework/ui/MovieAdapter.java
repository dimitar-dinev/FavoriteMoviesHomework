package com.example.favoritemovieshomework.ui;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.favoritemovieshomework.R;
import com.example.favoritemovieshomework.model.Movie;

import java.util.List;

import static com.example.favoritemovieshomework.ui.MainActivity.TAG;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public interface MovieRatingListener {
        void onRatingChanged(int position, int newRating);
    }

    private List<Movie> movies;
    private MovieRatingListener movieRatingListener;

    public MovieAdapter(List<Movie> movies, MovieRatingListener movieRatingListener) {
        this.movies = movies;
        this.movieRatingListener = movieRatingListener;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView directorTextView;
        TextView genreTextView;
        TextView yearTextView;

        ImageView oneStarImageView;
        ImageView twoStarImageView;
        ImageView threeStarImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            directorTextView = itemView.findViewById(R.id.directorTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);

            oneStarImageView = itemView.findViewById(R.id.onestar);
            twoStarImageView = itemView.findViewById(R.id.twostar);
            threeStarImageView = itemView.findViewById(R.id.threestar);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        final Movie movie = movies.get(position);

//        Log.d(TAG, "bindViewHolder, movie rating = " + movie.getRating());

        holder.titleTextView.setText(movie.getTitle());
        holder.directorTextView.setText(movie.getDirector());
        holder.genreTextView.setText(movie.getGenre());
        holder.yearTextView.setText(String.valueOf(movie.getYear()));


        holder.oneStarImageView.setOnClickListener(l -> {
            if (movie.getRating() != 1)
                MovieAdapter.this.movieRatingListener.onRatingChanged(position, 1);
        });

        holder.twoStarImageView.setOnClickListener(l -> {
            if (movie.getRating() != 2)
                MovieAdapter.this.movieRatingListener.onRatingChanged(position, 2);
        });

        holder.threeStarImageView.setOnClickListener(l -> {
            if (movie.getRating() != 3)
                MovieAdapter.this.movieRatingListener.onRatingChanged(position, 3);
        });

        switch (movie.getRating()) {
            case 1:
                    holder.oneStarImageView.setImageResource(R.drawable.ic_star_full);
                    holder.twoStarImageView.setImageResource(R.drawable.ic_star_empty);
                    holder.threeStarImageView.setImageResource(R.drawable.ic_star_empty);
                    break;
            case 2:
                    holder.oneStarImageView.setImageResource(R.drawable.ic_star_full);
                    holder.twoStarImageView.setImageResource(R.drawable.ic_star_full);
                    holder.threeStarImageView.setImageResource(R.drawable.ic_star_empty);
                    break;
            case 3:
                    holder.oneStarImageView.setImageResource(R.drawable.ic_star_full);
                    holder.twoStarImageView.setImageResource(R.drawable.ic_star_full);
                    holder.threeStarImageView.setImageResource(R.drawable.ic_star_full);
                    break;
            default:
                    holder.oneStarImageView.setImageResource(R.drawable.ic_star_empty);
                    holder.twoStarImageView.setImageResource(R.drawable.ic_star_empty);
                    holder.threeStarImageView.setImageResource(R.drawable.ic_star_empty);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
