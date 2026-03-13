package com.example.loustic.db;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loustic.R;

public class AddUserActivity extends AppCompatActivity {
    private DatabaseClient mDb;

    EditText inputIdentifiant;
    EditText inputMdp;
    EditText inputMdpConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mDb = DatabaseClient.getInstance(getApplicationContext());

        inputIdentifiant = findViewById(R.id.inputIdentifiant);
        inputMdp = findViewById(R.id.inputMdp);
        inputMdpConfirm = findViewById(R.id.inputMdpConfirm);




    }


    private void saveTask() {



        // Récupérer les informations contenues dans les vues
        final String identifiant = inputIdentifiant.getText().toString().trim();
        final String mdp = inputMdp.getText().toString().trim();
        final String mdpconfirm = inputMdpConfirm.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (identifiant.isEmpty()) {
            inputIdentifiant.setError("Task required");
            inputIdentifiant.requestFocus();
            return;
        }

        if (mdp.isEmpty()) {
            inputMdp.setError("Desc required");
            inputMdp.requestFocus();
            return;
        }

        if (mdpconfirm.isEmpty()) {
            inputMdpConfirm.setError("Desc required");
            inputMdpConfirm.requestFocus();
            return;
        }

        if (mdpconfirm != mdp) {
            inputMdpConfirm.setError("le mdp n'est pas le meme dans les 2 champs");
            inputMdpConfirm.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a user
                User user = new User();
                user.setIdentifiant(identifiant);
                user.setMdp(mdp);

                // adding to database
                long id = mDb.getAppDatabase()
                        .userDao()
                        .insert(user);




                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser su = new SaveUser();
        su.execute();
    }
}