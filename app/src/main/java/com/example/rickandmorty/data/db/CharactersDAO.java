package com.example.rickandmorty.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rickandmorty.data.db.entity.CharacterEntity;

import io.reactivex.Completable;
import io.reactivex.Maybe;

@Dao
public interface CharactersDAO {
    @Query("Select * FROM Character WHERE id = :id LIMIT 1")
    Maybe<CharacterEntity> findById(int id);

    @Insert
    Completable insert(CharacterEntity entity);
}
