package com.learn.degger.solarappmldhn.buttonclick;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.learn.degger.solarappmldhn.ui.fragments.HomeFragmentDirections;

public class ButtonClickHandle {

    private   Context context;
    private  NavDirections action;
    public ButtonClickHandle(Context context) {
        this.context = context;
    }
    //Home Fragments Button CLick Handle
    public void ButtonClickHome(View view, String text) {
        switch (text) {
            case "calculator":
                 action = HomeFragmentDirections.actionHomeFragmentToSolarCalculatorFragment();
                 Navigation.findNavController(view).navigate(action);
                break;
            case "shoping":
                action = HomeFragmentDirections.actionHomeFragmentToSolarPartShoopingFragments();
                Navigation.findNavController(view).navigate(action);
                break;

        }

    }

}
