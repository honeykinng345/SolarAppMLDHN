package com.learn.degger.solarappmldhn.di;

import android.app.Application;

import androidx.room.Room;

import com.learn.degger.solarappmldhn.db.Databasemain;
import com.learn.degger.solarappmldhn.db.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static Databasemain providePokemonDB(Application application){
        return Room.databaseBuilder(application,Databasemain.class,"Favorite Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static UserDao providePokeDao(Databasemain databasemain){
        return databasemain.userDao();
    }
}