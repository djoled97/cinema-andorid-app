package com.example.cinema.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.API.RetrofitApi;
import com.example.cinema.R;
import com.example.cinema.models.User;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment implements View.OnClickListener {
    private TextView nameFiled;
    private TextView lastnameField;
    private TextView emailFiled;
    private ImageView imageUser;
    private Button addPic;
    private String name, lastname, email;
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user, container, false);
        nameFiled = v.findViewById(R.id.nameUser);
        lastnameField = v.findViewById(R.id.lastnameUser);
        emailFiled = v.findViewById(R.id.emailUser);
        imageUser = v.findViewById(R.id.imageUser);
        addPic=v.findViewById(R.id.addPictureButton);
        addPic.setOnClickListener(this);
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
        private  void addPic(){
            Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 1);
        }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addPictureButton:
                addPic();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imageUser.setBackgroundResource(0);
            imageUser.setImageBitmap(BitmapFactory.decodeFile(picturePath));



            }


    }


}






