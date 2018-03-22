package com.mjbarrerab.mymovies.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.application.ApplicationController;
import com.mjbarrerab.mymovies.data.remote.ApiConstants;
import com.mjbarrerab.mymovies.injection.component.ActivityComponent;
import com.mjbarrerab.mymovies.injection.component.DaggerActivityComponent;
import com.mjbarrerab.mymovies.injection.module.ActivityModule;

import timber.log.Timber;

/**
 * Created by miller.barrera on 27/09/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this))
                    .applicationComponent(ApplicationController.get(this).createComponent()).build();
        }
        return mActivityComponent;
    }

    protected void callActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showError(String message, @ApiConstants.ErrorType int errorType) {
        Timber.d("Github API Service error %s ", message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
