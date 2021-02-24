package com.example.rickandmorty.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.rickandmorty.data.repository.RickAndMortyRepository;
import com.example.rickandmorty.presentation.viewmodel.CharactersSearchViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final RickAndMortyRepository repository;

    public ViewModelFactory(RickAndMortyRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CharactersSearchViewModel.class)) {
            return (T) new CharactersSearchViewModel(this.repository);
        }
        throw new IllegalArgumentException("ViewModel is unknown");
    }
}