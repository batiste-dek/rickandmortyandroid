package com.example.rickandmorty.data.repository;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;
import com.example.rickandmorty.data.repository.remote.RickAndMortyRemoteDataSource;

import io.reactivex.Single;

public class RickAndMortyDataRepository implements RickAndMortyRepository {
    public RickAndMortyRemoteDataSource remoteDataSource;

    public RickAndMortyDataRepository(RickAndMortyRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<RickAndMortySearchResponse> getCharactersByName(String name) {
        return this.remoteDataSource.getCharactersByName(name);
    }

    @Override
    public Single<RMCharacter> getCharacter(int characterId) {

        return this.remoteDataSource.getCharacter(characterId);
    }
}
