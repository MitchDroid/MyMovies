package com.mjbarrerab.mymovies.data.remote.database;

import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.model.movies.Result;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by miller.barrera on 23/06/2017.
 */

@Singleton
public class DataBaseQueries {

    private final DatabaseCreator mDatabaseCreator;

    @Inject
    public DataBaseQueries(DatabaseCreator databaseCreator) {
        this.mDatabaseCreator = databaseCreator;
    }

    public void insertData(List<Result> movies) {
        try {
            this.mDatabaseCreator.getDatabase().beginTransaction();
            this.mDatabaseCreator.getDatabase().detailsDao().insertAll(movies);
        } finally {
            this.mDatabaseCreator.getDatabase().setTransactionSuccessful();
            this.mDatabaseCreator.getDatabase().endTransaction();
        }
    }

    public void insertMovieDetails(MovieDetails movieDetails) {
        try {
            this.mDatabaseCreator.getDatabase().beginTransaction();
            this.mDatabaseCreator.getDatabase().detailsDao().insertAllMovieDetails(movieDetails);
        } finally {
            this.mDatabaseCreator.getDatabase().setTransactionSuccessful();
            this.mDatabaseCreator.getDatabase().endTransaction();
        }
    }


    public List<Result> getFilterableMovies(String filterableId) {
        try {
            this.mDatabaseCreator.getDatabase().beginTransaction();
            return this.mDatabaseCreator.getDatabase().moviesDao().getFilterableMovies(filterableId);
        } finally {
            this.mDatabaseCreator.getDatabase().setTransactionSuccessful();
            this.mDatabaseCreator.getDatabase().endTransaction();
        }
    }

    public MovieDetails getSelectedMovieDetails(String movieId) {
        try {
            this.mDatabaseCreator.getDatabase().beginTransaction();
            return this.mDatabaseCreator.getDatabase().detailsDao().getMovieDetail(movieId);
        } finally {
            this.mDatabaseCreator.getDatabase().setTransactionSuccessful();
            this.mDatabaseCreator.getDatabase().endTransaction();
        }
    }


    public void closeDatabase() {
        this.mDatabaseCreator.closeDbInstance();
    }

}
