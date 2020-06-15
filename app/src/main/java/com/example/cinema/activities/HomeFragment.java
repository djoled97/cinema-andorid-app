package com.example.cinema.activities;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.API.RetrofitApiMovie;
import com.example.cinema.R;
import com.example.cinema.models.MovieResults;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private final String API_KEY = "1a5c0986a122b075e3d752960ecb464f";
    private final String LANGUAGE = "en-Us";
    private final int PAGE = 1;
    LinearLayout linearLay;
    LinearLayout horizontalLay;
    PopupWindow popup;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.home_fragment, container, false);
        linearLay = (LinearLayout) v.findViewById(R.id.linearLay);
        horizontalLay = (LinearLayout) v.findViewById(R.id.horizontalMovieDetails);
        getData();

        return v;
    }

    private void getData() {
//        Intent intent = new Intent(getActivity(), DetailsActivity.class);

        Call<MovieResults> movies = RetrofitApiMovie.getInstance().getApi().listOfMovies(API_KEY, LANGUAGE, PAGE);


        movies.enqueue(new Callback<MovieResults>() {

            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {

                String link = "";
                String data = "";
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();
                MovieResults.ResultsBean onemovie = listOfMovies.get(0);


//                data += onemovie.getTitle() + " " + onemovie.getPopularity() + "\n";
//                link="https://image.tmdb.org/t/p/w300/" + onemovie.getPoster_path();


                for (MovieResults.ResultsBean movie : listOfMovies) {
                    TextView title = new TextView(getContext());
                    title.setId(movie.getId());
                    linearLay.addView(title);
                    title.setGravity(Gravity.CENTER);
                    data ="\n" +  movie.getTitle() + "\n";
                    title.setText(data);



                    ImageView post = new ImageView(getContext());

                    post.setId(movie.getId());
                    linearLay.addView(post);


                    link = "https://image.tmdb.org/t/p/w400/" + movie.getPoster_path();
                    Picasso.get().load(link).into(post);
//                    data += movie.getTitle() + " " + movie.getPopularity() + "\n";
//                    link="https://image.tmdb.org/t/p/w300/" + movie.getPoster_path();


                    post.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DetailsFragment frag=new DetailsFragment();
                            Bundle bundle=new Bundle();
                            bundle.putInt("id",movie.getId());
                            frag.setArguments(bundle);
//                            intent.putExtra("id",movie.getId());
//                            startActivity(intent);

                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragmentContainerMovie, frag, "DetailsFragment")
                                    .addToBackStack(null)
                                    .commit();
                        }
                    });
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
