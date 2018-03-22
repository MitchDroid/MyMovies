package com.mjbarrerab.mymovies.application;

import android.app.Application;
import android.content.Context;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.injection.component.ApplicationComponent;
import com.mjbarrerab.mymovies.injection.component.DaggerApplicationComponent;
import com.mjbarrerab.mymovies.injection.module.ApplicationModule;
import com.mjbarrerab.mymovies.injection.module.NetworkModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by miller.barrera on 27/09/2017.
 */

public class ApplicationController extends Application {

    /**
     * A singleton instance of the application class for easy access in other places
     */
    private static ApplicationController sInstance;
    ApplicationComponent mApplicationComponent;

    /**
     * @return ApplicationController singleton instance
     */
    public static synchronized ApplicationController getInstance() {
        return sInstance;
    }

    public static ApplicationController get(Context context) {
        return (ApplicationController) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the singleton
        sInstance = this;

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    /**
     * To get ApplicationComponent
     *
     * @return ApplicationComponent
     */
    public ApplicationComponent createComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .networkModule(new NetworkModule())
                    .build();
        }
        return mApplicationComponent;
    }
}
