package com.sunzn.tangram.sample;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.sunzn.tangram.library.adapter.TangramAdapter;
import com.sunzn.tangram.library.bean.TangramBean;
import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.library.interfaces.GridSpanSizeListener;
import com.sunzn.tangram.sample.holder.DoneViewHolder;
import com.sunzn.tangram.sample.holder.FootViewHolder;
import com.sunzn.tangram.sample.holder.HeadViewHolder;
import com.sunzn.tangram.sample.holder.ItemViewHolder;
import com.sunzn.tangram.sample.holder.LineViewHolder;

import java.util.List;

/**
 * Created by sunzn on 2017/9/6.
 */

public class RecyclerAdapter extends TangramAdapter implements GridSpanSizeListener {

    public RecyclerAdapter() {
        super();
        setSpanSizeListener(this);
    }

    public RecyclerAdapter(List<TangramBean> beans) {
        super(beans);
        setSpanSizeListener(this);
    }

    @Override
    public TangramViewHolder onCreateViewHolder(int viewType, View itemView) {
        switch (viewType) {
            case R.layout.item_head:
                return new HeadViewHolder(itemView, this);
            case R.layout.item:
                return new ItemViewHolder(itemView, this);
            case R.layout.foot:
                return new FootViewHolder(itemView, this);
            case R.layout.done:
                return new DoneViewHolder(itemView, this);
            case R.layout.line:
                return new LineViewHolder(itemView, this);
        }
        return null;
    }

    @Override
    public int onGetSpanCount(int viewType, GridLayoutManager manager) {
        switch (viewType) {
            case R.layout.item_head:
                return manager.getSpanCount();
            case R.layout.item:
                return manager.getSpanCount();
            case R.layout.foot:
                return 3;
            case R.layout.done:
                return 2;
            case R.layout.line:
                return manager.getSpanCount();
        }
        return manager.getSpanCount();
    }

}
