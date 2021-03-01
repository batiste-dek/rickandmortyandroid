package com.example.rickandmorty.presentation.details.mapper;

import com.example.rickandmorty.data.db.entity.CharacterEntity;

public class CharacterEntityToCharacterDetailsMapper {
    /**
     * Mapper function
     *
     * @param characterEntity the data from the database
     * @return model used by DetailsActivity screen
     */
    public CharacterDetails map(CharacterEntity characterEntity) {
        CharacterDetails characterDetails = new CharacterDetails();
        characterDetails.id = characterEntity.id;
        characterDetails.name = characterEntity.name;
        characterDetails.status = characterEntity.status;
        characterDetails.species = characterEntity.species;
        characterDetails.type = characterEntity.type;
        characterDetails.gender = characterEntity.gender;
        characterDetails.originName = characterEntity.originName;
        characterDetails.locationName = characterEntity.locationName;
        characterDetails.image = characterEntity.image;
        characterDetails.nbEpisodes = characterEntity.nbEpisodes;
        return characterDetails;
    }
}
