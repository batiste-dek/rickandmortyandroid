package com.example.rickandmorty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.rickandmorty.data.di.FakeDependencyInjection;
import com.example.rickandmorty.presentation.search.fragment.CharactersSearchFragment;

public class RickAndMortyActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FakeDependencyInjection.setContext(this.getApplicationContext());
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        final CharactersSearchFragment fragment = new CharactersSearchFragment();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragment;
            }

            @Override
            public int getCount() {
                return 1;
            }
        });
    }

}