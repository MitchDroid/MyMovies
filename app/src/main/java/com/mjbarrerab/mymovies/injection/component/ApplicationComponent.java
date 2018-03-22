package com.mjbarrerab.mymovies.injection.component;


import android.app.Application;
import android.content.Context;

import com.mjbarrerab.mymovies.data.SchedulerHelper;
import com.mjbarrerab.mymovies.data.remote.DataManager;
import com.mjbarrerab.mymovies.data.remote.database.DataBaseQueries;
import com.mjbarrerab.mymovies.data.remote.database.DatabaseCreator;
import com.mjbarrerab.mymovies.data.repository.MoviesDetailsRepository;
import com.mjbarrerab.mymovies.data.repository.MoviesRepository;
import com.mjbarrerab.mymovies.injection.module.ApplicationModule;
import com.mjbarrerab.mymovies.injection.module.NetworkModule;
import com.mjbarrerab.mymovies.injection.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by miller.barrera on 14/10/2016.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {


    Application application();

    @ApplicationContext
    Context context();

    DataManager dataManager();

    MoviesRepository moviesRepository();

    MoviesDetailsRepository moviesDetailsRepository();

    SchedulerHelper schedulerHelper();

    DatabaseCreator dataBaseCreator();

    DataBaseQueries dataBaseQueries();
}
