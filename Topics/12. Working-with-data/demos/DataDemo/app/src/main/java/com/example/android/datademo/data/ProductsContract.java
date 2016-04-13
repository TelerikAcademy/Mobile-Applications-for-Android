package com.example.android.datademo.data;

import android.provider.BaseColumns;

public class ProductsContract {

  public static final class ProductEntry implements BaseColumns {
    public static final String TABLE_NAME = "products";

    public static final String COLUMN_USER_KEY = "user_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_QUANTITY = "quantity";
  }

  public static final class UserEntry implements BaseColumns {
    public static final String TABLE_NAME = "users";

    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
  }
}
