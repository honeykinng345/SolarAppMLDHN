package com.learn.degger.solarappmldhn.databindingadapters;

import android.graphics.Paint;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.degger.solarappmldhn.adapters.CalculatorAdapter;
import com.learn.degger.solarappmldhn.utils.Appliances;

import java.util.ArrayList;
import java.util.List;

public class BindingAdapters {

    @BindingAdapter("BindList")
    public static void bindRecyelerViewList(RecyclerView recyclerView, ArrayList<Appliances> dataList){

        if (dataList == null){
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager == null){
            layoutManager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(layoutManager);
        }

        CalculatorAdapter calculatorAdapter = (CalculatorAdapter) recyclerView.getAdapter();
        if (calculatorAdapter == null){
            calculatorAdapter  = new CalculatorAdapter(dataList,recyclerView.getContext());
            recyclerView.setAdapter(calculatorAdapter);

        }
        else{
            int i =0;
           calculatorAdapter.UpdateData(dataList,i);
             i = i+1;
        }


    }

    @BindingAdapter("strikeThrough")
    public static void strikeThrough(TextView textView, Boolean strikeThrough) {
        if (strikeThrough) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            textView.setPaintFlags(textView.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @BindingAdapter("BindSolarpartsList")
    public static void bindRecyelerSolarPartList(RecyclerView recyclerView, ArrayList<Appliances> dataList){

        if (dataList == null){
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager == null){
            layoutManager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(layoutManager);
        }

        CalculatorAdapter calculatorAdapter = (CalculatorAdapter) recyclerView.getAdapter();
        if (calculatorAdapter == null){
            calculatorAdapter  = new CalculatorAdapter(dataList,recyclerView.getContext());
            recyclerView.setAdapter(calculatorAdapter);

        }



    }



}
