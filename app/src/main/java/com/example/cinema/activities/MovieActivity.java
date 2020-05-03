package com.example.cinema.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cinema.API.RetrofitApiMovie;
import com.example.cinema.R;
import com.example.cinema.models.MovieResults;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    private final String API_KEY = "1a5c0986a122b075e3d752960ecb464f";
    private final String LANGUAGE = "en-Us";
    private final int PAGE = 1;
    ProgressBar progressBar;
    TextView movieView;
    ImageView poster;
    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movieView = (TextView) findViewById(R.id.movies);
        poster=(ImageView) findViewById(R.id.imageView);
        linear=(LinearLayout) findViewById(R.id.linear);
        getData();

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    private void getData() {
        Call<MovieResults> movies = RetrofitApiMovie.getInstance().getApi().listOfMovies(API_KEY, LANGUAGE, PAGE);

        movies.enqueue(new Callback<MovieResults>() {

            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                String link="";
                String data = "";
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();
                MovieResults.ResultsBean onemovie=listOfMovies.get(0);



//                data += onemovie.getTitle() + " " + onemovie.getPopularity() + "\n";
//                link="https://image.tmdb.org/t/p/w300/" + onemovie.getPoster_path();


                                for (MovieResults.ResultsBean movie : listOfMovies) {
                        TextView text=new TextView(MovieActivity.this);
                        text.setId(movie.getId());
                        linear.addView(text);
                        text.setGravity(Gravity.CENTER);
                        data = movie.getTitle() + " " + movie.getPopularity() + "\n";
                        text.setText(data);
                        ImageView post=new ImageView(MovieActivity.this);
                        post.setId(movie.getId() +1);

                        linear.addView(post);

                        link="https://image.tmdb.org/t/p/w400/" + movie.getPoster_path();
                        Picasso.get().load(link).into(post);
//                    data += movie.getTitle() + " " + movie.getPopularity() + "\n";
//                    link="https://image.tmdb.org/t/p/w300/" + movie.getPoster_path();

                }

//                movieView.setText(data);
//                Picasso.get().load(link).into(poster);
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
