package com.learn.degger.solarappmldhn.utils;

import javax.inject.Inject;

public class Appliances {


    public String mApplianceName;
    public String mApplianceWattage;
    public String mApplianceQuantity;
    public String bettryType;
    public String InverterType;
    public String PlatesType;

    public Appliances() {
    }

    @Inject
    public Appliances(String mApplianceName, String mApplianceWattage, String mApplianceQuantity) {
        this.mApplianceName = mApplianceName;
        this.mApplianceWattage = mApplianceWattage;
        this.mApplianceQuantity = mApplianceQuantity;

    }


    public String getmApplianceName() {
        return mApplianceName;
    }

    public void setmApplianceName(String mApplianceName) {
        this.mApplianceName = mApplianceName;
    }

    public String getmApplianceWattage() {
        return mApplianceWattage;
    }

    public void setmApplianceWattage(String mApplianceWattage) {
        this.mApplianceWattage = mApplianceWattage;
    }

    public String getmApplianceQuantity() {
        return mApplianceQuantity;
    }

    public void setmApplianceQuantity(String mApplianceQuantity) {
        this.mApplianceQuantity = mApplianceQuantity;
    }

    public String getBettryType() {
        return bettryType;
    }

    public void setBettryType(String bettryType) {
        this.bettryType = bettryType;
    }

    public String getInverterType() {
        return InverterType;
    }

    public void setInverterType(String inverterType) {
        InverterType = inverterType;
    }

    public String getPlatesType() {
        return PlatesType;
    }

    public void setPlatesType(String platesType) {
        PlatesType = platesType;
    }
}
