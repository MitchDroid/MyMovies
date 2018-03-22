package com.mjbarrerab.mymovies.data.repository;


import com.mjbarrerab.mymovies.data.model.movies.Result;
import com.mjbarrerab.mymovies.data.remote.DataManager;
import com.mjbarrerab.mymovies.data.remote.database.DataBaseQueries;
import com.mjbarrerab.mymovies.data.remote.database.DatabaseCreator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import timber.log.Timber;

/**
 * Created by miller.barrera on 27/09/2017.
 */

@Singleton
public class MoviesRepository {

    private DataManager mDataManager;

    @Inject
    DatabaseCreator mDatabaseCreator;

    @Inject
    DataBaseQueries mDataBaseQueries;

    @Inject
    public MoviesRepository(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    /**
     * Get most popular movies from Room database.
     **/
    public Observable<List<Result>> getMostPopular() {
        mDatabaseCreator.createDb();
        return Observable.fromCallable(() -> mDataBaseQueries.getFilterableMovies("mp"))
                .flatMap(results -> {
                    if (!results.isEmpty()) {
                        return Observable.just(results);
                    } else {
                        return getMostPopularFromServer();
                    }
                });

    }

    /**
     * //     * Retrive data from server and save it using Room
     * //     *
     * //     * @return Observable list results
     * //
     */
    private Observable<List<Result>> getMostPopularFromServer() {
        return mDataManager.getMostPopular().filter(movieObject -> movieObject != null)
                .map(movieObject -> movieObject.getResults())
                .doOnNext(results -> {
                    Timber.d("MOST POPULAR MOVIES SIZE %s", results.size());
                    for (int i = 0; i < results.size(); i++) {
                        results.get(i).setFilterType("mp");
                    }
                    mDatabaseCreator.createDb();
                    mDataBaseQueries.insertData(results);
                });

    }


    /**
     * Get top rated movies from Room database.
     **/
    public Observable<List<Result>> getTopRated() {
        mDatabaseCreator.createDb();
        return Observable.fromCallable(() -> mDataBaseQueries.getFilterableMovies("tr"))
                .flatMap(results -> {
                    if (!results.isEmpty()) {
                        return Observable.just(results);
                    } else {
                        return getTopRatedFromServer();
                    }
                });

    }

    /**
     * //     * Retrive data from server and save it using Room
     * //     *
     * //     * @return Observable list results
     * //
     */
    private Observable<List<Result>> getTopRatedFromServer() {
        return mDataManager.getTopRated().filter(movieObject -> movieObject != null)
                .map(movieObject -> movieObject.getResults())
                .doOnNext(results -> {
                    Timber.d("TOP RATED MOVIES SIZE %s", results.size());
                    for (int i = 0; i < results.size(); i++) {
                        results.get(i).setFilterType("tr");
                    }
                    mDatabaseCreator.createDb();
                    mDataBaseQueries.insertData(results);
                });

    }


    /**
     * Get Upcoming movies from Room database.
     **/
    public Observable<List<Result>> getUpcoming() {
        mDatabaseCreator.createDb();
        return Observable.fromCallable(() -> mDataBaseQueries.getFilterableMovies("uc"))
                .flatMap(results -> {
                    if (!results.isEmpty()) {
                        return Observable.just(results);
                    } else {
                        return getUpcomingFromServer();
                    }
                });

    }

    /**
     * //     * Retrive data from server and save it using Room
     * //     *
     * //     * @return Observable list results
     * //
     */
    private Observable<List<Result>> getUpcomingFromServer() {
        return mDataManager.getUpcoming().filter(movieObject -> movieObject != null)
                .map(movieObject -> movieObject.getResults())
                .doOnNext(results -> {
                    Timber.d("UPCOMING MOVIES SIZE %s", results.size());
                    for (int i = 0; i < results.size(); i++) {
                        results.get(i).setFilterType("uc");
                    }
                    mDatabaseCreator.createDb();
                    mDataBaseQueries.insertData(results);
                });

    }


}
