package com.example.rickandmorty.presentation.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.rickandmorty.data.repository.RickAndMortyRepository;

import io.reactivex.disposables.CompositeDisposable;

public class CharactersSearchViewModel extends ViewModel {
    private RickAndMortyRepository repository;
    private CompositeDisposable compositeDisposable;

    public CharactersSearchViewModel(RickAndMortyRepository repository) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
    }
}
