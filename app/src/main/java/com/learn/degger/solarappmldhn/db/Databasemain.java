package com.learn.degger.solarappmldhn.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.learn.degger.solarappmldhn.models.User;

@Database(entities = {User.class},version = 2,exportSchema = false)
public abstract  class Databasemain extends RoomDatabase {

    public abstract UserDao userDao();
}
