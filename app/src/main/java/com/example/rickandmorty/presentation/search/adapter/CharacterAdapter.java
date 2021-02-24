package com.example.rickandmorty.presentation.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.rickandmorty.R;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        CharacterViewHolder characterViewHolder = new CharacterViewHolder(v);
        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        holder.bindDataToView(this.charactersViewModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.charactersViewModelList.size();
    }

    private List<CharactersViewModel> charactersViewModelList;

    public CharacterAdapter() {
        this.charactersViewModelList = new ArrayList<>();
    }

    public void bindViewModels(List<CharactersViewModel> charactersViewModels) {
        this.charactersViewModelList.clear();
        for (CharactersViewModel viewModel : charactersViewModels) {
            this.charactersViewModelList.add(viewModel);
        }
        notifyDataSetChanged();
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView imageView;
        private TextView nameView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.imageView = itemView.findViewById(R.id.character_image);
            this.nameView = itemView.findViewById(R.id.character_name);

        }

        public void bindDataToView(CharactersViewModel charactersViewModel) {
            this.nameView.setText(charactersViewModel.getName());
            Glide
                    .with(itemView)
                    .load(charactersViewModel.image)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade(2))
                    .override(300)
                    .into(imageView);
        }
    }
}
