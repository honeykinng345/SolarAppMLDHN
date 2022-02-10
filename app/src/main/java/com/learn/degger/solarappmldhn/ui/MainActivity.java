package com.learn.degger.solarappmldhn.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.learn.degger.solarappmldhn.MainNavDirections;
import com.learn.degger.solarappmldhn.R;
import com.learn.degger.solarappmldhn.databinding.ActivityMainBinding;
import com.learn.degger.solarappmldhn.interfacs.ClickListner;
import com.learn.degger.solarappmldhn.utils.Appliances;
import com.learn.degger.solarappmldhn.utils.InteraceClickHandle;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavController navController;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            setContentView(binding.getRoot());
        }
        binding.bottomNav.setBackground(null);
        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        final NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomNav, navController);

        //   NavigationUI.setupActionBarWithNavController(this, navController);
        binding.bottomNav.getMenu().getItem(2).setEnabled(false);
        //  binding.bottomNav.


/*        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case 0:
                        navController.navigate(R.id.homeFragment);
                        return true;
                    case 1:
                        navController.navigate(R.id.solarCalculatorFragment);
                        return true;
                    case 2:
                        navController.navigate(R.id.solarCalculatorFragment);
                        return true;
                }
                return  false;
            }
        });*/
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
                NavDirections navDirections = MainNavDirections.actionGlobalGlobalFragment();
                navController.navigate(navDirections);
            }
        });

    }

    public void AddMemberbtn(View view) {

    }
}