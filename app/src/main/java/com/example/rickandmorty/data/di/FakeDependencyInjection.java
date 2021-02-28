package com.example.rickandmorty.data.di;

import android.content.Context;

import androidx.room.Room;

import com.example.rickandmorty.data.api.RickAndMortyApiService;
import com.example.rickandmorty.data.db.CharacterDatabase;
import com.example.rickandmorty.data.repository.RickAndMortyDataRepository;
import com.example.rickandmorty.data.repository.RickAndMortyRepository;
import com.example.rickandmorty.data.repository.local.RickAndMortyLocalDataSource;
import com.example.rickandmorty.data.repository.remote.RickAndMortyRemoteDataSource;
import com.example.rickandmorty.presentation.ViewModelFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * We mock a dependency injection library such as Dagger with this class
 * Due to the low spectrum of this application, we can manage the boilerplate of handling the dependency injection manually
 * /!\ should not be done in production
 */
public class FakeDependencyInjection {
    private static Retrofit retrofit;
    private static Gson gson;
    private static RickAndMortyApiService apiService;
    private static RickAndMortyRepository repository;
    private static ViewModelFactory viewModelFactory;
    private static CharacterDatabase characterDatabase;
    private static Context appContext;

    public static ViewModelFactory getViewModelFactory() {
        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactory(getRepository());
        }
        return viewModelFactory;
    }

    /**
     * Creates and/or return a singleton Retrofit object in order to perform HTTP requests within our application
     *
     * @return Retrofit singleton
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://rickandmortyapi.com/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .client(client)
                    .build();

        }
        return retrofit;
    }

    /**
     * Creates and/or return a singleton Gson object in order to serialize/deserialize our HTTP requests
     *
     * @return Gson singleton
     */
    private static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * Creates and/or return a singleton RickAndMortyApiService object
     *
     * @return RickAndMortyApiService singleton
     */
    private static RickAndMortyApiService getApiService() {
        if (apiService == null) {
            apiService = getRetrofit().create(RickAndMortyApiService.class);
        }
        return apiService;
    }

    /**
     * Creates and/or return a singleton RickAndMortyRepository object
     *
     * @return RickAndMortyRepository singleton
     */
    private static RickAndMortyRepository getRepository() {
        if (repository == null) {
            repository = new RickAndMortyDataRepository(
                    new RickAndMortyRemoteDataSource(getApiService()),
                    new RickAndMortyLocalDataSource(getDatabase())
            );
        }
        return repository;
    }

    /**
     * Set the application context.
     * We need this application context to setup our Room database from this class.
     *
     * @param context the application context
     */
    public static void setContext(Context context) {
        appContext = context;
    }

    /**
     * Creates and/or return a singleton CharacterDatabase object
     *
     * @return CharacterDatabase singleton
     */
    private static CharacterDatabase getDatabase() {
        if (characterDatabase == null) {
            characterDatabase = Room.databaseBuilder(appContext, CharacterDatabase.class, "db").build();
        }
        return characterDatabase;
    }


}
