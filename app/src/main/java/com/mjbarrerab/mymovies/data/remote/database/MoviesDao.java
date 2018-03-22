package com.mjbarrerab.mymovies.data.remote.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;

import com.mjbarrerab.mymovies.data.model.movies.Result;

import java.util.List;

/**
 * Created by miller.barrera on 2/10/2017.
 */

@Dao
public interface MoviesDao {

    @Query("SELECT * FROM movies")
    List<Result> getAllMovies();

    @Query("SELECT * FROM movies where filterType = :filterType")
    List<Result> getFilterableMovies(String filterType);


    @Delete
    void delete(Result result);
}
