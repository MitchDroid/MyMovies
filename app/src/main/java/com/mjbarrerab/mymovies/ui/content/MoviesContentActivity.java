package com.mjbarrerab.mymovies.ui.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.data.model.movies.Result;
import com.mjbarrerab.mymovies.data.remote.ApiConstants;
import com.mjbarrerab.mymovies.ui.base.BaseActivity;
import com.mjbarrerab.mymovies.ui.details.MovieDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public class MoviesContentActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CompositeSubscription mCompositeSubscription;

    @Inject
    MoviesContentViewModel mMoviesContentViewModel;

    @Inject
    MoviesContentAdapter mMoviesContentAdapter;

    @BindView(R.id.toolbarDetails)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.recycler_view_movies)
    RecyclerView mRecyclerViewMovies;

    private static final String SELECTED_MOVIE_ID = "movie_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        initialiceViews();
    }

    private void initialiceViews() {
        setSupportActionBar(mToolbar);
        setTitle("Most popular");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //noinspection deprecation
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        mRecyclerViewMovies.setAdapter(mMoviesContentAdapter);
        mRecyclerViewMovies.setLayoutManager(new GridLayoutManager(this, 2));

        mMoviesContentAdapter.setOnItemClickListener((view, position, imageView) -> {
            showMovieDetails(mMoviesContentAdapter.get(position));
        });

        attachCompositeSubscription();
        fetchMostPopularMovies("mp");
    }


    public void fetchMostPopularMovies(String filterType) {
        switch (filterType) {
            case "mp":
                mCompositeSubscription.add(mMoviesContentViewModel.doActionMostPopular()
                        .subscribe(results -> {
                            if (results != null) {
                                Timber.d("Most popular MovieObject SIZE %s ", results.size());
                                populateMoviesContent(results);

                            }
                        }, throwable -> showError(throwable.getMessage(), ApiConstants.LOW_ERROR)));
                break;
            case "tr":
                mCompositeSubscription.add(mMoviesContentViewModel.doActionTopRated()
                        .subscribe(results -> {
                            if (results != null) {
                                Timber.d("Top rated MovieObject SIZE %s ", results.size());
                                populateMoviesContent(results);

                            }
                        }, throwable -> showError(throwable.getMessage(), ApiConstants.LOW_ERROR)));
                break;
            case "uc":
                mCompositeSubscription.add(mMoviesContentViewModel.doActionUpcoming()
                        .subscribe(results -> {
                            if (results != null) {
                                Timber.d("Upcoming MovieObject SIZE %s ", results.size());
                                populateMoviesContent(results);

                            }
                        }, throwable -> showError(throwable.getMessage(), ApiConstants.LOW_ERROR)));
                break;
            default:
                break;
        }

    }

    public void populateMoviesContent(List<Result> resultList) {
        mMoviesContentAdapter.populateMoviesContent(resultList);
    }

    public void showMovieDetails(Result selectedMovie) {
        Intent detailsIntent = new Intent(this, MovieDetailsActivity.class);
        detailsIntent.putExtra(SELECTED_MOVIE_ID, selectedMovie.getId());
        callActivity(detailsIntent);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_most_popular) {
            setTitle(item.getTitle());
            fetchMostPopularMovies("mp");
        } else if (id == R.id.nav_top_rated) {
            setTitle(item.getTitle());
            fetchMostPopularMovies("tr");
        } else if (id == R.id.nav_upcoming) {
            setTitle(item.getTitle());
            fetchMostPopularMovies("uc");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setToolbarTitle(final String title) {
        setTitle(title);
    }

    public void attachCompositeSubscription() {
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }
}
