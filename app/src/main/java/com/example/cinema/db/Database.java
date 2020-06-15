package com.example.cinema.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database  extends SQLiteOpenHelper {
    private  Context context;

    private static final String DATABASE_NAME="cart.db";
    private static final int DATABASE_VERSION = 1;

    private  static final String TABLE_NAME="cart";
    private  static final String COLUMN_ID="id";


    private  static final String COLUMN_USER="username";
    private  static final String COLUMN_TITLE="title";
    private  static final String COLUMN_PRICE="price";
    private  static final String COLUMN_AMOUNT="amount";
    private  static final String COLUMN_TIME="time";
    private  static final String COLUMN_POSTER="poster";

    public Database( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME +
                "(" +   COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER + " TEXT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AMOUNT + " INTEGER, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_PRICE + " INTEGER, " +
                COLUMN_POSTER + " TEXT );";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addCart(String username,String title ,int price,int amount,String time,String poster){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER, username);
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AMOUNT, amount);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_PRICE, price);
        cv.put(COLUMN_POSTER, poster);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1 ){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
   public Cursor readAllData(String username){
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if(db != null){
//            cursor = db.rawQuery(query, null);
//        }
//        return cursor;

       SQLiteDatabase db = this.getWritableDatabase();
       return   db.query(TABLE_NAME,
               null,
               "username = ?",
               new String[]{username},
               null,null,
               null,
               null

               );
//       db.execSQL("SELECT * FROM " + TABLE_NAME + " WHERE username= " + "'" + username +"'");
    }
    public boolean updatePriceAndAmount(int amount,int price,String title,String username) {
        SQLiteDatabase db = this.getReadableDatabase();
//        ContentValues cv = new ContentValues();
//
//
//        cv.put(COLUMN_AMOUNT, amount);
//        cv.put(COLUMN_PRICE, price);
//        String selection = COLUMN_TITLE + " LIKE ?"
        db.execSQL("UPDATE " + TABLE_NAME + " SET amount = "  + "'"  + amount  +"'"  + "," + "price = " +"'" + price
                +"'"      + " WHERE title = "  +"'" + title +"'"  + "AND" + " username = " + "'"+  username + "'" +   ";");

//
//        int result = db.update(TABLE_NAME, cv, selection,title);
//        if (result == -1) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();

        return  true;
        }

   public void deleteItem(String title,String username){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,"title=? and username=?",new String[]{title,username});
//            db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE title= " + "'"  + title + "'" );


    }
    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}

