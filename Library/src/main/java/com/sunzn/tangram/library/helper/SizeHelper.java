package com.sunzn.tangram.library.helper;

import android.content.Context;

public class SizeHelper {

    public static int dp2px(Context context, int dp) {
        return (int) (getDensity(context) * dp + 0.5);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

}
