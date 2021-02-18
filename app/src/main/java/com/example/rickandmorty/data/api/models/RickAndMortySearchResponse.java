package com.example.rickandmorty.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RickAndMortySearchResponse {
    @SerializedName("info")
    InfoSearchResponse info;

    @SerializedName("list")
    List<RMCharacter> characterList;
}