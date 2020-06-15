package com.example.cinema.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.API.RetrofitApiMovie;
import com.example.cinema.R;
import com.example.cinema.db.Database;
import com.example.cinema.models.MovieCredits;
import com.example.cinema.models.MovieDetails;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsFragment extends Fragment implements View.OnClickListener {
        private int movieId;
    private final String API_KEY = "1a5c0986a122b075e3d752960ecb464f";
    private Database myDB;
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
    Bundle bundle;
    String link2;
    String username;
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        movieId=getArguments().getInt("id");
        View v= inflater.inflate(R.layout.fragment_details, container, false);

        init(v);
        firstProjectionFiled.setOnClickListener(this);
        secondProjectionFiled.setOnClickListener(this);
        thirdProjectionField.setOnClickListener(this);
        fourthProjectionField.setOnClickListener(this);
        listDetails();


    return  v;
    }



    private void init(View v) {


        titleFiled = v.findViewById(R.id.movieTittleDetials);
        releaseDateFiled =v.findViewById(R.id.releaseDateDetails);
        runtimeFiled = v.findViewById(R.id.runtimeDetails);
        genreFiled = v.findViewById(R.id.genreDetails);
        overviewField = v.findViewById(R.id.overviewDetails);
        castField = v.findViewById(R.id.castDetails);
        ratingField = v.findViewById(R.id.ratingDetails);
        poster = v.findViewById(R.id.posterDetails);

        firstProjectionFiled = v.findViewById(R.id.firstProjection);
        secondProjectionFiled = v.findViewById(R.id.secondProjection);
        thirdProjectionField = v.findViewById(R.id.thirdProjection);
        fourthProjectionField = v.findViewById(R.id.fourthProjection);

        firstPriceField = v.findViewById(R.id.firstPrice);
        secondPriceField = v.findViewById(R.id.seconPrice);
        thirdPriceField = v.findViewById(R.id.thirdPrice);
        fourthPriceField = v.findViewById(R.id.fourthPrice);

        sharedPreferences = getContext().getSharedPreferences("LoginPrefs", 0);
       username=  sharedPreferences.getString("username", "");

    }

    private void listDetails() {
        Call<MovieDetails> call = RetrofitApiMovie.getInstance().getApi().detailsMovie(movieId, API_KEY);
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
                     link2 = "https://image.tmdb.org/t/p/w400/" + details.getPoster_path();
                    Picasso.get().load(link).into(poster);
                     bundle = new Bundle();
                    bundle.putString("title",titleFiled.getText().toString());
                    bundle.putString("poster",link2);
                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
// method for listing out cast
//    private void listCast() {
//        Call<MovieCredits> call = RetrofitApiMovie.getInstance().getApi().creditsMovie(movieId, API_KEY);
//        call.enqueue(new Callback<MovieCredits>() {
//            @Override
//            public void onResponse(Call<MovieCredits> call, Response<MovieCredits> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<MovieCredits> call, Throwable t) {
//
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        myDB=new Database(getContext());
        switch (v.getId()) {

            case R.id.firstProjection:




                myDB.addCart(username,titleFiled.getText().toString(),Integer.parseInt(firstPriceField.getText().toString()),1,firstProjectionFiled.getText().toString(),link2);


                CartFragment newFragment = new CartFragment ();
                newFragment.setArguments(bundle);
                firstProjectionFiled.setTextColor(Color.BLUE);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerMovie, newFragment)
                        .addToBackStack(null)
                        .commit();

                break;

            case R.id.secondProjection:
                myDB.addCart(username,titleFiled.getText().toString(),Integer.parseInt(secondPriceField.getText().toString()),1,secondProjectionFiled.getText().toString(),link2);


                secondProjectionFiled.setTextColor(Color.BLUE);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerMovie, new CartFragment())
                        .addToBackStack(null)
                        .commit();

                break;

            case R.id.thirdProjection:
                myDB.addCart(username,titleFiled.getText().toString(),Integer.parseInt(thirdPriceField.getText().toString()),1,thirdProjectionField.getText().toString(),link2);


                thirdProjectionField.setTextColor(Color.BLUE);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerMovie, new CartFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.fourthProjection:
                myDB.addCart(username,titleFiled.getText().toString(),Integer.parseInt(fourthPriceField.getText().toString()),1,fourthProjectionField.getText().toString(),link2);


                fourthProjectionField.setTextColor(Color.BLUE);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerMovie, new CartFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }

    }
}
