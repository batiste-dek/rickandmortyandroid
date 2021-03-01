package com.example.rickandmorty.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private TextView detailsGenderView;
    private TextView detailsNameView;
    private TextView detailsSpeciesView;
    private TextView detailsOriginView;
    private TextView detailsLocationView;
    private TextView detailsTypeView;
    private TextView detailsNbEpisodesView;
    private TextView detailsStatusView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        containerView = findViewById(R.id.character_details_container);
        imageView = findViewById(R.id.character_details_image);
        detailsSpeciesView = findViewById(R.id.character_details_species);
        detailsTypeView = findViewById(R.id.character_details_type);
        detailsGenderView = findViewById(R.id.character_details_gender);
        detailsNameView = findViewById(R.id.character_details_name);
        detailsOriginView = findViewById(R.id.character_details_origin);
        detailsSpeciesView = findViewById(R.id.character_details_species);
        detailsLocationView = findViewById(R.id.character_details_location);
        detailsNbEpisodesView = findViewById(R.id.character_details_nb_episodes);
        detailsStatusView = findViewById(R.id.character_details_status);

        Intent intent = getIntent();
        characterId = intent.getIntExtra("characterId", -1);
        // if we don't have the characterId, we cannot fetch the data from the database.
        // Therefore we want to quit this activity
        if (characterId == -1) {
            finish();
        }
        characterDetailsViewModel = new ViewModelProvider(this, FakeDependencyInjection.getViewModelFactory())
                .get(CharacterDetailsViewModel.class);
        characterDetailsViewModel
                .getCharacter()
                .observe(
                        this,
                        characterDetails -> this.bindDataToView(characterDetails)
                );
        characterDetailsViewModel.getCharacterById(characterId);
    }

    /**
     * Adapter method to bind data to the views
     *
     * @param characterDetails the data to display
     */
    private void bindDataToView(CharacterDetails characterDetails) {
        detailsSpeciesView.setText(characterDetails.getSpecies());
        detailsGenderView.setText(characterDetails.getGender());
        detailsLocationView.setText(characterDetails.getLocationName());
        detailsOriginView.setText(characterDetails.getOriginName());
        detailsNameView.setText(characterDetails.getName());
        detailsTypeView.setText(characterDetails.getType());
        detailsNbEpisodesView.setText(characterDetails.getNbEpisodes() + "");
        detailsStatusView.setText(characterDetails.getStatus());
        Glide
                .with(this)
                .load(characterDetails.getImage())
                .centerCrop()
                .override(300)
                .into(imageView);
    }
}