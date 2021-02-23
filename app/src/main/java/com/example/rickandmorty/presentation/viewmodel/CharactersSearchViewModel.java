package com.example.rickandmorty.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmorty.data.api.models.RMCharacter;
import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;
import com.example.rickandmorty.data.repository.RickAndMortyRepository;
import com.example.rickandmorty.presentation.search.adapter.CharactersViewModel;
import com.example.rickandmorty.presentation.search.mapper.CharacterToCharacterViewModelMapper;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CharactersSearchViewModel extends ViewModel {
    private RickAndMortyRepository repository;
    private CompositeDisposable compositeDisposable;
    private CharacterToCharacterViewModelMapper characterToCharacterViewModelMapper;
    private MutableLiveData<List<CharactersViewModel>> characters = new MutableLiveData<List<CharactersViewModel>>();

    public CharactersSearchViewModel(RickAndMortyRepository repository) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
        this.characterToCharacterViewModelMapper = new CharacterToCharacterViewModelMapper();
    }

    public MutableLiveData<List<CharactersViewModel>> getCharacters() {
        return this.characters;
    }


    public void getCharactersByName(String name) {
        compositeDisposable.clear();
        compositeDisposable.add(repository.getCharactersByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RickAndMortySearchResponse>() {

                    @Override
                    public void onSuccess(@NonNull RickAndMortySearchResponse response) {
                        characters.setValue(characterToCharacterViewModelMapper.map(response.getCharacterList()));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                }));
    }

    public Single<RMCharacter> getCharacter(int characterId) {
        return this.repository.getCharacter(characterId);
    }
}
