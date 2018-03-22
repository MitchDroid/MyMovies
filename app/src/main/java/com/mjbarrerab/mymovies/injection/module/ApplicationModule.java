package com.mjbarrerab.mymovies.injection.module;

import android.app.Application;
import android.content.Context;

import com.mjbarrerab.mymovies.injection.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miller.barrera.
 */
@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


}
