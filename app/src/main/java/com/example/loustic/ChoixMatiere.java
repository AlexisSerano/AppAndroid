package com.example.loustic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoixMatiere extends AppCompatActivity implements View.OnClickListener {

    Button btnAdditions;
    Button btnMultiplications;
    Button btnRetour;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choix_matiere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAdditions = findViewById(R.id.btnAdditions);
        btnMultiplications = findViewById(R.id.btnMultiplications);
        btnRetour = findViewById(R.id.btnRetour);

        btnAdditions.setOnClickListener(this);
        btnMultiplications.setOnClickListener(this);
        btnRetour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnAdditions.getId()){
            Intent intent = new Intent(ChoixMatiere.this, ExerciceAddition.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else if (v.getId() == btnMultiplications.getId()){
            Intent intent = new Intent(ChoixMatiere.this, ExerciceMultiplication.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else if (v.getId() == btnRetour.getId()){
            Intent intent = new Intent(ChoixMatiere.this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}