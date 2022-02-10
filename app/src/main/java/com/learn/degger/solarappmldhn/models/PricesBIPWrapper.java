package com.learn.degger.solarappmldhn.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PricesBIPWrapper {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public PricesBIPWrapper() {
    }

    /**
     *
     * @param error
     * @param prices
     */
    public PricesBIPWrapper(Boolean error, List<Price> prices) {
        super();
        this.error = error;
        this.prices = prices;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

}