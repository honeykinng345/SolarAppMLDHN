package com.learn.degger.solarappmldhn.utils;

import java.util.ArrayList;

public class Helper {

    public static String spinnerItemSelected(int position, ArrayList<String> list) {
        // code here
        //spinner1.getSelectedItem().toString();
        String    selectedSize=  list.get(position);
        String[] arr = selectedSize.split(" = ");
        String s = arr[1];
        //   Pattern pattern = Pattern.compile("[^0-9]");
        //String numberOnly = pattern.matcher(selectedSize).replaceAll("");
        // Toast.makeText(this, numberOnly, Toast.LENGTH_SHORT).show();

        return s;
    }
}
