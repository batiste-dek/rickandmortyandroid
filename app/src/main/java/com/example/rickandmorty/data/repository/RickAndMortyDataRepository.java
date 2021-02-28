package com.example.rickandmorty.data.repository;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;
import com.example.rickandmorty.data.db.entity.CharacterEntity;
import com.example.rickandmorty.data.repository.local.RickAndMortyLocalDataSource;
import com.example.rickandmorty.data.repository.remote.RickAndMortyRemoteDataSource;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class RickAndMortyDataRepository implements RickAndMortyRepository {
    public RickAndMortyRemoteDataSource remoteDataSource;
    public RickAndMortyLocalDataSource localDataSource;

    public RickAndMortyDataRepository(RickAndMortyRemoteDataSource remoteDataSource, RickAndMortyLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<RickAndMortySearchResponse> getCharactersByName(String name) {
        return this.remoteDataSource.getCharactersByName(name);
    }

    @Override
    public Single<RMCharacter> getCharacter(int characterId) {
        return this.remoteDataSource.getCharacter(characterId);
    }

    @Override
    public Completable addCharacterDetails(CharacterEntity characterEntity) {
        return this.localDataSource.addCharacterDetails(characterEntity);
    }

    @Override
    public Maybe<CharacterEntity> getCharacterById(int id) {
        return this.localDataSource.getCharacterById(id);
    }
}
