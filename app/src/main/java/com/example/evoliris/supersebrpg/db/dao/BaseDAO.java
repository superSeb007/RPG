package com.example.evoliris.supersebrpg.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.evoliris.supersebrpg.db.DbHelper;


public abstract class BaseDAO<Dao, Model> {
    private DbHelper helper;
    private Context context;
    protected SQLiteDatabase db;

    public BaseDAO(Context context){
        this.context = context;
        this.helper = new DbHelper(context);
    }

    public Dao openWriteable(){
        this.db = this.helper.getWritableDatabase();

        return (Dao)this;
    }
    public Dao openReadable(){
        this.db = this.helper.getReadableDatabase();
        return (Dao)this;
    }

    public abstract Model findById(long id);
    public abstract Model from(Cursor cursor);
    public abstract long insert(Model model);
    public abstract void update(Model model);

    public void close(){
        this.db.close();
        this.helper.close();
    }
}
