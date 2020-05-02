package com.example.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.API.API;
import com.example.cinema.API.RetrofitApi;
import com.example.cinema.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String BASE_URL = "http://10.0.2.2:8080";
    EditText fieldName;
    EditText fieldLastname;
    EditText fieldEmail;
    EditText fieldUsername;
    EditText fieldPassword;
    EditText fieldConfirmPassword;
    TextView  alreadyRegisteredLogin;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldName = (EditText) findViewById(R.id.fieldName);
        fieldLastname = (EditText) findViewById(R.id.fieldLastname);
        fieldEmail = (EditText) findViewById(R.id.fieldEmail);
        fieldUsername = (EditText) findViewById(R.id.fieldUsername);
        fieldPassword = (EditText) findViewById(R.id.fieldPassword);
        fieldConfirmPassword= (EditText) findViewById(R.id.fieldConfirmPassword);
        alreadyRegisteredLogin=(TextView) findViewById(R.id.alreadyRegisteredLogin);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    private void register() {
//        RetrofitApi.getInstance();
//
//        RegisterAPI api = retrofit.create(RegisterAPI.class);
        String email = fieldEmail.getText().toString().trim();
        String password = fieldPassword.getText().toString().trim();
        String username = fieldUsername.getText().toString().trim();
        String name = fieldName.getText().toString().trim();
        String lastname = fieldLastname.getText().toString().trim();
        String confirmPassword=fieldConfirmPassword.getText().toString().trim();
        if (name.isEmpty() ) {
            fieldName.setError("Name mustn't be empty");
            fieldName.requestFocus();
            return;

        }
            if (lastname.isEmpty()){
                fieldLastname.setError("Last name mustn't be empty");
                fieldLastname.requestFocus();
                return;
            }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            fieldEmail.setError("Enter a valid email");
            fieldEmail.requestFocus();
            return;
        }
        if (username.length() < 5) {
            fieldUsername.setError("Username must be atleast 6 characters");
            fieldUsername.requestFocus();
            return;
        }
        if (!isValidPassword(password)) {
            fieldPassword.setError("pass must have uppercase ,number and at least 6 characters long");
            fieldPassword.requestFocus();
            return;
        }
        if(!confirmPassword.equals(password)){
            fieldConfirmPassword.setError("Passwords must match");
            fieldConfirmPassword.requestFocus();
            return;
        }
        User user = new User(name, email, lastname, username, password);

        Call<User> call =  RetrofitApi.getInstance().getApi().createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User result = response.body();
                if (response.body() != null) {
                    Toast.makeText(getApplicationContext(), "User registered", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }

    private boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                register();
                break;
            case  R.id.alreadyRegisteredLogin:
                Intent  intent=new Intent(this,LoginActivity.class);
                startActivity(intent);

        }
    }
}


