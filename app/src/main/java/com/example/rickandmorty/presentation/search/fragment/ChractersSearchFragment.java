package com.example.rickandmorty.presentation.search.fragment;

import android.os.Bundle;

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
import com.example.rickandmorty.presentation.viewmodel.CharactersSearchViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChractersSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChractersSearchFragment extends Fragment {
    private View view;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView grid_icon;
    private ImageView list_icon;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private CharactersSearchViewModel charactersSearchViewModel;

    public ChractersSearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GridChractersFragment.
     */
    public static ChractersSearchFragment newInstance() {
        return new ChractersSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_search_characters, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        charactersSearchViewModel = new ViewModelProvider(requireActivity(), FakeDependencyInjection.getViewModelFactory())
                .get(CharactersSearchViewModel.class);
        setupIcons();
        setupSearchView();
        return view;
    }

    private void setupSearchView() {
        searchView = (SearchView) view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //charactersSearchViewModel
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void setupIcons() {
        layoutManager = new LinearLayoutManager(this.getContext());
        list_icon = (ImageView) view.findViewById(R.id.list_icon);
        grid_icon = (ImageView) view.findViewById(R.id.grid_icon);
        grid_icon.setOnClickListener(v -> layoutManager = new GridLayoutManager(getActivity(), 3));

        list_icon.setOnClickListener(v -> layoutManager = new LinearLayoutManager(getActivity()));
    }

}