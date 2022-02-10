package com.learn.degger.solarappmldhn.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.degger.solarappmldhn.interfacs.HandleResponses;
import com.learn.degger.solarappmldhn.models.Price;
import com.learn.degger.solarappmldhn.models.PricesBIPWrapper;
import com.learn.degger.solarappmldhn.repository.Repository;
import com.learn.degger.solarappmldhn.utils.Appliances;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolarCalculatorViewModel extends ViewModel {
    private Repository repository;
    private ArrayList<Appliances> mApplicace = new ArrayList<>();
    private Appliances appliances;
    private Executor mExceutor = Executors.newSingleThreadExecutor();
    private MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>();
    ArrayList<String> bettries;
    ArrayList<String> inverters;
    ArrayList<String> plates;

    @ViewModelInject
    public SolarCalculatorViewModel(Repository repository) {
        this.repository = repository;
        inverters = new ArrayList<>();
        bettries = new ArrayList<>();
        plates = new ArrayList<>();
    }

    @Inject
    public SolarCalculatorViewModel(Appliances appliances) {
        this.appliances = appliances;
    }

    public ArrayList<Appliances> getmApplicace() {
        return mApplicace;
    }

    public void InsertApplianceList(int pos, String aplName, String aplWattage, String aplQuantity) {
        mApplicace.add(pos, new Appliances(aplName, aplWattage, aplQuantity));
    }

    public void getSpineNameValuePrices(HandleResponses handleResponses) {
        mExceutor.execute(() -> repository.getSpinerData().enqueue(new Callback<PricesBIPWrapper>() {
            @Override
            public void onResponse(Call<PricesBIPWrapper> call, Response<PricesBIPWrapper> response) {
                if (response.body() != null) {
                    if (!response.body().getError()) {
                        List<Price> list = response.body().getPrices();

                        for (int i = 0; i < list.size(); i++) {
                            // Helper.SHowToast(Solar_CalculatorActivity.this, "" + list.get(i).getPrice());
                            if (list.get(i).getStatus().equals("1")) {
                                inverters.add(list.get(i).getName() + " = " + list.get(i).getPrice());
                            } else if (list.get(i).getStatus().equals("2")) {
                                bettries.add(list.get(i).getName() + " = " + list.get(i).getPrice());

                            } else {
                                plates.add(list.get(i).getName() + " = " + list.get(i).getPrice());
                            }
                        }

                        handleResponses.HandleSpinerResponse(plates, bettries, inverters);
                    }
                }
            }

            @Override
            public void onFailure(Call<PricesBIPWrapper> call, Throwable t) {
                handleResponses.ErrorMessage(t.getMessage());

            }
        }));


    }


}
