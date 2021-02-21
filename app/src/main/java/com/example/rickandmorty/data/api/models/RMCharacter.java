package com.example.rickandmorty.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RMCharacter {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @SerializedName("origin")
    private RMLocation origin;
    @SerializedName("location")
    private RMLocation location;
    private String image;
    @SerializedName("episode")
    private List<String> episodes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public RMLocation getOrigin() {
        return origin;
    }

    public void setOrigin(RMLocation origin) {
        this.origin = origin;
    }

    public RMLocation getLocation() {
        return location;
    }

    public void setLocation(RMLocation location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<String> episodes) {
        this.episodes = episodes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
}
