package com.learn.degger.solarappmldhn.di;

import com.learn.degger.solarappmldhn.network.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class NetworkModule {

    @Provides
    public static Api provideApiService(){
        return  new Retrofit.Builder()
                .baseUrl("http://192.168.10.10/solar/Apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(Api.class);
    }
}