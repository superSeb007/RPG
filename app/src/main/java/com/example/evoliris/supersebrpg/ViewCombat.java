package com.example.evoliris.supersebrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.evoliris.supersebrpg.db.dao.UserDAO;
import com.example.evoliris.supersebrpg.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

public class ViewCombat extends AppCompatActivity implements View.OnClickListener{
    private Button btCombatAttaquer;
    private Personnage monPerso, monstreCourent;
    private ProgressBar hpPlayer, hpMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        btCombatAttaquer = findViewById(R.id.bt_fight_attaquer);
        btCombatAttaquer.setOnClickListener(this);

        hpPlayer = (ProgressBar)findViewById(R.id.vertical_progressbar_player);
        hpMonster = (ProgressBar)findViewById(R.id.vertical_progressbar_monster);





        UserDAO maDb = new UserDAO(this);
        maDb.openWriteable();
        //maDb.insert(new Personnage(1, "marsu", 100, 10, "marsu.jpg"));
        maDb.close();

        maDb.openWriteable();
        List<Personnage> mesPerso = maDb.findAll();
        maDb.close();
        String strPersos ="";

        monPerso = new Personnage(1, "marsu", 100, 10, "marsu.jpg");
        monstreCourent = new Personnage(2, "marsu", 100, 10, "marsu.jpg");




        for (Personnage item : mesPerso
             ) {
            strPersos +=  item;

        }

        Toast.makeText(this, strPersos, 10000).show();




    }

    @Override
    public void onClick(View v) {



    }

    private void attaquer(){
        monstreCourent.attaquer(monPerso.getAttaque());
        monPerso.attaquer(monstreCourent.getAttaque());

        hpMonster.setProgress(this.monstreCourent.getPointVie());
        hpPlayer.setProgress(this.monPerso.getPointVie());
    }
}
