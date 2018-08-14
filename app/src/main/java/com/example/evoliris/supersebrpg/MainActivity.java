package com.example.evoliris.supersebrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.evoliris.supersebrpg.metier.Personnage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnMainValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMainValider = (Button) findViewById(R.id.btn_main_valider);
        btnMainValider.setOnClickListener(this);

        Personnage monPersonnage  = new Personnage(1, "superSeb", 100, 20, "tete du perso" );

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_main_valider: commencerLeCombat(); break;
        }

    }

    public void commencerLeCombat(){
        Intent leCombat = new Intent(this, ViewCombat.class);
        startActivity(leCombat);
    }
}
