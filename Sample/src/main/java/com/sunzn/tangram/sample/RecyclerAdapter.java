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

    public static final int ITEM_HEAD = R.layout.item_head;
    public static final int ITEM_ITEM = R.layout.item;
    public static final int ITEM_FOOT = R.layout.foot;
    public static final int ITEM_DONE = R.layout.done;
    public static final int ITEM_LINE = R.layout.line;

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
            case ITEM_HEAD:
                return new HeadViewHolder(itemView, this);
            case ITEM_ITEM:
                return new ItemViewHolder(itemView, this);
            case ITEM_FOOT:
                return new FootViewHolder(itemView, this);
            case ITEM_DONE:
                return new DoneViewHolder(itemView, this);
            case ITEM_LINE:
                return new LineViewHolder(itemView, this);
        }
        return null;
    }

    @Override
    public int onGetSpanCount(int viewType, GridLayoutManager manager) {
        switch (viewType) {
            case ITEM_HEAD:
                return manager.getSpanCount();
            case ITEM_ITEM:
                return manager.getSpanCount();
            case ITEM_FOOT:
                return manager.getSpanCount() / 2;
            case ITEM_DONE:
                return manager.getSpanCount() / 3;
            case ITEM_LINE:
                return manager.getSpanCount();
        }
        return manager.getSpanCount();
    }

}
