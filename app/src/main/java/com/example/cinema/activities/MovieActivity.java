package com.example.cinema.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cinema.API.RetrofitApiMovie;
import com.example.cinema.R;
import com.example.cinema.db.Database;
import com.example.cinema.models.MovieResults;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    //    private final String API_KEY = "1a5c0986a122b075e3d752960ecb464f";
//    private final String LANGUAGE = "en-Us";
//    private final int PAGE = 1;

    LinearLayout linear;
    FrameLayout frameLayout;
    BottomNavigationView bottomnav;
    String name,lastname,email;
    Database myDB;
   static int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        init();

    }

    public void init() {
        frameLayout = findViewById(R.id.fragmentContainerMovie);
        linear = (LinearLayout) findViewById(R.id.linear);
        bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerMovie, new HomeFragment()).commit();
        Random random=new Random();
        number=random.nextInt(4);



    }
    // On back press put app to background
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = item -> {
        Fragment selectedFrag = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFrag = new HomeFragment();
                break;
            case R.id.nav_cart:
                selectedFrag = new CartFragment();
                break;
            case R.id.nav_user:
                selectedFrag = new UserFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerMovie, selectedFrag).commit();

        return true;
    };


}
