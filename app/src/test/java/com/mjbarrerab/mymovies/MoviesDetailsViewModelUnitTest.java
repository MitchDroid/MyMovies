package com.mjbarrerab.mymovies;

import com.mjbarrerab.mymovies.data.SchedulerHelper;
import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.remote.DataManager;
import com.mjbarrerab.mymovies.data.repository.MoviesRepository;
import com.mjbarrerab.mymovies.ui.content.MoviesContentViewModel;
import com.mjbarrerab.mymovies.ui.details.MovieDetailsViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.observers.TestSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by miller.barrera on 3/10/2017.
 */

public class MoviesDetailsViewModelUnitTest {

    MovieDetailsViewModel mMovieDetailsViewModel;

    DataManager mDataManager;

    SchedulerHelper mSchedulerHelper;

    @Before
    public void setUp() {
        // Override RxJava schedulers
        RxJavaHooks.setOnIOScheduler(scheduler -> Schedulers.immediate());

        RxJavaHooks.setOnComputationScheduler(scheduler -> Schedulers.immediate());

        RxJavaHooks.setOnNewThreadScheduler(scheduler -> Schedulers.immediate());

        // Override RxAndroid schedulers
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.io();
            }
        });

        mDataManager = Mockito.mock(DataManager.class);
        mSchedulerHelper = Mockito.mock(SchedulerHelper.class);
        when(mDataManager.getMoviesDetails(anyString())).thenReturn(Observable.just(mockedData()));
        when(mSchedulerHelper.getmScheduler()).thenReturn(rxAndroidPlugins.getSchedulersHook().getMainThreadScheduler());

        mMovieDetailsViewModel = new MovieDetailsViewModel(mDataManager, mSchedulerHelper);
    }

    @Test
    public void getMovieDetails() throws Exception {
        TestSubscriber testSubscriber = new TestSubscriber();
        mMovieDetailsViewModel.getMovieDetails(anyString()).subscribe(testSubscriber);
        //asserts
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(mockedData());
        //verifications
        Mockito.verify(mDataManager, times(1)).getMoviesDetails(anyString());

    }

    public MovieDetails mockedData() {
        return new MovieDetails(false, "/h3V6CVLF97BOw1FzjAiuHKQMxjT.jpg", null, 0, new ArrayList<>(), ""
                , 46907, "tt0972782", "en", "Notorious B.I.G. Bigger Than Life", "The greatest rapper to ever pick up a mic"
                , 0.10930, "/p5SalxWMeU3XIP3owBFQtkJOyz5.jpg", new ArrayList<>(), new ArrayList<>(), "2007-05-16", 0, 0, new ArrayList<>(), "Released", ""
                , "Notorious B.I.G. Bigger Than Life", false, 6.2, 3);
    }
}
