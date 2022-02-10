package com.learn.degger.solarappmldhn.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.buttonclick.ButtonClickHandle;
import com.learn.degger.solarappmldhn.databinding.FragmentHomeBindingImpl;

public class HomeFragment extends Fragment {
    private FragmentHomeBindingImpl bind;
    private ButtonClickHandle buttonClickHandle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      if (bind == null){
          bind = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
      }
      View view = bind.getRoot();
      return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (buttonClickHandle== null){
            buttonClickHandle = new ButtonClickHandle(getActivity());
        }
        bind.setButtonClickDash(buttonClickHandle);
    }
}