package com.example.evoliris.supersebrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.evoliris.supersebrpg.db.dao.UserDAO;
import com.example.evoliris.supersebrpg.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

public class ViewCombat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        UserDAO maDb = new UserDAO(this);
        maDb.openWriteable();
        maDb.insert(new Personnage(1, "marsu", 100, 10, "marsu.jpg"));
        maDb.close();

        maDb.openWriteable();
        List<Personnage> mesPerso = maDb.findAll();
        maDb.close();
        String strPersos ="";

        for (Personnage item : mesPerso
             ) {
            strPersos +=  item;

        }




    }
}
