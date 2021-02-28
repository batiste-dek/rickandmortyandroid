package com.example.rickandmorty.data.repository.local;

import com.example.rickandmorty.data.db.CharacterDatabase;
import com.example.rickandmorty.data.db.entity.CharacterEntity;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class RickAndMortyLocalDataSource {
    private CharacterDatabase characterDatabase;

    public RickAndMortyLocalDataSource(CharacterDatabase characterDatabase) {
        this.characterDatabase = characterDatabase;
    }

    public Completable addCharacterDetails(CharacterEntity characterEntity) {
        return this.characterDatabase.charactersDAO().insert(characterEntity);
    }

    public Maybe<CharacterEntity> getCharacterById(int id) {
        return this.characterDatabase.charactersDAO().findById(id);
    }


}
