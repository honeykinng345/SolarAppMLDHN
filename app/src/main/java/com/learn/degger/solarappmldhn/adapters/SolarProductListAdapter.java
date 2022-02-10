package com.learn.degger.solarappmldhn.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.learn.degger.solarappmldhn.BR;
import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.databinding.ApplianceLayoutBindingImpl;
import com.learn.degger.solarappmldhn.databinding.ItemSolarShopBinding;
import com.learn.degger.solarappmldhn.models.FetchAllSolarProductList;

import java.util.ArrayList;


public class SolarProductListAdapter extends  RecyclerView.Adapter<SolarProductListAdapter.ViewHolder>  {

    ArrayList<FetchAllSolarProductList> productLists;
    Context context;


    public SolarProductListAdapter(ArrayList<FetchAllSolarProductList> productLists, Context context) {
        this.productLists = productLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = ItemSolarShopBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FetchAllSolarProductList modelProduct = productLists.get(position);
        holder.bind(modelProduct);

    }



    @Override
    public int getItemCount() {
        return productLists.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding itemRowBinding;
        public ViewHolder(@NonNull ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemRowBinding = itemView;

        }
        public void bind(Object obj) {

            itemRowBinding.setVariable(BR.solarPro, obj);
            itemRowBinding.executePendingBindings();
        }
    }

}
