package com.example.rickandmorty.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmorty.data.api.models.RickAndMortySearchResponse;
import com.example.rickandmorty.data.db.entity.CharacterEntity;
import com.example.rickandmorty.data.repository.RickAndMortyRepository;
import com.example.rickandmorty.presentation.details.mapper.CharacterDetails;
import com.example.rickandmorty.presentation.details.mapper.CharacterEntityToCharacterDetailsMapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CharacterDetailsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final CharacterEntityToCharacterDetailsMapper mapper;
    private RickAndMortyRepository repository;
    private MutableLiveData<CharacterDetails> characterDetailsLiveData;
    public CharacterDetailsViewModel(RickAndMortyRepository repository) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
        this.mapper = new CharacterEntityToCharacterDetailsMapper();
        this.characterDetailsLiveData = new MutableLiveData<>();
    }
    public void getCharactersById(int characterId) {
        compositeDisposable.clear();
        compositeDisposable.add(repository.getCharacterById(characterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableMaybeObserver<CharacterEntity>() {
            @Override
            public void onSuccess(@NonNull CharacterEntity characterEntity) {
                characterDetailsLiveData.setValue(mapper.map(characterEntity));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));

    }

    public MutableLiveData<CharacterDetails> getCharacter(int characterId) {
        return characterDetailsLiveData;
    }
}
