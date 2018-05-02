package com.example.ikhsanlaisa.insylapps;

import android.content.Context;
import android.util.DisplayMetrics;

import com.google.gson.Gson;

/**
 * Created by alfianh on 4/5/17.
 */

public class Utils {
    public static int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public static String parsingObjestToString(Object o){
        Gson gson = new Gson();
        String parsing = gson.toJson(o);
        return parsing;
    }

    public static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
