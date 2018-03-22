package com.mjbarrerab.mymovies.injection.module;

import android.app.Activity;
import android.content.Context;

import com.mjbarrerab.mymovies.injection.qualifier.ActivityContext;
import com.mjbarrerab.mymovies.ui.content.MoviesContentAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miller.barrera
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    //Inject adapters

    @Provides
    MoviesContentAdapter moviesContentAdapter() {
        return new MoviesContentAdapter(mActivity);
    }
}
