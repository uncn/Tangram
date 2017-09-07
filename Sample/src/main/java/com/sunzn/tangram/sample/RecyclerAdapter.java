package com.sunzn.tangram.sample;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.sunzn.tangram.library.adapter.RecyclerWarpAdapter;
import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.library.bean.BaseViewBean;
import com.sunzn.tangram.library.interfaces.GridSpanSizeListener;
import com.sunzn.tangram.sample.holder.DoneViewHolder;
import com.sunzn.tangram.sample.holder.FootViewHolder;
import com.sunzn.tangram.sample.holder.HeadViewHolder;
import com.sunzn.tangram.sample.holder.ItemViewHolder;

import java.util.List;

/**
 * Created by sunzn on 2017/9/6.
 */

public class RecyclerAdapter extends RecyclerWarpAdapter implements GridSpanSizeListener {

    public RecyclerAdapter(List<BaseViewBean> beans) {
        super(beans);
        setSpanSizeListener(this);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(int viewType, View itemView) {
        switch (viewType) {
            case R.layout.head:
                return new HeadViewHolder(itemView);
            case R.layout.item:
                return new ItemViewHolder(itemView);
            case R.layout.foot:
                return new FootViewHolder(itemView);
            case R.layout.done:
                return new DoneViewHolder(itemView);
        }
        return null;
    }

    @Override
    public int onGetSpanCount(int viewType, GridLayoutManager manager) {
        switch (viewType) {
            case R.layout.head:
                return manager.getSpanCount();
            case R.layout.item:
                return manager.getSpanCount();
            case R.layout.foot:
                return 3;
            case R.layout.done:
                return 2;
        }
        return manager.getSpanCount();
    }

}
