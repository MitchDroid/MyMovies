package com.mjbarrerab.mymovies.data;

import android.os.HandlerThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by miller.barrera on 5/07/2017.
 */


@Singleton
public class SchedulerHelper extends Scheduler {

    private HandlerThread handlerThread;
    private Scheduler mScheduler;

    @Inject
    public SchedulerHelper() {
        handlerThread = new HandlerThread("backgroundThread");
        handlerThread.start();
        mScheduler = AndroidSchedulers.from(handlerThread.getLooper());
    }

    public Scheduler getmScheduler() {
        return mScheduler;
    }

    @Override
    public Worker createWorker() {
        return null;
    }
}
