package com.example.rickandmorty.presentation.search.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rickandmorty.R;
import com.example.rickandmorty.data.di.FakeDependencyInjection;
import com.example.rickandmorty.presentation.DetailsActivity;
import com.example.rickandmorty.presentation.search.adapter.CharacterActionInterface;
import com.example.rickandmorty.presentation.search.adapter.CharacterAdapter;
import com.example.rickandmorty.presentation.viewmodel.CharactersSearchViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharactersSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersSearchFragment extends Fragment implements CharacterActionInterface {
    private View view;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView grid_icon;
    private ImageView list_icon;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private CharactersSearchViewModel charactersSearchViewModel;
    private CharacterAdapter characterAdapter;

    public CharactersSearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GridChractersFragment.
     */
    public static CharactersSearchFragment newInstance() {
        return new CharactersSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_search_characters, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@NonNull Bundle bundle) {
        super.onActivityCreated(bundle);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        characterAdapter = new CharacterAdapter(this);
        recyclerView.setAdapter(characterAdapter);
        charactersSearchViewModel = new ViewModelProvider(requireActivity(), FakeDependencyInjection.getViewModelFactory())
                .get(CharactersSearchViewModel.class);
        setupIcons();
        setupSearchView();
        charactersSearchViewModel
                .getCharacters()
                .observe(
                        getViewLifecycleOwner(),
                        charactersViewModels -> characterAdapter.bindViewModels(charactersViewModels)
                );

    }

    private void setupSearchView() {
        searchView = (SearchView) view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                charactersSearchViewModel.getCharactersByName(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void setupIcons() {
        layoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        list_icon = (ImageView) view.findViewById(R.id.list_icon);
        grid_icon = (ImageView) view.findViewById(R.id.grid_icon);
        grid_icon.setOnClickListener(v -> changeLayoutManager(new GridLayoutManager(getActivity(), 2)));
        list_icon.setOnClickListener(v -> changeLayoutManager(new LinearLayoutManager(getActivity())));
    }

    private void changeLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        recyclerView.setLayoutManager(this.layoutManager);
    }

    public void addCharacterDetails(int id) {
        this.charactersSearchViewModel.addCharacterDetails(id, () -> this.openNewActivity(id));
    }

    private Void openNewActivity(int id) {
        System.out.println(id);
        Intent i = new Intent(getActivity(), DetailsActivity.class);
        i.putExtra("characterId", id);
        startActivity(i);
        return null;
    }


}