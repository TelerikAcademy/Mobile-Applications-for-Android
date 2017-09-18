package com.example.android.datademo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoreDbHelper extends SQLiteOpenHelper {
  private static final int DATABASE_VERSION = 1;
  static final String DATABASE_NAME = "store.db";

  public StoreDbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    final String SQL_CREATE_USERS_TABLE =
            "CREATE TABLE " + ProductsContract.UserEntry.TABLE_NAME + " (" +
            ProductsContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
            ProductsContract.UserEntry.COLUMN_USERNAME + " TEXT NOT NULL" +
            ProductsContract.UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL" +
            ");";
    
    final String SQL_CREATE_PRODUCTS_TABLE =
            "CREATE TABLE " + ProductsContract.ProductEntry.TABLE_NAME + " (" +
            ProductsContract.ProductEntry._ID + " INTEGER PRIMARY KEY," +
            ProductsContract.ProductEntry.COLUMN_USER_KEY + " INTEGER NOT NULL" +
            ProductsContract.ProductEntry.COLUMN_TITLE + " TEXT NOT NULL" +
            ProductsContract.ProductEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL" +
            ProductsContract.ProductEntry.COLUMN_QUANTITY + " REAL NOT NULL" +
            ");";

    sqLiteDatabase.execSQL(SQL_CREATE_USERS_TABLE);
    sqLiteDatabase.execSQL(SQL_CREATE_PRODUCTS_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

  }
}