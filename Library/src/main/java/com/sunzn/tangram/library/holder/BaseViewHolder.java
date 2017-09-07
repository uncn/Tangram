package com.sunzn.tangram.library.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.sunzn.tangram.library.adapter.RecyclerWarpAdapter;
import com.sunzn.tangram.library.bean.BaseViewBean;

/**
 * Created by sunzn on 2017/9/5.
 */

public abstract class BaseViewHolder<T1 extends BaseViewBean, T2 extends RecyclerWarpAdapter> extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        this.mItemView = itemView;
    }

    public View getView(int resID) {
        View view = mViews.get(resID);

        if (view == null) {
            view = mItemView.findViewById(resID);
            mViews.put(resID, view);
        }

        return view;
    }

    public abstract void setUpView(T1 model, int position, T2 adapter);

}
