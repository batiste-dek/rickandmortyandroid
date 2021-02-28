package com.example.rickandmorty.data.repository;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;
import com.example.rickandmorty.data.db.entity.CharacterEntity;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface RickAndMortyRepository {
    Single<RickAndMortySearchResponse> getCharactersByName(String name);
    Single<RMCharacter> getCharacter(int characterId);
    public Completable addCharacterDetails(CharacterEntity characterEntity);
    public Maybe<CharacterEntity> getCharacterById(int id);
}
