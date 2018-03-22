package com.mjbarrerab.mymovies.injection.component;

import android.content.Context;

import com.mjbarrerab.mymovies.injection.module.ActivityModule;
import com.mjbarrerab.mymovies.injection.qualifier.ActivityContext;
import com.mjbarrerab.mymovies.injection.scope.PerActivity;
import com.mjbarrerab.mymovies.ui.content.MoviesContentActivity;
import com.mjbarrerab.mymovies.ui.base.BaseActivity;
import com.mjbarrerab.mymovies.ui.details.MovieDetailsActivity;

import dagger.Component;

/**
 * Created by miller.barrera
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //Inject all activities

    void inject(BaseActivity baseActivity);

    void inject(MoviesContentActivity moviesContentActivity);

    void inject(MovieDetailsActivity movieDetailsActivity);


    @ActivityContext
    Context context();

}
