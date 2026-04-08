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

import com.example.loustic.db.DatabaseClient;


public class MenuExercices extends AppCompatActivity implements View.OnClickListener {

    android.widget.TextView tv_salutation;
    private DatabaseClient mDb;
    Button btnDeco;
    Button btnMath;
    Button btnCultureG;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_exercices);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mDb = DatabaseClient.getInstance(getApplicationContext());
        tv_salutation = findViewById(R.id.tv_salutation);
        android.content.SharedPreferences sharedPreferences = getSharedPreferences("SessionLoustic", MODE_PRIVATE);
        String currentUser = sharedPreferences.getString("USER_ID", "Invité");
        tv_salutation.setText("Bonjour !");


        btnDeco = findViewById(R.id.btnDeco);
        btnMath = findViewById(R.id.btnMath);
        btnCultureG = findViewById(R.id.btnCultureG);


        btnDeco.setOnClickListener(this);
        btnMath.setOnClickListener(this);
        btnCultureG.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnDeco.getId()){
            Intent intent = new Intent(MenuExercices.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else if (v.getId() == btnMath.getId()){
            Intent intent = new Intent(MenuExercices.this, ChoixMatiere.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else if (v.getId() == btnCultureG.getId()){
            Intent intent = new Intent(MenuExercices.this, ChoixDifficulte.class);
            intent.putExtra("MATIERE", "culture_g");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}