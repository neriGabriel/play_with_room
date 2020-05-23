package com.example.room.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayGame {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer id;

    @ColumnInfo(name = "game_name")
    @NonNull
    private String name;

    @ColumnInfo(name = "number_of_players")
    private Integer players;


    private String description;

    public PlayGame(String name, Integer players, String description) {
        this.name = name;
        this.players = players;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlayers() {
        return players;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
