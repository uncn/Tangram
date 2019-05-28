package com.sunzn.tangram.library.helper;

import android.content.res.Resources;
import android.util.TypedValue;

public class SizeHelper {

    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

}
