package com.learn.degger.solarappmldhn.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.degger.solarappmldhn.interfacs.HandleResponses;
import com.learn.degger.solarappmldhn.models.Register;
import com.learn.degger.solarappmldhn.models.User;
import com.learn.degger.solarappmldhn.repository.Repository;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private Repository repository;
    private Executor mExceutor = Executors.newSingleThreadExecutor();
    private  String error = null;
    private  HandleResponses handleResponses;
   private  User user;

    @ViewModelInject
    public LoginViewModel(Repository repository) {
        this.repository = repository;

    }

    /*    public void getUserObject(HandleResponses handleResponses) {

        if (user == null){
            handleResponses.ErrorMessage(error);
        }else{

           handleResponses.getUserObject(user);
        }
    }*/


    public void doLogin(String uname, String pass,HandleResponses handleResponses) {
        this.handleResponses = handleResponses;
        mExceutor.execute(() -> repository.DoLogin(uname, pass).enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.isSuccessful()){
                    if (response.body().getError()){

                        handleResponses.ErrorMessage(response.body().getError_msg());
                    }
                    else{
                        handleResponses.getUserObject(response.body().getUser());

                    }
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                handleResponses.ErrorMessage( t.getMessage().toLowerCase(Locale.ROOT));

            }
        }));


    }


    public void insertUsers(User user){
        repository.insertUser(user);
    }
}