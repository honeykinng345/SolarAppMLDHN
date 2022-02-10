package com.learn.degger.solarappmldhn.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.learn.degger.solarappmldhn.BR;
import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.databinding.ApplianceLayoutBindingImpl;
import com.learn.degger.solarappmldhn.interfacs.ClickListner;
import com.learn.degger.solarappmldhn.ui.fragments.SolarCalculatorFragment;
import com.learn.degger.solarappmldhn.utils.Appliances;

import java.util.ArrayList;
import java.util.List;


public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.CalculatorViewHolder> implements ClickListner{

    //Generals
    private ArrayList<Appliances> mAppliances;
    private Context context;

    public CalculatorAdapter(ArrayList<Appliances> mAppliances, Context context) {
        this.mAppliances = mAppliances;
        this.context = context;
    }

    @NonNull
    @Override
    public CalculatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        // by using gnrated classes of data binding
   /*     ApplianceLayoutBindingImpl binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.appliance_layout, parent, false);*/

        ViewDataBinding binding = ApplianceLayoutBindingImpl.inflate(LayoutInflater.from(context),parent,false);
        return new CalculatorViewHolder(binding);
    }



    @Override
    public void onBindViewHolder(@NonNull CalculatorViewHolder holder, int position) {
     Appliances appliances = mAppliances.get(position);


     holder.bind(appliances);
      holder.itemRowBinding.setVariable(BR.listner,this);
      holder.itemRowBinding.setVariable(BR.position,position);
    }
    @Override
    public int getItemCount() {
        return mAppliances.size();
    }

    @Override
    public void getPro(Appliances appliances,int pos) {
       //
        mAppliances.remove(appliances);
        notifyItemRemoved(pos);

    }

    //This is a public static inner class for our ViewHolder
    public static class CalculatorViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding itemRowBinding;
        public CalculatorViewHolder(@NonNull ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemRowBinding = itemView;

        }
        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.appliance, obj);
            itemRowBinding.executePendingBindings();
        }
    }

    public  void UpdateData(ArrayList<Appliances> listss, int i){
        this.mAppliances = listss;
        notifyDataSetChanged();
    }
}