package com.example.loustic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultatExerciceCultureG extends AppCompatActivity implements View.OnClickListener {

    TextView tvScore;
    Button btnRecommencer, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_exercice_culture_g);

        tvScore = findViewById(R.id.tv_score_culture);
        btnMenu = findViewById(R.id.btn_menu_depuis_culture);
        btnRecommencer = findViewById(R.id.btn_recommencer_culture);

        btnMenu.setOnClickListener(this);
        btnRecommencer.setOnClickListener(this);

        int score = getIntent().getIntExtra("SCORE", 0);
        tvScore.setText("Score : " + score + " / 10");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnRecommencer.getId()) {
            Intent intent = new Intent(this, ChoixDifficulte.class);
            intent.putExtra("MATIERE", "culture_g");
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