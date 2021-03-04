package com.example.rickandmorty.data.repository.remote;

import com.example.rickandmorty.data.api.RickAndMortyApiService;
import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;

import io.reactivex.Single;

public class RickAndMortyRemoteDataSource {
    private RickAndMortyApiService apiService;

    public RickAndMortyRemoteDataSource(RickAndMortyApiService apiService) {
        this.apiService = apiService;
    }

    public Single<RickAndMortySearchResponse> getCharactersByName(String name) {
        return this.apiService.getCharactersByName(name);
    }
}
