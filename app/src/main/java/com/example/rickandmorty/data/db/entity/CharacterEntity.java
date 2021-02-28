package com.example.rickandmorty.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Character")
public class CharacterEntity {
    @PrimaryKey
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    @ColumnInfo(name = "origin_name")
    public String originName;
    @ColumnInfo(name = "location_name")
    public String locationName;
    public String image;
    @ColumnInfo(name = "nb_episodes")
    public int nbEpisodes;
}
