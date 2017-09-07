package com.sunzn.tangram.library.interfaces;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by sunzn on 2017/9/5.
 */

public interface GridSpanSizeListener {

    int onGetSpanCount(int viewType, GridLayoutManager manager);

}
