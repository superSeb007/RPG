package com.example.evoliris.supersebrpg.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evoliris.supersebrpg.db.dao.UserDAO;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Exercice_BaseDeDonnee";
    public static int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserDAO.DROP);
        db.execSQL(UserDAO.CREATE);
    }
}
