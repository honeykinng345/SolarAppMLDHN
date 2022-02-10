package com.learn.degger.solarappmldhn.repository;



import com.learn.degger.solarappmldhn.db.UserDao;
import com.learn.degger.solarappmldhn.models.PricesBIPWrapper;
import com.learn.degger.solarappmldhn.models.Register;
import com.learn.degger.solarappmldhn.models.SolarProductListWrapper;
import com.learn.degger.solarappmldhn.models.User;
import com.learn.degger.solarappmldhn.network.Api;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;

public class Repository {

    private Api apiService;
    private UserDao userDao;
    @Inject
    public Repository(UserDao userDao,Api apiService) {
        this.apiService = apiService;
        this.userDao = userDao;
    }
    public Call<Register> DoLogin(String username, String pass){
        return apiService.login(username,pass);
    }
    public void insertUser(User user){
        userDao.users(user);
    }

    public  Call<PricesBIPWrapper> getSpinerData(){
        return apiService.get_All_prices();
    }
    public Observable<SolarProductListWrapper> getCurrentlyShowing(){
        return apiService.fetchAllSolarProductLists();
    }
}