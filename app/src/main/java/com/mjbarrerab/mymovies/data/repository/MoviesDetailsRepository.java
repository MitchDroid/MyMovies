package com.mjbarrerab.mymovies.data.repository;

import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.remote.DataManager;
import com.mjbarrerab.mymovies.data.remote.database.DataBaseQueries;
import com.mjbarrerab.mymovies.data.remote.database.DatabaseCreator;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by miller.barrera on 4/10/2017.
 */

@Singleton
public class MoviesDetailsRepository {

    private DataManager mDataManager;

    @Inject
    DatabaseCreator mDatabaseCreator;

    @Inject
    DataBaseQueries mDataBaseQueries;


    @Inject
    public MoviesDetailsRepository(DataManager mDataManager) {
        this.mDataManager = mDataManager;

    }

    /**
     * Get movie details from Room database.
     **/
    public Observable<MovieDetails> getMovieDetails(String movieId) {
        mDatabaseCreator.createDb();
        return Observable.fromCallable(() -> mDataBaseQueries.getSelectedMovieDetails(movieId))
                .flatMap(movieDetails -> {
                    if (movieDetails != null) {
                        return Observable.just(movieDetails);
                    } else {
                        return getMovieDetailsFromServer(movieId);
                    }
                });
    }


    /**
     * //     * Retrive data from server and save it using Room
     * //     *
     * //     * @return Observable movie details
     * //
     */

    private Observable<MovieDetails> getMovieDetailsFromServer(String movieId) {
        return mDataManager.getMoviesDetails(movieId).filter(movieDetails -> movieDetails != null)
                .doOnNext(movieDetails -> {
                    mDatabaseCreator.createDb();
                    mDataBaseQueries.insertMovieDetails(movieDetails);
                });
    }
}


