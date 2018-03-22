package com.mjbarrerab.mymovies.data.remote;


import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.model.movies.MovieObject;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by miller.barrera on 18/10/2016.
 */

@Singleton
public class DataManager {

    private MoviesApiService mMoviesApiService;

    @Inject
    public DataManager(MoviesApiService moviesApiService
    ) {
        this.mMoviesApiService = moviesApiService;
    }


    /******************************************************************
     * Backend for get MovieObject Data.
     ******************************************************************/

    /**
     * Get Most popular movies
     */

    public Observable<MovieObject> getMostPopular() {
        return mMoviesApiService.doGetMostPopular();
    }

    public Observable<MovieObject> getTopRated() {
        return mMoviesApiService.doGetTopRated();
    }

    public Observable<MovieObject> getUpcoming() {
        return mMoviesApiService.doGetUpcoming();
    }

    public Observable<MovieDetails> getMoviesDetails(final String movieId) {
        return mMoviesApiService.doGetMovieDetails(movieId);
    }
}
