package com.mjbarrerab.mymovies.ui.content;


import com.mjbarrerab.mymovies.data.SchedulerHelper;
import com.mjbarrerab.mymovies.data.model.movies.Result;
import com.mjbarrerab.mymovies.data.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by miller.barrera on 27/09/2017.
 */

public class MoviesContentViewModel {

    private final MoviesRepository mMoviesRepository;

    private final SchedulerHelper mScheduler;

    @Inject
    public MoviesContentViewModel(MoviesRepository mMoviesRepository, SchedulerHelper mScheduler) {
        this.mMoviesRepository = mMoviesRepository;
        this.mScheduler = mScheduler;
    }

    /**
     * This method implements Retrofit Library using RxAndroid
     * The Composite Subscription is handle
     * directly into Activity
     */
    public Observable<List<Result>> doActionMostPopular() {
        return mMoviesRepository.getMostPopular().filter(results -> results != null)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(mScheduler.getmScheduler())
                .unsubscribeOn(mScheduler.getmScheduler());

    }

    public Observable<List<Result>> doActionTopRated() {
        return mMoviesRepository.getTopRated().filter(results -> results != null)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(mScheduler.getmScheduler())
                .unsubscribeOn(mScheduler.getmScheduler());

    }

    public Observable<List<Result>> doActionUpcoming() {
        return mMoviesRepository.getUpcoming().filter(results -> results != null)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(mScheduler.getmScheduler())
                .unsubscribeOn(mScheduler.getmScheduler());

    }
}
