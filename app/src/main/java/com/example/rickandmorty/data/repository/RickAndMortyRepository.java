package com.example.rickandmorty.data.repository;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;

import io.reactivex.Single;

public interface RickAndMortyRepository {
    Single<RickAndMortySearchResponse> getCharactersByName(String name);
    Single<RMCharacter> getCharacter(int characterId);
}
