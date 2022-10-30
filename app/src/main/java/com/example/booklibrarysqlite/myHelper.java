package com.example.booklibrarysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;


public class myHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "database.db";
    private  static final int DB_VERSION = 1;

    // it is compulsory in this totorial sue to toast
    Context context;

    private  static final String TABLE_NAME = "my_library";
    private  static final String COLUMN_ID = "_id";
    private  static final String COLUMN_TITLE = "book_title";
    private  static final String COLUMN_AUTHOR = "book_author";
    private  static final String COLUMN_PAGES = "book_pages";


    public myHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE "+TABLE_NAME +" (" +
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_TITLE +" TEXT, "
                +COLUMN_AUTHOR +" TEXT, "
                +COLUMN_PAGES +" INTEGER ); ";

        sqLiteDatabase.execSQL(sql);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    void addBooks(String title,String author, int pages){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_AUTHOR,author);
        cv.put(COLUMN_PAGES,pages);
        
        long Result = db.insert(TABLE_NAME,null,cv);
        
        if (Result==-1){
            Toast.makeText(context, " failed to add ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successfully added a book", Toast.LENGTH_SHORT).show();
        }
        

    }
}
