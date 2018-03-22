package com.mjbarrerab.mymovies.data.remote;

import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.model.movies.MovieObject;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by miller.barrera on 27/09/2017.
 */

public interface MoviesApiService {

    @GET(ApiConstants.BASE_URL_MOST_POPULAR)
    Observable<MovieObject> doGetMostPopular();

    @GET(ApiConstants.BASE_URL_TOP_RATED)
    Observable<MovieObject> doGetTopRated();

    @GET(ApiConstants.BASE_URL_UPCOMING)
    Observable<MovieObject> doGetUpcoming();

    @GET(ApiConstants.BASE_URL_MOVIE_DETAILS + "{movie_id}?api_key=b67a54ba7a33401dca1dfc856874b32f&language=es-ES")
    Observable<MovieDetails> doGetMovieDetails(@Path("movie_id") String movieId);
}
