package com.sunzn.tangram.library.holder;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.sunzn.tangram.library.adapter.TangramAdapter;
import com.sunzn.tangram.library.bean.TangramBean;

/**
 * Created by sunzn on 2017/9/5.
 */

public abstract class TangramViewHolder<T1 extends TangramBean, T2 extends TangramAdapter> extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public TangramViewHolder(View itemView, T2 adapter) {
        super(itemView);
        mViews = new SparseArray<>();
        this.mItemView = itemView;
    }

    public <T extends View> T getView(@IdRes int resID) {
        View view = mViews.get(resID);

        if (view == null) {
            view = mItemView.findViewById(resID);
            mViews.put(resID, view);
        }

        return (T) view;
    }

    public abstract void onBindViewHolder(T1 model, int position, T2 adapter);

}
