<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Working with Data
##  Local Files, SQLite
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents' } -->
# Table of Contents
- Storage Options
- Saving Key-Value Sets
- Saving Files
- Saving Data in SQL Databases
- Connecting to the Network

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Storage Options -->

# Storage Options
- **Shared Preferences**
  - Store private primitive data in key-value pairs
- **Internal Storage**
  - Store private data on the device memory
- **External Storage**
  - Store public data on the shared external storage
- **SQLite Databases**
  - Store structured data in a private database
- **Network Connection**
  - Store data on the web with your own network server


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Shared Preferences
## Saving Key-Value Sets -->

<!-- attr: { style:'font-size:0.9em' } -->
# Shared Preferences
- If you want to save a relatively small collection of **key-values**
  - Save any **primitive data**: booleans, floats, ints and strings
- Use the `SharedPreferences` APIs - [link](http://developer.android.com/training/basics/data-storage/shared-preferences.html)
  - Managed by the framework
  - Can be **private** or **shared**
- To write values:
  1.  Call `edit()` to get a `SharedPreferences.Editor`
  2.  Add values with methods such as `putBoolean()` and `putString()`
  3.  Commit the new values with `commit()`
  

<!-- attr: { showInPresentation:true } -->
<!-- # Shared Preferences -->
- `getSharedPreferences()`
  - **Multiple** files identified by name

```java
Context context = getActivity();
SharedPreferences sharedPref = context.getSharedPreferences(
  getString(R.string.pref_file_key), Context.MODE_PRIVATE);
```
- `getPreferences()`
  - **One** file for the `Activity`

```java
SharedPreferences sharedPref = getActivity()
  .getPreferences(Context.MODE_PRIVATE);
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Using Internal Storage -->

<!-- attr: { style:'font-size:0.9em' } -->
# Using Internal Storage
- Files saved to the internal storage are **private** by default
  - Other applications cannot access them
  - Nor can the user
- When the user uninstalls your application, these files are **removed**
- To **cache** some data you should use `getCacheDir()`
  - Rather than storing it persistently

 
<!-- attr: { showInPresentation:true, style:'font-size:0.9em' } -->
<!-- # Using Internal Storage -->
- To **create and write a private file** to the internal storage:
  1.  Call `openFileOutput()` with the name of the file and the operating mode
    - This returns a `FileOutputStream`
  2.  Write to the file with `write()`
  3.  Close the stream with `close()`
- To **read a file** from internal storage:
  1.  Call `openFileInput()` and pass it the name of the file
    - This returns a `FileInputStream`
  2.  Read bytes from the file with `read()`
  3.  Then close the stream with `close()`


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Using SQL Databases -->

<!-- attr: { showInPresentation:true, style:'font-size:0.90em' } -->
# Defining Schema
- A **contract class** is a container for constants that define names for URIs, tables, and columns

```java
public final class FeedReaderContract {
  public FeedReaderContract() {}

  /* Inner class that defines the table contents */
  public static abstract class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "entry";
    public static final String COLUMN_NAME_ENTRY_ID = "entryid";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    ...
  }
}
```

# Creating a Database
- Extend `SQLiteOpenHelper` and @Override `onCreate()`, `onUpdate()`, `onOpen()`
  - Call `getWritableDatabase()` or `getReadableDatabase()`
    - Can be long-running
    - Call with `AsyncTask` or `IntentService`

<!-- attr: { showInPresentation:true, style:'font-size:0.85em' } -->
<!--  # Usefull Methods -->
- For creating entries

```java
private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
    FeedEntry._ID + " INTEGER PRIMARY KEY," +
    FeedEntry.COLUMN_NAME_ENTRY_ID + " TEXT," +
    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
    ... // Any other options for the CREATE command
    " )";
```

- To Drop table

```java
private static final String SQL_DELETE_ENTRIES =
    "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
```


<!-- attr: { showInPresentation:true, style:'font-size:0.85em' } -->
<!--  # Creating a Database -->
```java
public class FeedReaderDbHelper extends SQLiteOpenHelper {
  // Iincrement if you change the database schema
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "FeedReader.db";

  public FeedReaderDbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(SQL_CREATE_ENTRIES);
  }
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // This database is only a cache for online data, so its upgrade policy is
    // to simply to discard the data and start over
    db.execSQL(SQL_DELETE_ENTRIES);
    onCreate(db);
  }
  public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    onUpgrade(db, oldVersion, newVersion);
  }
}
```

<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- CRUD operations -->

<!-- attr: { showInPresentation:true, style:'font-size:0.95em' } -->
# Creating entries
- Passing a `ContentValues` object to the `insert()` method

```java
// Gets the data repository in write mode
SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_ENTRY_ID, id);
values.put(FeedEntry.COLUMN_NAME_TITLE, title);
values.put(FeedEntry.COLUMN_NAME_CONTENT, content);

// Insert the new row, returning the primary key value of the new row
long newRowId;
newRowId = db.insert(
         FeedEntry.TABLE_NAME,
         FeedEntry.COLUMN_NAME_NULLABLE,
         values);
```

<!-- attr: { showInPresentation:true, style:'font-size:0.95em' } -->
# Reading entries
- Use the `query()` method
  - The results are returned in a `Cursor` object

```java
SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection
String[] projection = { FeedEntry._ID,
    FeedEntry.COLUMN_NAME_TITLE,
    FeedEntry.COLUMN_NAME_UPDATED,
    ... };

// How you want the results sorted in the resulting Cursor
String sortOrder =
    FeedEntry.COLUMN_NAME_UPDATED + " DESC";

Cursor c = db.query(FeedEntry.TABLE_NAME,
    projection, selection, selectionArgs,       
    null, null, sortOrder);
```

<!-- attr: { showInPresentation:true, style:'font-size:0.95em' } -->
# Deleting entries
- Provide selection criteria that identify the rows
  - Provided protection against SQL injection


```java
// Define 'where' part of query.
String selection = FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
// Specify arguments in placeholder order.
String[] selectionArgs = { String.valueOf(rowId) };
// Issue SQL statement.
db.delete(table_name, selection, selectionArgs);
```


<!-- attr: { showInPresentation:true, style:'font-size:0.95em' } -->
# Updating entries
- Combines the **content values syntax** of `insert()` with the **where syntax** of `delete()`

```java
SQLiteDatabase db = mDbHelper.getReadableDatabase();

// New value for one column
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_TITLE, title);

// Which row to update, based on the ID
String selection = FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
String[] selectionArgs = { String.valueOf(rowId) };

int count = db.update(
    FeedReaderDbHelper.FeedEntry.TABLE_NAME,
    values,
    selection,
    selectionArgs);
```


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Connecting to the Network -->

# Connecting to the Network
[Connecting to the Network](http://developer.android.com/training/basics/network-ops/connecting.html#connection)


<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
