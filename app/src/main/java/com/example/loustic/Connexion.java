package com.example.loustic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loustic.db.DatabaseClient;
import com.example.loustic.db.User;

public class Connexion extends AppCompatActivity implements View.OnClickListener {

    private DatabaseClient mDb;
    EditText inputIdentifiant;
    EditText inputMdp;
    Button btnConnexion;
    Button btnRetour;


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

        mDb = DatabaseClient.getInstance(getApplicationContext());

        inputIdentifiant = findViewById(R.id.inputIdentifiant);
        inputMdp = findViewById(R.id.inputMdp);
        btnConnexion = findViewById(R.id.btnConnexion);
        btnRetour = findViewById(R.id.btnRetour);

        btnConnexion.setOnClickListener(this);
        btnRetour.setOnClickListener(this);


    }


    private void connectUser() {



        // Récupérer les informations contenues dans les vues
        final String identifiant = inputIdentifiant.getText().toString().trim();
        final String mdp = inputMdp.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (identifiant.isEmpty()) {
            inputIdentifiant.setError("veuillez remplir l'identifiant");
            inputIdentifiant.requestFocus();
            return;
        }

        if (mdp.isEmpty()) {
            inputMdp.setError("veuillez remplir le mot de passe");
            inputMdp.requestFocus();
            return;
        }


        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class LoginTask extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {


                return mDb.getAppDatabase().userDao().login(identifiant, mdp);


            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                if (user != null) {
                    Toast.makeText(getApplicationContext(), "Connexion réussie !", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(Connexion.this, MenuExercices.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "Identifiant ou mot de passe incorrect", Toast.LENGTH_LONG).show();
                    inputMdp.setText(""); // On vide le champ du mot de passe
                }
            }


        }

        // On lance la tâche asynchrone
        LoginTask lt = new LoginTask();
        lt.execute();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == btnConnexion.getId()){
            connectUser();
        } else if (v.getId() == btnRetour.getId()){
            Intent intent = new Intent(Connexion.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}