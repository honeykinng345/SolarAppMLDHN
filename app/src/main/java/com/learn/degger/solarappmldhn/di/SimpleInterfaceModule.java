package com.learn.degger.solarappmldhn.di;
import com.learn.degger.solarappmldhn.interfacs.ClickListner;
import com.learn.degger.solarappmldhn.ui.fragments.SolarCalculatorFragment;
import com.learn.degger.solarappmldhn.utils.InteraceClickHandle;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class SimpleInterfaceModule {

    /* @Binds
     public abstract ClickListner clickListner(SolarCalculatorFragment  interaceClickHandle);*/
}
