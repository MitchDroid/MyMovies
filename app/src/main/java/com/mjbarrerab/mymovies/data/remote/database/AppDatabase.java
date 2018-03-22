package com.mjbarrerab.mymovies.data.remote.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.model.movies.Result;

/**
 * Created by miller.barrera
 */


@Database(entities = {Result.class, MovieDetails.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "movies-db";

    public abstract MoviesDao moviesDao();
    public abstract DetailsDao detailsDao();
}
