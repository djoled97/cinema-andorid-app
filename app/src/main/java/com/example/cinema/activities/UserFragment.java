package com.example.cinema.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.API.RetrofitApi;
import com.example.cinema.R;
import com.example.cinema.models.User;

import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {
    private TextView nameFiled;
    private TextView lastnameField;
    private TextView emailFiled;
    private ImageView imageUser;
    private String name, lastname, email;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user, container, false);
        nameFiled = v.findViewById(R.id.nameUser);
        lastnameField = v.findViewById(R.id.lastnameUser);
        emailFiled = v.findViewById(R.id.emailUser);
        imageUser = v.findViewById(R.id.imageUser);

        randomizeAvatar();
        putData();
        return v;

    }

    private void putData() {
        //Using sharedprefrences since when going from DetailsActivity to MovieActivity
        //User fragment is empty

        //        Intent intent = getActivity().getIntent();

//        name = intent.getExtras().getString("name");
//        lastname = intent.getExtras().getString("lastname");
//        email = intent.getExtras().getString("email");
//        nameFiled.setText(name);
//        lastnameField.setText(lastname);
//        emailFiled.setText(email);
        sharedPreferences = getContext().getSharedPreferences("LoginPrefs", 0);
        nameFiled.setText(sharedPreferences.getString("name", ""));
        lastnameField.setText(sharedPreferences.getString("lastname", ""));
        emailFiled.setText(sharedPreferences.getString("email", ""));

    }

    private void randomizeAvatar() {

        switch (MovieActivity.number) {
            case 0:
                imageUser.setBackgroundResource(R.drawable.chewy_user);
                break;
            case 1:
                imageUser.setBackgroundResource(R.drawable.java_user);
                break;
            case 2:
                imageUser.setBackgroundResource(R.drawable.lea_user);
                break;
            case 3:
                imageUser.setBackgroundResource(R.drawable.obi_user);
                break;
            case 4:
                imageUser.setBackgroundResource(R.drawable.luke_user);
                break;
        }

    }

}





