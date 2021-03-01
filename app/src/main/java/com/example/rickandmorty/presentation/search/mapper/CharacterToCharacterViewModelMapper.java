package com.example.rickandmorty.presentation.search.mapper;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.presentation.search.adapter.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterToCharacterViewModelMapper {

    /**
     * Mapper for single RMCharacter from API to ViewModel
     *
     * @param character the data coming from the API
     * @return the ViewModel data
     */
    private CharactersViewModel map(RMCharacter character) {
        CharactersViewModel charactersViewModel = new CharactersViewModel();
        charactersViewModel.setGender(character.getGender());
        charactersViewModel.setId(character.getId());
        charactersViewModel.setImage(character.getImage());
        charactersViewModel.setLocationName(character.getLocation().getName());
        charactersViewModel.setOriginName(character.getOrigin().getName());
        charactersViewModel.setName(character.getName());
        charactersViewModel.setSpecies(character.getSpecies());
        charactersViewModel.setStatus(character.getStatus());
        charactersViewModel.setType(character.getType());
        charactersViewModel.setEpisodes(character.getEpisodes());
        return charactersViewModel;
    }

    /**
     * Mapper for list of RMCharacter from API to ViewModel
     *
     * @param characterList the data coming from the API
     * @return the list of ViewModel data
     */
    public List<CharactersViewModel> map(List<RMCharacter> characterList) {
        List<CharactersViewModel> list = new ArrayList<>();
        for (RMCharacter character : characterList) {
            list.add(map(character));
        }
        return list;
    }
}
