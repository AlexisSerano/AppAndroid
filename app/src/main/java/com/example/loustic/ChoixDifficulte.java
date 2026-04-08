package com.example.loustic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixDifficulte extends AppCompatActivity implements View.OnClickListener {

    Button btnNiveau1, btnNiveau2, btnNiveau3;
    String matiereChoisie = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_difficulte);

        btnNiveau1 = findViewById(R.id.btnNiveau1);
        btnNiveau2 = findViewById(R.id.btnNiveau2);
        btnNiveau3 = findViewById(R.id.btnNiveau3);

        btnNiveau1.setOnClickListener(this);
        btnNiveau2.setOnClickListener(this);
        btnNiveau3.setOnClickListener(this);

        // On récupère la matière envoyée par la page précédente
        matiereChoisie = getIntent().getStringExtra("MATIERE");
    }

    @Override
    public void onClick(View v) {
        int difficulte = 1;

        if (v.getId() == btnNiveau1.getId()) difficulte = 1;
        else if (v.getId() == btnNiveau2.getId()) difficulte = 2;
        else if (v.getId() == btnNiveau3.getId()) difficulte = 3;

        Intent intent = null;


        if (matiereChoisie.equals("addition")) {
            intent = new Intent(ChoixDifficulte.this, ExerciceAddition.class);
        } else if (matiereChoisie.equals("multiplication")) {
            intent = new Intent(ChoixDifficulte.this, ExerciceMultiplication.class);
        } else if (matiereChoisie.equals("culture_g")) {
            intent = new Intent(ChoixDifficulte.this, ExerciceCultureG.class);
        }

        if (intent != null) {
            intent.putExtra("DIFFICULTE", difficulte);
            startActivity(intent);
        }
    }
}