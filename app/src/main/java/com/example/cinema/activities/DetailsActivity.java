package com.example.cinema.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.API.RetrofitApi;
import com.example.cinema.API.RetrofitApiMovie;
import com.example.cinema.R;
import com.example.cinema.models.MovieCredits;
import com.example.cinema.models.MovieDetails;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private final String API_KEY = "1a5c0986a122b075e3d752960ecb464f";
    private int idMovie;
    TextView titleFiled;
    TextView releaseDateFiled;
    TextView runtimeFiled;
    TextView genreFiled;
    TextView overviewField;
    TextView castField;
    TextView ratingField;
    ImageView poster;
    TextView firstProjectionFiled;
    TextView secondProjectionFiled;
    TextView thirdProjectionField;
    TextView fourthProjectionField;
    TextView firstPriceField;
    TextView secondPriceField;
    TextView thirdPriceField;
    TextView fourthPriceField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        listDetails();
    }


    private void init() {

        idMovie = Objects.requireNonNull(getIntent().getExtras()).getInt("id");
        titleFiled = findViewById(R.id.movieTittleDetials);
        releaseDateFiled = findViewById(R.id.releaseDateDetails);
        runtimeFiled = findViewById(R.id.runtimeDetails);
        genreFiled = findViewById(R.id.genreDetails);
        overviewField = findViewById(R.id.overviewDetails);
        castField = findViewById(R.id.castDetails);
        ratingField = findViewById(R.id.ratingDetails);
        poster = findViewById(R.id.posterDetails);

        firstProjectionFiled = findViewById(R.id.firstProjection);
        secondProjectionFiled = findViewById(R.id.secondProjection);
        thirdProjectionField = findViewById(R.id.thirdProjection);
        fourthProjectionField = findViewById(R.id.fourthProjection);

        firstPriceField = findViewById(R.id.firstPrice);
        secondPriceField = findViewById(R.id.seconPrice);
        thirdPriceField = findViewById(R.id.thirdPrice);
        fourthPriceField = findViewById(R.id.fourthPrice);

        firstPriceField.setOnClickListener(this);
        secondPriceField.setOnClickListener(this);
        thirdPriceField.setOnClickListener(this);
        fourthPriceField.setOnClickListener(this);
    }

    private void listDetails() {
        Call<MovieDetails> call = RetrofitApiMovie.getInstance().getApi().detailsMovie(idMovie, API_KEY);
        call.enqueue(new Callback<MovieDetails>() {

            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                MovieDetails details = response.body();
                if (details != null) {
                    String title = details.getTitle();
                    String releaseDate = details.getRelease_date();
                    String runtime = Integer.toString(details.getRuntime()) + " min";
                    List<MovieDetails.GenresBean> genres = details.getGenres();

                    String result = "";
                    for (MovieDetails.GenresBean genre : genres) {
                        result += genre.getName() + " ";
                    }
                    String overview = details.getOverview();
                    String rating = Double.toString(details.getVote_average());
                    titleFiled.setText(title);
                    releaseDateFiled.setText(releaseDate);
                    runtimeFiled.setText(runtime);
                    releaseDateFiled.setText(releaseDate);
//                    genreFiled.setText(genre);
                    overviewField.setText(overview);
                    ratingField.setText(rating);
                    genreFiled.setText(result);
                    String link = "https://image.tmdb.org/t/p/w500/" + details.getBackdrop_path();
                    Picasso.get().load(link).into(poster);

                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void listCast() {
        Call<MovieCredits> call = RetrofitApiMovie.getInstance().getApi().creditsMovie(idMovie, API_KEY);
        call.enqueue(new Callback<MovieCredits>() {
            @Override
            public void onResponse(Call<MovieCredits> call, Response<MovieCredits> response) {

            }

            @Override
            public void onFailure(Call<MovieCredits> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MovieActivity.class);
        switch (v.getId()) {

            case R.id.firstProjection:
                intent.putExtra("time",firstProjectionFiled.getText());
                intent.putExtra("price",firstPriceField.getText());
                firstProjectionFiled.setTextColor(Color.BLUE);
                startActivity(intent);

                break;

            case R.id.secondProjection:
                intent.putExtra("time",secondProjectionFiled.getText());
                intent.putExtra("price",secondPriceField.getText());
                secondProjectionFiled.setTextColor(Color.BLUE);
                startActivity(intent);
                break;

            case R.id.thirdProjection:
                intent.putExtra("time",thirdProjectionField.getText());
                intent.putExtra("price",thirdPriceField.getText());
                thirdProjectionField.setTextColor(Color.BLUE);
                startActivity(intent);
                break;

            case R.id.fourthProjection:
                intent.putExtra("time",fourthProjectionField.getText());
                intent.putExtra("price",fourthPriceField.getText());
                fourthProjectionField.setTextColor(Color.BLUE);
                startActivity(intent);
                break;
        }

    }
}
