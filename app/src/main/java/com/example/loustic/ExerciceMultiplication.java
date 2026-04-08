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

public class ExerciceMultiplication extends AppCompatActivity implements View.OnClickListener {

    private TextView tvScore;
    private TextView tvQuestion;
    private Button btnReponse1, btnReponse2, btnReponse3, btnReponse4;
    private Button btnQuitter;


    private DatabaseClient mDb;
    private List<Question> listeQuestions;
    private int indexQuestionActuelle = 0;
    private int score = 0;
    private String bonneReponseActuelle = "";


    private int difficulteActuelle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice_addition);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        difficulteActuelle = getIntent().getIntExtra("DIFFICULTE", 1);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        tvScore = findViewById(R.id.tv_score);
        tvQuestion = findViewById(R.id.tv_question_culture);
        btnReponse1 = findViewById(R.id.btn_reponse1);
        btnReponse2 = findViewById(R.id.btn_reponse2);
        btnReponse3 = findViewById(R.id.btn_reponse3);
        btnReponse4 = findViewById(R.id.btn_reponse4);
        btnQuitter = findViewById(R.id.btn_quitter_culture);

        btnReponse1.setOnClickListener(this);
        btnReponse2.setOnClickListener(this);
        btnReponse3.setOnClickListener(this);
        btnReponse4.setOnClickListener(this);
        btnQuitter.setOnClickListener(this);

        chargerQuestions();
    }

    private void chargerQuestions() {
        class LoadQuestionsTask extends AsyncTask<Void, Void, List<Question>> {
            @Override
            protected List<Question> doInBackground(Void... voids) {
                return mDb.getAppDatabase().questionDao().getRandomQuestions("multiplication", difficulteActuelle);
            }

            @Override
            protected void onPostExecute(List<Question> questionsRecuperees) {
                super.onPostExecute(questionsRecuperees);
                listeQuestions = questionsRecuperees;

                if (listeQuestions != null && !listeQuestions.isEmpty()) {
                    afficherQuestion();
                } else {
                    Toast.makeText(getApplicationContext(), "Erreur : Aucune question trouvée !", Toast.LENGTH_LONG).show();
                }
            }
        }

        LoadQuestionsTask task = new LoadQuestionsTask();
        task.execute();
    }

    private void afficherQuestion() {
        if (indexQuestionActuelle < listeQuestions.size()) {

            tvScore.setText("Score : " + score + " / " + listeQuestions.size());

            Question questionEnCours = listeQuestions.get(indexQuestionActuelle);
            tvQuestion.setText(questionEnCours.getEnonce());

            bonneReponseActuelle = questionEnCours.getBonneReponse();

            List<String> reponsesMelangees = new ArrayList<>();
            reponsesMelangees.add(questionEnCours.getBonneReponse());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse1());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse2());
            reponsesMelangees.add(questionEnCours.getMauvaiseReponse3());

            Collections.shuffle(reponsesMelangees);

            btnReponse1.setText(reponsesMelangees.get(0));
            btnReponse2.setText(reponsesMelangees.get(1));
            btnReponse3.setText(reponsesMelangees.get(2));
            btnReponse4.setText(reponsesMelangees.get(3));

        } else {
            Intent intent = new Intent(ExerciceMultiplication.this, ResultatExerciceMultiplication.class);
            intent.putExtra("SCORE", score);
            intent.putExtra("DIFFICULTE", difficulteActuelle);

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


        indexQuestionActuelle++;
        afficherQuestion();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnReponse1.getId()) verifierReponse(btnReponse1.getText().toString());
        else if (v.getId() == btnReponse2.getId()) verifierReponse(btnReponse2.getText().toString());
        else if (v.getId() == btnReponse3.getId()) verifierReponse(btnReponse3.getText().toString());
        else if (v.getId() == btnReponse4.getId()) verifierReponse(btnReponse4.getText().toString());
        else if (v.getId() == btnQuitter.getId()) {
            Intent intent = new Intent(ExerciceMultiplication.this, MenuExercices.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}