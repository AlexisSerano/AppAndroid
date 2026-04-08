package com.example.loustic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultatExerciceMultiplication extends AppCompatActivity implements View.OnClickListener {

    TextView tvScore;
    Button btnRecommencer, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_exercice_multiplication);

        tvScore = findViewById(R.id.tv_score_multiplication);
        btnMenu = findViewById(R.id.btn_menu_depuis_multiplication);
        btnRecommencer = findViewById(R.id.btn_recommencer_multiplication);

        btnMenu.setOnClickListener(this);
        btnRecommencer.setOnClickListener(this);

        int score = getIntent().getIntExtra("SCORE", 0);
        tvScore.setText("Score : " + score + " / 10");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnRecommencer.getId()) {
            Intent intent = new Intent(this, ChoixDifficulte.class);
            intent.putExtra("MATIERE", "multiplication");
            startActivity(intent);
            finish();
        } else if (v.getId() == btnMenu.getId()) {
            Intent intent = new Intent(this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}