package com.example.rickandmorty.presentation.search.mapper;

import com.example.rickandmorty.data.db.entity.CharacterEntity;
import com.example.rickandmorty.presentation.search.adapter.CharactersViewModel;

public class CharacterViewModelToCharacterEntityMapper {
    public CharacterEntity map(CharactersViewModel charactersViewModel) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.gender = charactersViewModel.getGender();
        characterEntity.id = charactersViewModel.getId();
        characterEntity.image = charactersViewModel.getGender();
        characterEntity.locationName = charactersViewModel.getLocationName();
        characterEntity.originName = charactersViewModel.getOriginName();
        characterEntity.nbEpisodes = charactersViewModel.getEpisodes().size();
        characterEntity.image = charactersViewModel.getImage();
        characterEntity.species = charactersViewModel.getSpecies();
        characterEntity.name = charactersViewModel.getName();
        characterEntity.status = charactersViewModel.getStatus();
        characterEntity.type = charactersViewModel.getType();
        return characterEntity;
    }
}
