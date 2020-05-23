package com.example.room.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room.model.PlayGame;

import java.util.List;

@Dao
public interface PlayGameDao {

    @Insert
    void insert(PlayGame playGame);

    @Query("SELECT * FROM PlayGame")
    List<PlayGame> getAllGames();

    @Query("SELECT * FROM PlayGame WHERE id = :id")
    PlayGame getById(int id);


    /*
    * Só implementar chamando aqui igual chama o insert que vai funfar
    * */
    @Delete
    void delete(PlayGame playGame);

}
