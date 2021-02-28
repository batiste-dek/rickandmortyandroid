package com.example.rickandmorty.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rickandmorty.R;
import com.example.rickandmorty.data.di.FakeDependencyInjection;
import com.example.rickandmorty.presentation.details.mapper.CharacterDetails;
import com.example.rickandmorty.presentation.viewmodel.CharacterDetailsViewModel;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private View containerView;
    private CharacterDetailsViewModel characterDetailsViewModel;
    private int characterId;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        containerView = findViewById(R.id.character_details_container);
        imageView = findViewById(R.id.character_details_image);
        Intent intent = getIntent();
        characterId = intent.getIntExtra("characterId", -1);
        if (characterId == -1) {
            finish();
        }
        characterDetailsViewModel = new ViewModelProvider(this, FakeDependencyInjection.getViewModelFactory())
                .get(CharacterDetailsViewModel.class);
        characterDetailsViewModel
                .getCharacter(characterId)
                .observe(
                        this,
                        characterDetails -> this.bindDataToView(characterDetails)
                );
        characterDetailsViewModel.getCharactersById(characterId);
    }

    private void bindDataToView(CharacterDetails characterDetails) {
        Glide
                .with(this)
                .load(characterDetails.image)
                .centerCrop()
                .override(300)
                .into(imageView);
    }
}