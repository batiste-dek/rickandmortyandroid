package com.example.rickandmorty.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RMCharacter {
    int id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    @SerializedName("origin")
    RMLocation origin;
    @SerializedName("location")
    RMLocation location;
    String image;
    @SerializedName("episode")
    List<String> episodes;
    String url;
}
