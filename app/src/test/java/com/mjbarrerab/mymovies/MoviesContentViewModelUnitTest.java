package com.mjbarrerab.mymovies;

import com.mjbarrerab.mymovies.data.SchedulerHelper;
import com.mjbarrerab.mymovies.data.model.movies.Result;
import com.mjbarrerab.mymovies.data.repository.MoviesRepository;
import com.mjbarrerab.mymovies.ui.content.MoviesContentViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.observers.TestSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by miller.barrera on 3/10/2017.
 */

public class MoviesContentViewModelUnitTest {

    MoviesContentViewModel mMoviesContentViewModel;

    MoviesRepository mMoviesRepository;

    SchedulerHelper mSchedulerHelper;

    @Before
    public void setup() {
        // Override RxJava schedulers
        RxJavaHooks.setOnIOScheduler(scheduler -> Schedulers.immediate());

        RxJavaHooks.setOnComputationScheduler(scheduler -> Schedulers.immediate());

        RxJavaHooks.setOnNewThreadScheduler(scheduler -> Schedulers.immediate());

        // Override RxAndroid schedulers
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        mMoviesRepository = Mockito.mock(MoviesRepository.class);
        mSchedulerHelper = Mockito.mock(SchedulerHelper.class);
        when(mMoviesRepository.getMostPopular()).thenReturn(Observable.just(mockedList()));
        when(mSchedulerHelper.getmScheduler()).thenReturn(rxAndroidPlugins.getSchedulersHook().getMainThreadScheduler());

        mMoviesContentViewModel = new MoviesContentViewModel(mMoviesRepository, mSchedulerHelper);

    }

    @Test
    public void readMoviesList() throws Exception {
        TestSubscriber testSubscriber = new TestSubscriber();
        mMoviesContentViewModel.doActionMostPopular().subscribe(testSubscriber);
        //asserts
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(mockedList());
        //verifications
        Mockito.verify(mMoviesRepository, times(1)).getMostPopular();

    }

    private List<Result> mockedList() {
        List<Result> mockedData = new ArrayList<>();
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));
        mockedData.add(new Result(1, 2, 293660, false, 7.4, "DeadPool", 98.8, "/inVq3FRqcYIRl2la8iZikYYxFNR.jpg"
                , "en", "DeadPool", "/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg", false, "Nice movie"
                , "2016-02-09", "mp"));


        return mockedData;
    }
}
