package com.mjbarrerab.mymovies.data.remote.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mjbarrerab.mymovies.data.remote.ApiConstants;
import com.mjbarrerab.mymovies.data.remote.MoviesApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miller.barrera on 23/06/2017.
 */

public class Factory {

    public static MoviesApiService create() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit.create(MoviesApiService.class);
    }

//    public static UserApiServiceMockTest createTest() {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(RESTMockServer.getUrl())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//        return retrofit.create(UserApiServiceMockTest.class);
//    }
}
