package com.learn.degger.solarappmldhn.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.adapters.SolarProductListAdapter;
import com.learn.degger.solarappmldhn.buttonclick.ButtonClickHandle;
import com.learn.degger.solarappmldhn.databinding.FragmentHomeBindingImpl;
import com.learn.degger.solarappmldhn.databinding.FragmentSolarPartsBinding;
import com.learn.degger.solarappmldhn.models.FetchAllSolarProductList;
import com.learn.degger.solarappmldhn.viewmodel.SolarCalculatorViewModel;
import com.learn.degger.solarappmldhn.viewmodel.SolarShopingPartViewModel;

import java.util.ArrayList;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SolarPartShoopingFragments extends Fragment {
    private FragmentSolarPartsBinding bind;
    private SolarShopingPartViewModel solarShopingPartViewModel;
    SolarProductListAdapter solarProductListAdapter;
    private ArrayList<FetchAllSolarProductList> currentMovies, popularMovies, topRatedMovies, upcomingMovies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentMovies = new ArrayList<>();
        if (bind == null) {
            bind = DataBindingUtil.inflate(inflater, R.layout.fragment_solar_parts, container, false);
        }
        //bind.setLifecycleOwner(getViewLifecycleOwner());
        View view = bind.getRoot();
        solarShopingPartViewModel = new ViewModelProvider(this).get(SolarShopingPartViewModel.class);

        initRecyelerview();
        observeData();
        solarShopingPartViewModel.getCurrentlyShowingMovies();
        return view;
    }

    private void initRecyelerview() {
        bind.solarPArtsRv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        bind.solarPArtsRv.setLayoutManager(linearLayoutManager);
    }

    private void setUpRecyclerViewsAndViewPager() {
        bind.solarPArtsRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        solarProductListAdapter = new SolarProductListAdapter(solarShopingPartViewModel.fetchAllSolarProductLists, getContext());
        bind.solarPArtsRv.setAdapter(solarProductListAdapter);
    }

    private void observeData() {
         /* solarShopingPartViewModel.getSolarProductList().observe(getViewLifecycleOwner(), new Observer<ArrayList<FetchAllSolarProductList>>() {
            @Override
            public void onChanged(ArrayList<FetchAllSolarProductList> movies) {
                solarProductListAdapter.setMoviesList(movies);
            }
        });*/

        Observer<ArrayList<FetchAllSolarProductList>> notesObserver = notes -> {
            currentMovies.clear();
            currentMovies.addAll(notes);
            if (solarProductListAdapter == null) {
                if (currentMovies != null) {
                    solarProductListAdapter = new SolarProductListAdapter(currentMovies, getActivity());
                    bind.solarPArtsRv.setAdapter(solarProductListAdapter);

                } else {
                    Toast.makeText(getActivity(), "" + "empty", Toast.LENGTH_SHORT).show();
                }
            } else {
                solarProductListAdapter.notifyDataSetChanged();
            }
        };

        solarShopingPartViewModel.getSolarProductList().observe(requireActivity(), notesObserver);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}