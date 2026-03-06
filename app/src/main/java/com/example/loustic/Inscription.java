package com.example.loustic;

import android.annotation.SuppressLint;
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

public class Inscription extends AppCompatActivity implements View.OnClickListener{

    Button btnInscription;
    Button btnRetour;
    EditText inputIdentifiant;
    EditText inputMdp;
    EditText inputMdpConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnInscription = findViewById(R.id.btnInscription);
        btnRetour = findViewById(R.id.btnRetour);
        inputIdentifiant = findViewById(R.id.inputIdentifiant);
        inputMdp = findViewById(R.id.inputMdp);
        inputMdpConfirm = findViewById(R.id.inputMdpConfirm);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnInscription.getId()){

        }else if (v.getId() == btnRetour.getId()){
            Intent intent = new Intent(Inscription.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}