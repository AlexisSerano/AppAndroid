package com.example.loustic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Connexion extends AppCompatActivity implements View.OnClickListener {

    EditText inputIdentifiant;
    EditText inputMdp;
    Button btnConnexion;
    Button btnRetour;
    Button btnPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connexion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputIdentifiant = findViewById(R.id.inputIdentifiant);
        inputMdp = findViewById(R.id.inputMdp);
        btnConnexion = findViewById(R.id.btnConnexion);
        btnRetour = findViewById(R.id.btnRetour);
        btnPass = findViewById(R.id.btnPass);

        btnConnexion.setOnClickListener(this);
        btnRetour.setOnClickListener(this);
        btnPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnConnexion.getId()){

        } else if (v.getId() == btnRetour.getId()){
            Intent intent = new Intent(Connexion.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (v.getId() == btnPass.getId()){
            Intent intent = new Intent(Connexion.this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}