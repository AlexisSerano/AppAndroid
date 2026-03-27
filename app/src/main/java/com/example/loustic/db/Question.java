package com.example.loustic.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "question")
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String matiere;

    private int difficulte;
    private String enonce;
    private String bonneReponse;

    // On remplace l'ArrayList par 3 champs simples
    private String mauvaiseReponse1;
    private String mauvaiseReponse2;
    private String mauvaiseReponse3;


    public int getId() { return id; }
    public String getMatiere() { return matiere; }
    public int getDifficulte() { return difficulte; }
    public String getEnonce() { return enonce; }
    public String getBonneReponse() { return bonneReponse; }
    public String getMauvaiseReponse1() { return mauvaiseReponse1; }
    public String getMauvaiseReponse2() { return mauvaiseReponse2; }
    public String getMauvaiseReponse3() { return mauvaiseReponse3; }


    public void setId(int id) { this.id = id; }
    public void setMatiere(String matiere) { this.matiere = matiere; }
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }
    public void setEnonce(String enonce) { this.enonce = enonce; }
    public void setBonneReponse(String bonneReponse) { this.bonneReponse = bonneReponse; }
    public void setMauvaiseReponse1(String mauvaiseReponse1) { this.mauvaiseReponse1 = mauvaiseReponse1; }
    public void setMauvaiseReponse2(String mauvaiseReponse2) { this.mauvaiseReponse2 = mauvaiseReponse2; }
    public void setMauvaiseReponse3(String mauvaiseReponse3) { this.mauvaiseReponse3 = mauvaiseReponse3; }
}