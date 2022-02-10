package com.learn.degger.solarappmldhn.interfacs;

import androidx.lifecycle.MutableLiveData;

import com.learn.degger.solarappmldhn.models.User;

import java.util.ArrayList;
import java.util.List;

public interface HandleResponses {
    void getUserObject(User user);
     void  ErrorMessage(String msj);
     void HandleSpinerResponse(ArrayList<String> plates,ArrayList<String> betry,ArrayList<String> inverterss);
}
