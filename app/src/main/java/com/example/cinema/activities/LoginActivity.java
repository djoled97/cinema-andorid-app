package com.example.cinema.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fieldUsername=(EditText) findViewById(R.id.fieldLoginUsername);
        fieldPassword=(EditText) findViewById(R.id.fieldLoginPassword);
        login=(Button) findViewById(R.id.loginButton);

        login.setOnClickListener(this);
    }


    private void login(){
        Intent intent=new Intent(this, MovieActivity.class);
        String username=fieldUsername.getText().toString().trim();
        String password=fieldPassword.getText().toString().trim();
//            String username="djoled";
//            String password="djoled";
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

                       intent.putExtra("name", user.getName());
                       intent.putExtra("lastname", user.getLastName());
                       intent.putExtra("email", user.getEmail());

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
    @Override
    public void onClick(View v) {
            switch (v.getId()){

                case R.id.loginButton:
                    login();
                    break;
            }
    }
}
