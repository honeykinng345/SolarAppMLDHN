package com.learn.degger.solarappmldhn.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SolarProductListWrapper {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("fetchAllSolarProductLists")
    @Expose
    private ArrayList<FetchAllSolarProductList> fetchAllSolarProductLists = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public SolarProductListWrapper() {
    }

    /**
     *
     * @param error
     * @param fetchAllSolarProductLists
     */
    public SolarProductListWrapper(Boolean error, ArrayList<FetchAllSolarProductList> fetchAllSolarProductLists) {
        super();
        this.error = error;
        this.fetchAllSolarProductLists = fetchAllSolarProductLists;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public ArrayList<FetchAllSolarProductList> getFetchAllSolarProductLists() {
        return fetchAllSolarProductLists;
    }

    public void setFetchAllSolarProductLists(ArrayList<FetchAllSolarProductList> fetchAllSolarProductLists) {
        this.fetchAllSolarProductLists = fetchAllSolarProductLists;
    }

}