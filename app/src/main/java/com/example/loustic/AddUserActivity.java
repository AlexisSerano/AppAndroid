package com.example.loustic;

import android.annotation.SuppressLint;
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

// page pour gérer l'inscription d'un nouvel élève
public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseClient mDb;

    EditText inputIdentifiant;
    EditText inputMdp;
    EditText inputMdpConfirm;
    Button btnInscription;
    Button btnRetour;

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

        // on récupère l'instance de notre base de données locale
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // on chope tous les champs texte et les boutons de l'interface
        inputIdentifiant = findViewById(R.id.inputIdentifiant);
        inputMdp = findViewById(R.id.inputMdp);
        inputMdpConfirm = findViewById(R.id.inputMdpConfirm);
        btnInscription = findViewById(R.id.btnInscription);
        btnRetour = findViewById(R.id.btnRetour);

        // on écoute les clics
        btnInscription.setOnClickListener(this);
        btnRetour.setOnClickListener(this);



    }


    private void saveTask() {



        // Récupérer les informations contenues dans les vues
        final String identifiant = inputIdentifiant.getText().toString().trim();
        final String mdp = inputMdp.getText().toString().trim();
        final String mdpconfirm = inputMdpConfirm.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        // on check d'abord si tout est bien rempli pour éviter de faire planter la db
        if (identifiant.isEmpty()) {
            inputIdentifiant.setError("l'identifiant est vide");
            inputIdentifiant.requestFocus();
            return;
        }

        if (mdp.isEmpty()) {
            inputMdp.setError("le mdp est vide");
            inputMdp.requestFocus();
            return;
        }

        if (mdpconfirm.isEmpty()) {
            inputMdpConfirm.setError("la confirmation du mdp est vide");
            inputMdpConfirm.requestFocus();
            return;
        }

        //  sécurité pour être sûr qu'il a pas fait une faute de frappe dans son mdp
        if (!mdpconfirm.equals(mdp)) {
            inputMdpConfirm.setError("le mdp n'est pas le meme dans les 2 champs");
            inputMdpConfirm.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        // on fait la requête en arrière plan pour pas geler l'interface du tel
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // on regarde  si le pseudo est pas déjà pris
                User userExist = mDb.getAppDatabase().userDao().exist(identifiant);

                if (userExist != null){
                    // si il existe on arrete la fonction
                    return null;
                } else {
                    // creating a user
                    User user = new User();
                    user.setIdentifiant(identifiant);
                    user.setMdp(mdp);


                    // le pseudo est libre on met le nouvel utilisateur dans la table
                    long id = mDb.getAppDatabase().userDao().insert(user);

                    return user;
                }
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);


                if (user == null){

                    //  on affiche l'erreur direct sur le champ de texte
                    inputIdentifiant.setError("l'identifiant est déja utilisé veuillez en choisir un autre");
                    inputIdentifiant.setText("");
                    inputIdentifiant.requestFocus();
                    return;
                }

                // Si user n'est pas null, on continue l'inscription
                setResult(RESULT_OK);
                Intent intent = new Intent(AddUserActivity.this, Connexion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), "Inscription réussie !", Toast.LENGTH_LONG).show();
            }
        }


        // on declenche la tâche asynchrone
        SaveUser su = new SaveUser();
        su.execute();
    }

    @Override
    public void onClick(View v) {
        // gestion classique des clics pour savoir sur quoi on a appuyé
        if (v.getId() == btnInscription.getId()){
            saveTask();

        }
        else if (v.getId() == btnRetour.getId()){
            Intent intent= new Intent(AddUserActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}