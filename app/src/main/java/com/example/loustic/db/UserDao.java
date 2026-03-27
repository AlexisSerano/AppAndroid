package com.example.loustic.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    long insert(User user);

    @Insert
    long[] insertAll(User... user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM user WHERE identifiant = :id AND mdp = :password LIMIT 1")
    User login(String id, String password);
    @Query("SELECT * FROM user WHERE identifiant = :id LIMIT 1")
    User exist(String id);

}