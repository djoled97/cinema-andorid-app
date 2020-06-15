package com.example.cinema.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.R;
import com.example.cinema.db.Database;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CartFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    private Database myDB;
    private  String username;
    private SharedPreferences sharedPreferences;
    private int price;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_cart, container, false);
        init(v);

        return  v;
    }

    private void init (View v){
        Bundle bundle=getArguments();
        myDB=new Database(getActivity());
        sharedPreferences = getContext().getSharedPreferences("LoginPrefs", 0);
        username=  sharedPreferences.getString("username", "");
        if(bundle!=null) {
//            String time=bundle.getString("vreme");
//            String poster=bundle.getString("poster");
//            String title = bundle.getString("title");


//            String parts[] = value.split(" ");
//            String finalValue = parts[0];

//            mTitle.add(title);
//            mPrice.add( Integer.parseInt(finalValue));
//            mTime.add(time);
//            mPoster.add(poster);

        }
        recyclerView=v.findViewById(R.id.recyclerCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CartAdapter(getActivity(),myDB.readAllData(username));

        recyclerView.setAdapter(adapter);

    }

//    private void storeData() {
//
//        Cursor cursor=myDB.readAllData();
//        while (cursor.moveToNext()){
//            .add(cursor.getString(0));
//            book_title.add(cursor.getString(1));
//            book_author.add(cursor.getString(2));
//            book_pages.add(cursor.getString(3));
//    }


}
