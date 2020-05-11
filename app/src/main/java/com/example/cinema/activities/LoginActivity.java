package com.example.cinema.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cinema.API.RetrofitApi;
import com.example.cinema.R;
import com.example.cinema.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
        EditText fieldUsername;
        EditText fieldPassword;
        Button login;
        CheckBox rememberMe;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        boolean savedLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        getSharedPreferences();
        init();
    }

    private void init(){
        fieldUsername=(EditText) findViewById(R.id.fieldLoginUsername);
        fieldPassword=(EditText) findViewById(R.id.fieldLoginPassword);
        login=(Button) findViewById(R.id.loginButton);
        rememberMe=findViewById(R.id.rememberMe);
        login.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("LoginPrefs",0);
        editor=sharedPreferences.edit();

        savedLogin=sharedPreferences.getBoolean("saveLogin",false);
        //if preferences exist setting their values to existing ones
        if (savedLogin) {
            fieldUsername.setText(sharedPreferences.getString("username", ""));
            fieldPassword.setText(sharedPreferences.getString("password", ""));
            rememberMe.setChecked(true);
        }
//         username=sharedPreferences.getString("username","No email stored");
//         password=sharedPreferences.getString("password","");

    }

//    private void getSharedPreferences() {
//        SharedPreferences sp=getSharedPreferences("LoginPrefs",0);
//        if(sp.contains("username")){
//            String u=sp.getString("username","no username");
//            fieldUsername.setText(u);
//            if(sp.contains("password")){
//                String p=sp.getString("password","no password");
//                fieldPassword.setText(p);
//            }
//        }
//    }

    private void login(){
        Intent intent=new Intent(this, MovieActivity.class);

        String username=fieldUsername.getText().toString().trim();
         String password=fieldPassword.getText().toString().trim();
            rememberMe(username,password);

        String credentials=username + ":" + password;
        String authHeader="Basic " + Base64.encodeToString(credentials.getBytes(),Base64.NO_WRAP);

        Call<User> call= RetrofitApi.getInstance().getApi().login(authHeader);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()){
                   if(response.body()!=null) {
                       response.headers().get("Set-Cookie");
                       User user = response.body();
                       Toast.makeText(getApplicationContext(), "User logged", Toast.LENGTH_SHORT).show();

                       editor.putString("name", user.getName());
                       editor.putString("lastname", user.getLastName());
                       editor.putString("email", user.getEmail());
                        editor.apply();
                       startActivity(intent);
                   }
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }
// Puting values in prefreneces
    private void rememberMe(String u,String p){

        if (rememberMe.isChecked()) {
            editor.putBoolean("saveLogin", true);
            editor.putString("username", u);
            editor.putString("password", p);
            editor.apply();
        } else {
            editor.clear();
            editor.apply();
        }

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){

                case R.id.loginButton:
                    login();
                    break;



            }
    }
}
