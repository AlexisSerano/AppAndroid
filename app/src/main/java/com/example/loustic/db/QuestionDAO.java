package com.example.loustic.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {


    @Insert
    long insert(Question question);


    @Query("SELECT * FROM question WHERE matiere = :matiere")
    List<Question> getQuestionsByMatiere(String matiere);


    @Query("SELECT * FROM question WHERE matiere = :matiere AND difficulte = :difficulte")
    List<Question> getQuestionsByMatiereAndDifficulte(String matiere, int difficulte);


    @Query("SELECT * FROM question WHERE matiere = :matiere AND difficulte = :difficulte ORDER BY RANDOM() LIMIT 10")
    List<Question> getRandomQuestions(String matiere, int difficulte);
}