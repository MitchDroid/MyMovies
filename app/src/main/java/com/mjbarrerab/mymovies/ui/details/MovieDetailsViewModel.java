package com.mjbarrerab.mymovies.ui.details;

import com.mjbarrerab.mymovies.data.SchedulerHelper;
import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.remote.DataManager;
import com.mjbarrerab.mymovies.data.repository.MoviesDetailsRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by miller.barrera on 28/09/2017.
 */

public class MovieDetailsViewModel {

    private MoviesDetailsRepository mMoviesDetailsRepository;
    private final SchedulerHelper mScheduler;

    @Inject
    public MovieDetailsViewModel(MoviesDetailsRepository mMoviesDetailsRepository, SchedulerHelper mScheduler) {
        this.mMoviesDetailsRepository = mMoviesDetailsRepository;
        this.mScheduler = mScheduler;
    }

    public Observable<MovieDetails> getMovieDetails(final String movieId) {
        return mMoviesDetailsRepository.getMovieDetails(movieId).filter(movieDetails -> movieDetails != null)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(mScheduler.getmScheduler())
                .unsubscribeOn(mScheduler.getmScheduler());
    }

}
