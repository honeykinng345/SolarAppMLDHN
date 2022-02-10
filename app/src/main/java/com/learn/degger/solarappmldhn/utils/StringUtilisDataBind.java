package com.learn.degger.solarappmldhn.utils;

import android.graphics.Paint;
import android.widget.TextView;

public class StringUtilisDataBind {

    public static String getPrice (String price){
        return ""+price+"%"+""+"OFF";
    }

    public  static  void SetPaintFlag(TextView textView,String discountAvalibale){
      textView.setPaintFlags(textView.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);


    }
}
