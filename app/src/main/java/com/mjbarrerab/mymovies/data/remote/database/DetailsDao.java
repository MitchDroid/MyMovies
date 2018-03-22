package com.mjbarrerab.mymovies.data.remote.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.model.movies.Result;

import java.util.List;

/**
 * Created by miller.barrera on 4/10/2017.
 */
@Dao
public interface DetailsDao {

    @Query("SELECT * FROM details where id = :id")
    MovieDetails getMovieDetail(String id);

    @Insert
    void insertAll(List<Result> mostPopularList);

    @Insert
    void insertAllMovieDetails(MovieDetails movieDetails);
}
