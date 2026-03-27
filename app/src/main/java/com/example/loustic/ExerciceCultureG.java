package com.example.loustic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loustic.db.DatabaseClient;
import com.example.loustic.db.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciceCultureG extends AppCompatActivity implements View.OnClickListener {

    // --- Les éléments graphiques ---
    private TextView tvScore;
    private TextView tvQuestion;
    private Button btnReponse1, btnReponse2, btnReponse3, btnReponse4;
    private Button btnQuitter;

    // --- Les variables du jeu ---
    private DatabaseClient mDb;
    private List<Question> listeQuestions; // Va contenir les 10 questions tirées au sort
    private int indexQuestionActuelle = 0; // Pour savoir à quelle question on est (de 0 à 9)
    private int score = 0;
    private String bonneReponseActuelle = ""; // Pour mémoriser la bonne réponse de la question en cours

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice_culture_g);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Initialisation de la base de données
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // 2. Liaison avec les éléments du fichier XML
        tvScore = findViewById(R.id.tv_score);
        tvQuestion = findViewById(R.id.tv_question_culture);
        btnReponse1 = findViewById(R.id.btn_reponse1);
        btnReponse2 = findViewById(R.id.btn_reponse2);
        btnReponse3 = findViewById(R.id.btn_reponse3);
        btnReponse4 = findViewById(R.id.btn_reponse4);
        btnQuitter = findViewById(R.id.btn_quitter_culture);

        // 3. Écoute des clics sur les boutons
        btnReponse1.setOnClickListener(this);
        btnReponse2.setOnClickListener(this);
        btnReponse3.setOnClickListener(this);
        btnReponse4.setOnClickListener(this);
        btnQuitter.setOnClickListener(this);

        // 4. Lancement de la récupération des questions
        chargerQuestions();
    }

    private void chargerQuestions() {
        // AsyncTask pour interroger Room en arrière-plan
        class LoadQuestionsTask extends AsyncTask<Void, Void, List<Question>> {
            @Override
            protected List<Question> doInBackground(Void... voids) {
                // On demande 10 questions de culture G de difficulté 1
                // (Plus tard, tu pourras remplacer le '1' par une variable choisie par l'utilisateur)
                return mDb.getAppDatabase().questionDao().getRandomQuestions("culture_g", 1);
            }

            @Override
            protected void onPostExecute(List<Question> questionsRecuperees) {
                super.onPostExecute(questionsRecuperees);
                listeQuestions = questionsRecuperees;

                if (listeQuestions != null && !listeQuestions.isEmpty()) {
                    afficherQuestion(); // On affiche la première question
                } else {
                    Toast.makeText(getApplicationContext(), "Erreur : Aucune question trouvée !", Toast.LENGTH_LONG).show();
                }
            }
        }

        LoadQuestionsTask task = new LoadQuestionsTask();
        task.execute();
    }

    private void afficherQuestion() {
        // On vérifie si on a posé toutes les questions
        if (indexQuestionActuelle < listeQuestions.size()) {

            // Mise à jour de l'affichage du score
            tvScore.setText("Score : " + score + " / " + listeQuestions.size());

            // Récupération de la question actuelle
            Question questionEnCours = listeQuestions.get(indexQuestionActuelle);
            tvQuestion.setText(questionEnCours.getEnonce());

            // Mémorisation de la bonne réponse pour la vérification future
            bonneReponseActuelle = questionEnCours.getBonneReponse();

            // Préparation des 4 réponses dans une liste
            List<String> reponsesMelangees = new ArrayList<>();
            reponsesMelangees.add(questionEnCours.getBonneReponse());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse1());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse2());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse3());

            // LE SECRET EST ICI : On mélange la liste pour que la bonne réponse change de place !
            Collections.shuffle(reponsesMelangees);

            // On assigne les textes mélangés aux boutons
            btnReponse1.setText(reponsesMelangees.get(0));
            btnReponse2.setText(reponsesMelangees.get(1));
            btnReponse3.setText(reponsesMelangees.get(2));
            btnReponse4.setText(reponsesMelangees.get(3));

        } else {
            // Le quiz est terminé !
            Toast.makeText(this, "Quiz terminé ! Ton score final est de " + score + "/10", Toast.LENGTH_LONG).show();

            // Retour au menu principal
            Intent intent = new Intent(ExerciceCultureG.this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    private void verifierReponse(String reponseChoisie) {
        if (reponseChoisie.equals(bonneReponseActuelle)) {
            score++;
            Toast.makeText(this, "Bravo !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Faux ! C'était : " + bonneReponseActuelle, Toast.LENGTH_SHORT).show();
        }

        // On passe à la question suivante
        indexQuestionActuelle++;

        // On rafraîchit l'écran avec la nouvelle question
        afficherQuestion();
    }

    @Override
    public void onClick(View v) {
        // Si c'est un bouton de réponse, on récupère le texte écrit dessus et on le vérifie
        if (v.getId() == btnReponse1.getId()) {
            verifierReponse(btnReponse1.getText().toString());
        } else if (v.getId() == btnReponse2.getId()) {
            verifierReponse(btnReponse2.getText().toString());
        } else if (v.getId() == btnReponse3.getId()) {
            verifierReponse(btnReponse3.getText().toString());
        } else if (v.getId() == btnReponse4.getId()) {
            verifierReponse(btnReponse4.getText().toString());
        }
        // Si c'est le bouton quitter
        else if (v.getId() == btnQuitter.getId()) {
            Intent intent = new Intent(ExerciceCultureG.this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}