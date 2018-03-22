package com.mjbarrerab.mymovies.data.remote;

import android.support.annotation.IntDef;

/**
 * Created by miller.barrera on 11/11/2016.
 */

public class ApiConstants {

    public static final int LOW_ERROR = 111;
    public static final String API_KEY_V3 = "b67a54ba7a33401dca1dfc856874b32f";
    //API URL
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_URL_MOST_POPULAR = "movie/popular?api_key=" + API_KEY_V3 + "&language=es-ES&page=1";
    public static final String BASE_URL_TOP_RATED = "movie/top_rated?api_key=" + API_KEY_V3 + "&language=es-ES&page=1";

    public static final String BASE_URL_UPCOMING = "movie/upcoming?api_key=" + API_KEY_V3 + "&language=es-ES&page=1";

    public static final String BASE_URL_MOVIE_POSTER = "https://image.tmdb.org/t/p/w500";

    public static final String BASE_URL_MOVIE_DETAILS = "movie/";


    @IntDef({LOW_ERROR})
    public @interface ErrorType {
    }
}
