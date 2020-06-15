package com.example.cinema.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinema.R;
import com.example.cinema.db.Database;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>  {


    private Context mContext;
    private Cursor mCursor;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
 private    String username;
    private    int basePrice ;
    public CartAdapter(Context context,Cursor cursor) {
        this.mContext = context;
        this.mCursor=cursor;

    }






    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, time, price;
        EditText numOfTickets;
        ImageView poster;
        Button button,deleteCart;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleCart);
            time = itemView.findViewById(R.id.timeCart);
            price = itemView.findViewById(R.id.priceCart);
            poster = itemView.findViewById(R.id.posterCart);
            button = itemView.findViewById(R.id.addMoreTicketsBtn);
            numOfTickets=itemView.findViewById(R.id.numTicketCart);
            deleteCart=itemView.findViewById(R.id.deleteCart);

        }


    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.movie_cart_row, parent, false);


        return new MyViewHolder(view);
    }
    private  void loadData(CartAdapter.MyViewHolder holder){

        sharedPreferences = mContext.getSharedPreferences("LoginPrefs", 0);
        username=  sharedPreferences.getString("username", "");
        String title = mCursor.getString(2);
        String amount = mCursor.getString(3);
        String time = mCursor.getString(4);
        String price = mCursor.getString(5);
        String poster = mCursor.getString(6);

        basePrice=Integer.parseInt(price);


        holder.title.setText(title);
        holder.numOfTickets.setText(amount);
        holder.time.setText(time);
        holder.price.setText(price);
        Picasso.get().load(poster).into(holder.poster);
    }
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewHolder holder, int position) {
//        holder.title.setText(mTitle.get(position));
//        int nunOfTickets= Integer.parseInt(  holder.numOfTickets.getText().toString());
//        holder.time.setText("Time: " + mTime.get(position));
//        holder.price.setText("Price: " + mPrice.get(position));

        Database myDB=new Database(mContext);

        if (!mCursor.moveToPosition(position)) {
            return;
        }
            loadData(holder);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nunOfTickets= Integer.parseInt(  holder.numOfTickets.getText().toString());



                int result=nunOfTickets*basePrice;



                //If more than 6 tickets reset to 1 and send a message
                if(nunOfTickets>6){


                    holder.numOfTickets.setText("1");

                    String priceString=Integer.toString(basePrice);
                    holder.price.setText(priceString);
                    Toast.makeText(mContext, "Maximum of 6 tickets per order", Toast.LENGTH_SHORT).show();

                }else {

                    holder.price.setText(Integer.toString(result) );

                    myDB.updatePriceAndAmount(nunOfTickets,result,holder.title.getText().toString(),username);

                }
//                Picasso.get().load(mPoster.get(position)).into(holder.poster);
            }
        });

        holder.deleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDB.deleteItem(holder.title.getText().toString(),username);

            }
        });


    }


    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}



