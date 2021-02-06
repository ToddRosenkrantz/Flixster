package com.example.flixster.adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.flixster.DetailActivity;
import com.example.flixster.MainActivity;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;

import java.util.List;
import java.util.Locale;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    final Context context;
    final List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the movie at the passed in position
        Movie movie = movies.get(position);
        // Set Transition name to unique movie title
        ViewCompat.setTransitionName(holder.ivPoster, movie.getTitle());
        // Bind the movie data into the ViewHolder (populate the row data into the display 'card')
        holder.bind(movie);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    // class *cannot* be static
    // implements View.onClickListener
     public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        RelativeLayout container;
        final TextView tvTitle;
        final TextView tvOverview;
        final TextView tvRating;
        final ImageView ivPoster;
        int movie_id;
//        itemView.setOnClickListener(this);

        @Override
        public void onClick(View v) {
        }


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvItemTitle);
            tvOverview = itemView.findViewById(R.id.tvItemOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);

            tvRating = itemView.findViewById(R.id.tvItemRating);
//            ivPrimaryImage = (ImageView) itemView.findViewById(R.id.ivPrimaryImage);
        }

        public void bind(Movie movie) {
            movie_id = movie.getMovie_id();
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            int radius = 20;
            int margin = 0;
            double vote_avg = movie.getRating()*10;
            String rating = String.format(Locale.US,"%.0f", vote_avg)+"%";
            tvRating.setText(rating);
            if (vote_avg >=87){
                tvRating.setTextColor(Color.parseColor("#FF0000"));
            }
            else if (vote_avg >= 75){
                tvRating.setTextColor(Color.parseColor("#FF8000"));
            }
            else if (vote_avg >= 63){
                tvRating.setTextColor(Color.parseColor("#FFFF00"));
            }
            else if (vote_avg >= 50){
                tvRating.setTextColor(Color.parseColor("#80FF00"));
            }
            else if (vote_avg >= 37){
                tvRating.setTextColor(Color.parseColor("#00FF00"));
            }
            else if (vote_avg >= 25){
                tvRating.setTextColor(Color.parseColor("#00FF80"));
            }
            else if (vote_avg >= 13){
                tvRating.setTextColor(Color.parseColor("#00FFFF"));
            }
            else {
                tvRating.setTextColor(Color.parseColor("#0080FF"));
            }
            //tvRating.setText("Rating: " + movie.getRating());
            ivPoster.setImageResource(R.drawable.film_clip);
            String imageUrl;
            // If phone is in Landscape mode
            // imageUrl = backdropPath
            // else use posterPath
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imageUrl = movie.getBackdropPath();
            }  else {
                imageUrl = movie.getPosterPath();
            }
            // Load image from image Url, if it takes too long, use the placeholder image
            Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.film_clip)
                    .transform(new RoundedCornersTransformation(radius,margin))
                    .into(ivPoster);
            container.setOnClickListener(v -> {
                // gets adapter position
                int position = getAdapterPosition();
                // validate position
                if (position != RecyclerView.NO_POSITION) {
                    // get the movie at the position, DOESN'T work if class is static
//                        Movie movie = movies.get(position);
                    // create intent for the new activity
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("movie", Parcels.wrap(movie));
                    // show the activity
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        ActivityOptionsCompat options = ActivityOptionsCompat.
//                                makeSceneTransitionAnimation(this, ivPoster, "poster");
//                        startActivity(intent, options.toBundle());
//                        context.startActivity(i,options.toBundle());
                        context.startActivity(i);
                    }
                    else {
//                        startActivity(intent);
                        context.startActivity(i);
                    }


//                        Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
