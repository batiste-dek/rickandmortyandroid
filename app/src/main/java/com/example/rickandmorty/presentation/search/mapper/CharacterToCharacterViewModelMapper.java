package com.example.rickandmorty.presentation.search.mapper;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.presentation.search.adapter.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterToCharacterViewModelMapper {

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
        return charactersViewModel;
    }

    public List<CharactersViewModel> map(List<RMCharacter> characterList) {
        List<CharactersViewModel> list = new ArrayList<>();
        for (RMCharacter character : characterList) {
            list.add(map(character));
        }
        return list;
    }
}
