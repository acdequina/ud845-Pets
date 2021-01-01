package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";
    private static final String COMMA_SEP = ",";

    private static final String CREATE_PETS_TABLE = "CREATE TABLE "+ PetEntry.TABLE_NAME + " ("+
            PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL" + COMMA_SEP +
            PetEntry.COLUMN_NAME + " TEXT NOT NULL" + COMMA_SEP +
            PetEntry.COLUMN_BREED + " TEXT" + COMMA_SEP +
            PetEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT (0)" + COMMA_SEP +
            PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT (0)" + " )";

    private static final String DELETE_PETS_TABLE = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("PetDbHelper: ", CREATE_PETS_TABLE);
        sqLiteDatabase.execSQL(CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_PETS_TABLE);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
