package com.example.rickandmorty.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RickAndMortySearchResponse {
    @SerializedName("info")
    InfoSearchResponse info;

    @SerializedName("results")
    List<RMCharacter> characterList;

    public InfoSearchResponse getInfo() {
        return info;
    }

    public void setInfo(InfoSearchResponse info) {
        this.info = info;
    }

    public List<RMCharacter> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<RMCharacter> characterList) {
        this.characterList = characterList;
    }
}