package com.example.loustic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// activite pour afficher le score final apres les additions
public class ResultatExerciceAddition extends AppCompatActivity implements View.OnClickListener {

    TextView tvScore;
    Button btnRecommencer, btnMenu;
    int difficulteJouee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_exercice_addition);

        // on relie les variables aux elements de l'interface
        tvScore = findViewById(R.id.tv_score_addition);
        btnMenu = findViewById(R.id.btn_menu_depuis_addition);
        btnRecommencer = findViewById(R.id.btn_recommencer_addition);

        btnMenu.setOnClickListener(this);
        btnRecommencer.setOnClickListener(this);

        // on recupere le score final et le niveau grace a l'intent envoye par la page d'exercice
        int score = getIntent().getIntExtra("SCORE", 0);
        difficulteJouee = getIntent().getIntExtra("DIFFICULTE", 1);

        tvScore.setText("Score : " + score + " / 10");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnRecommencer.getId()) {
            // si on rejoue on le renvoie vers la page pour choisir le niveau en gardant la bonne matiere
            Intent intent = new Intent(this, ChoixDifficulte.class);
            intent.putExtra("MATIERE", "addition");
            startActivity(intent);
            finish();
        } else if (v.getId() == btnMenu.getId()) {
            // sinon retour au menu principal en vidant l'historique des pages
            Intent intent = new Intent(this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}