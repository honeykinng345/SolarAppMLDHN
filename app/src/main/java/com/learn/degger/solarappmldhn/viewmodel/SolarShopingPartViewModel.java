package com.learn.degger.solarappmldhn.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.degger.solarappmldhn.models.FetchAllSolarProductList;
import com.learn.degger.solarappmldhn.models.SolarProductListWrapper;
import com.learn.degger.solarappmldhn.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SolarShopingPartViewModel extends ViewModel {
   private  Repository repository;

    private final io.reactivex.rxjava3.disposables.CompositeDisposable disposables = new CompositeDisposable();

    public MutableLiveData<ArrayList<FetchAllSolarProductList>> currentMoviesList = new MutableLiveData<>();
    public    ArrayList<FetchAllSolarProductList> fetchAllSolarProductLists = new ArrayList<>();

    @ViewModelInject
    public SolarShopingPartViewModel(Repository repository) {
        this.repository = repository;
    }

    public  MutableLiveData<ArrayList<FetchAllSolarProductList>> getSolarProductList(){
        return currentMoviesList;
    }
      public void getCurrentlyShowingMovies(){
        disposables.add(repository.getCurrentlyShowing().subscribeOn(Schedulers.io()).map(new Function<SolarProductListWrapper, ArrayList<FetchAllSolarProductList>>() {
                    @Override
                    public ArrayList<FetchAllSolarProductList> apply(SolarProductListWrapper solarProductListWrapper) throws Throwable {

                        Log.d("test", "apply: "+solarProductListWrapper.getFetchAllSolarProductLists().get(0).getId());

                        fetchAllSolarProductLists = solarProductListWrapper.getFetchAllSolarProductLists();
                        return solarProductListWrapper.getFetchAllSolarProductLists();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ArrayList<FetchAllSolarProductList>>() {
                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ArrayList<FetchAllSolarProductList> movies) {
                        currentMoviesList.setValue(movies);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("error", "apply: "+e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d("error", "apply: complete");

                    }
                })
        );
    }
}


