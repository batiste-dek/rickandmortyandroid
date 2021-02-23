package com.example.rickandmorty.data.api;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RickAndMortyApiService {
    @GET("character")
    Single<RickAndMortySearchResponse> getCharactersByName(@Query("name") String name);

    @GET("character/${characterId}")
    Single<RMCharacter> getCharacter(@Query("characterId") int characterId);

}
