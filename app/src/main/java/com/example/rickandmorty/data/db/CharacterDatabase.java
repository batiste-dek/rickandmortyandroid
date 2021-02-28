package com.example.rickandmorty.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.rickandmorty.data.db.entity.CharacterEntity;

@Database(entities = {CharacterEntity.class}, version = 1)
public abstract class CharacterDatabase extends RoomDatabase {
    public abstract CharactersDAO charactersDAO();
}
