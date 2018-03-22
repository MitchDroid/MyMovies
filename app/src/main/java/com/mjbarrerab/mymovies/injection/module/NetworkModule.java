package com.mjbarrerab.mymovies.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.mjbarrerab.mymovies.data.remote.MoviesApiService;
import com.mjbarrerab.mymovies.data.remote.factory.Factory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miller.barrera.
 */
@Module
public class NetworkModule {

    protected final String PREF_NAME = "preferences";

    public NetworkModule() {
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public MoviesApiService moviesApiService(){
        return Factory.create();
    }

}
