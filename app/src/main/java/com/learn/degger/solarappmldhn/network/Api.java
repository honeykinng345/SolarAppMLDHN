package com.learn.degger.solarappmldhn.network;

import com.learn.degger.solarappmldhn.models.PricesBIPWrapper;
import com.learn.degger.solarappmldhn.models.Register;
import com.learn.degger.solarappmldhn.models.SolarProductListWrapper;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @POST("login.php")
    @FormUrlEncoded
    Call<Register> login(@Field("email") String username, @Field("password") String password);

    @POST("get_All_prices.php")
    Call<PricesBIPWrapper> get_All_prices();

    @POST("fetchAllSolarProductLists.php")
    Observable<SolarProductListWrapper> fetchAllSolarProductLists();

}
