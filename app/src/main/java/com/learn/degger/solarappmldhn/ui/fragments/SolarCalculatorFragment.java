package com.learn.degger.solarappmldhn.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.learn.degger.solarappmldhn.BR;
import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.adapters.SpinerAdapter;
import com.learn.degger.solarappmldhn.databinding.FragmentHomeBindingImpl;
import com.learn.degger.solarappmldhn.databinding.FragmentSolarCalculatorBindingImpl;
import com.learn.degger.solarappmldhn.interfacs.ClickListner;
import com.learn.degger.solarappmldhn.interfacs.HandleResponses;
import com.learn.degger.solarappmldhn.models.User;
import com.learn.degger.solarappmldhn.utils.Appliances;
import com.learn.degger.solarappmldhn.utils.Helper;
import com.learn.degger.solarappmldhn.viewmodel.LoginViewModel;
import com.learn.degger.solarappmldhn.viewmodel.SolarCalculatorViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.http.HEAD;


@AndroidEntryPoint
public class SolarCalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener, HandleResponses {
    private FragmentSolarCalculatorBindingImpl bind;
    private SolarCalculatorViewModel solarCalculatorViewModel;
    private    int totalLabour = 0;
    private  int totalCalculate = 0;
    private ArrayList<String> bettrylist,platelist,inverterList ;
    private  String bettryValue,platevalue,invervalue;
    private  HandleResponses handleResponses;
    private SpinerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (bind == null) {
            bind = DataBindingUtil.inflate(inflater, R.layout.fragment_solar_calculator, container, false);
        }
         handleResponses = this;
        View view = bind.getRoot();
        solarCalculatorViewModel = new ViewModelProvider(this).get(SolarCalculatorViewModel.class);
        solarCalculatorViewModel.getSpineNameValuePrices(handleResponses);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (solarCalculatorViewModel.getmApplicace().isEmpty() || solarCalculatorViewModel.getmApplicace() == null) {
            bind.setVariable(BR.empty, "List Empty");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bind.addAnApplianceBtn.setOnClickListener(view -> {
            if (solarCalculatorViewModel.getmApplicace().size() >= 7) {
                Toast.makeText(getActivity(), "Please select minimun 7", Toast.LENGTH_SHORT).show();
            } else {
                int pos = 0;
                insertApplianceWhenInWatt(pos);
            }
        });
        bind.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (solarCalculatorViewModel.getmApplicace().size() == 0) {
                    Toast.makeText(getActivity(), "You haven't added any appliance yet", Toast.LENGTH_SHORT).show();
                } else {
                    calc();
                }
            }
        });
    }

    private void insertApplianceWhenInWatt(int pos) {
        String aplName, aplWattage, aplQuantity;
        aplName = bind.applicanceName.getText().toString();
        aplWattage = bind.wattsOrHp.getText().toString();
        aplQuantity = bind.quantityOfDevices.getText().toString();
        if (aplName.isEmpty() || aplWattage.isEmpty() || aplQuantity.isEmpty()) {
            Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        solarCalculatorViewModel.InsertApplianceList(pos, aplName, aplWattage, aplQuantity);
        bind.setVariable(BR.dataList, solarCalculatorViewModel.getmApplicace());

        //mAdapter.notifyDataSetChanged();
        clearField();
    }


    private void clearField() {
        bind.applicanceName.setText("");
        bind.wattsOrHp.setText("");
        bind.quantityOfDevices.setText("");
      /*  bind.bettryValue = null;
        bind.InverterValue = null;
        bind.PlatesValue = null;*/
        bind.spinner1.setSelection(0);
        bind.spinner2.setSelection(0);
        bind.spinner3.setSelection(0);
    }


    private void calc() {
        for (Appliances appliance : solarCalculatorViewModel.getmApplicace()) {
            totalCalculate = totalCalculate + (Integer.parseInt(appliance.getmApplianceQuantity())
                    * Integer.parseInt(appliance.getmApplianceWattage()));
            totalLabour = totalLabour + (Integer.parseInt(appliance.getmApplianceWattage()));
        }
        totalLabour = totalLabour * 14;
        bind.setVariable(BR.totalWats,totalCalculate);
        bind.scrollable.setVisibility(View.GONE);
        bind.linearLayout.setVisibility(View.VISIBLE);

        // Helper.SHowToast(Solar_CalculatorActivity.this,""+totalCalculate);
        //startActivity(new Intent(Solar_CalculatorActivity.this,CalculateResultActivity.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        if (adapterView == bind.spinner1){
            if (i >0){
                bettryValue = Helper.spinnerItemSelected(i,bettrylist);
            }
        }else  if (adapterView == bind.spinner2){
            if (i>0){
                invervalue = Helper.spinnerItemSelected(i,inverterList);
            }

        }else{
            if (i>0){
                platevalue = Helper.spinnerItemSelected(i,platelist);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void getUserObject(User user) {

    }

    @Override
    public void ErrorMessage(String msj) {
        Log.d("ddd", "ErrorMessage: "+msj);
    }

    @Override
    public void HandleSpinerResponse(ArrayList<String> plates, ArrayList<String> betry, ArrayList<String> inverterss) {
        bettrylist = betry;
       platelist = plates;
       inverterList = inverterss;
        bettrylist.add(0, "Select:  =  3");
        adapter = new SpinerAdapter(getActivity(), bettrylist);
        bind.spinner1.setAdapter(adapter);
        inverterList.add(0, "Select: =  3");
        adapter = new SpinerAdapter(getActivity(), inverterList);
        bind.spinner2.setAdapter(adapter);
        plates.add(0, "Select: =  3");
        adapter = new SpinerAdapter(getActivity(), platelist);
        bind.spinner3.setAdapter(adapter);

    }
}