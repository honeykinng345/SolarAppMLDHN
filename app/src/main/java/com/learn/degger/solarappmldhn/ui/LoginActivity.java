package com.learn.degger.solarappmldhn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.databinding.ActivityLoginBindingImpl;
import com.learn.degger.solarappmldhn.interfacs.HandleResponses;
import com.learn.degger.solarappmldhn.models.User;
import com.learn.degger.solarappmldhn.viewmodel.LoginViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity implements HandleResponses {
    private LoginViewModel viewModel;
    private ActivityLoginBindingImpl binding;
    private  HandleResponses handleResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleResponses = this;
        if (binding == null){
            binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
            setContentView(binding.getRoot());
        }
        if (viewModel == null){
            viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        }
       binding.loginBtn.setOnClickListener(view -> {
           viewModel.doLogin(binding.emailET.getText().toString(),binding.password.getText().toString(),handleResponses);
           //viewModel.getUserObject(handleResponses);
       });
    }


    @Override
    public void getUserObject(User user) {
        viewModel.insertUsers(user);
        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void ErrorMessage(String msj) {

        Toast.makeText(LoginActivity.this, ""+msj, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void HandleSpinerResponse(ArrayList<String> plates, ArrayList<String> betry, ArrayList<String> inverterss) {

    }
}