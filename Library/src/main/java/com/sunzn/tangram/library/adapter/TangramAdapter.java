package com.sunzn.tangram.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;

import com.sunzn.tangram.library.R;
import com.sunzn.tangram.library.annotation.LayoutAnnotation;
import com.sunzn.tangram.library.bean.TangramBean;
import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.library.holder.FootViewHolder;
import com.sunzn.tangram.library.interfaces.FooterClickListener;
import com.sunzn.tangram.library.interfaces.GridSpanSizeListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunzn on 2016/12/27.
 */

public abstract class TangramAdapter<T extends TangramBean> extends RecyclerView.Adapter<TangramViewHolder> implements View.OnClickListener {

    public abstract TangramViewHolder onCreateViewHolder(int viewType, View itemView);

    public static final int FOOT_STATE_LOAD = 0;
    public static final int FOOT_STATE_FAIL = 1;
    public static final int FOOT_STATE_DONE = 2;

    public static final int VIEW_TYPE_FOOT = -1;

    private int mCurFootState = FOOT_STATE_LOAD;

    private boolean isFootVisible = true;

    private List<T> mBeans;

    private GridSpanSizeListener mSpanSizeListener;

    private FooterClickListener mFooterClickListener;

    private ArrayList<Integer> mFoots = new ArrayList<>();

    private HashMap<Class, Integer> LayoutPool = new HashMap<>();

    public TangramAdapter() {
        super();
    }

    public TangramAdapter(List<T> beans) {
        mBeans = beans;
    }

    public void setData(List<T> beans) {
        mBeans = beans;
    }

    public void addData(List<T> beans) {
        if (beans != null && beans.size() > 0) {
            mBeans.addAll(beans);
        }
    }

    public T getItem(int position) {
        return mBeans.get(position);
    }

    public void setSpanSizeListener(GridSpanSizeListener listener) {
        mSpanSizeListener = listener;
    }

    public void setFooterClickListener(FooterClickListener listener) {
        mFooterClickListener = listener;
    }

    public void setFootStateLoad() {
        setFootVisible(true);
        setFootState(FOOT_STATE_LOAD);
    }

    public void setFootStateFail() {
        setFootVisible(true);
        setFootState(FOOT_STATE_FAIL);
    }

    public void setTerminal() {
        setFootVisible(true);
        setFootState(FOOT_STATE_DONE);
    }

    public void setFootState(int state) {
        mCurFootState = state;
    }

    public int getFootState() {
        return mCurFootState;
    }

    public void setFootVisible(boolean visible) {
        isFootVisible = visible;
    }

    public boolean isFootVisible() {
        return isFootVisible;
    }

    public int getFootCount() {
        return isFootVisible() && isFootUsable() ? 1 : 0;
    }

    public int getBeanCount() {
        return mBeans == null ? 0 : mBeans.size();
    }

    private boolean isFootUsable() {
        return mFoots != null && mFoots.size() == 3;
    }

    private void matchFootView(ViewAnimator animator, Context context, ViewGroup parent) {
        if (animator != null && context != null && parent != null && isFootUsable()) {
            for (int i = 0; i < mFoots.size(); i++) {
                animator.addView(LayoutInflater.from(context).inflate(mFoots.get(i), parent, false), i);
            }
        }
    }

    public void setFootViews(ArrayList<Integer> ids) {
        mFoots.clear();
        mFoots.addAll(ids);
    }

    @Override
    public void onClick(View view) {
        if (mFooterClickListener != null) mFooterClickListener.onFooterClick();
    }

    @NonNull
    @Override
    public TangramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType != VIEW_TYPE_FOOT) {
            Context context = parent.getContext();
            View itemView = LayoutInflater.from(context).inflate(viewType, parent, false);
            return onCreateViewHolder(viewType, itemView);
        } else {
            Context context = parent.getContext();
            View itemView = LayoutInflater.from(context).inflate(R.layout.foot_holder, parent, false);
            matchFootView((ViewAnimator) itemView, context, parent);
            itemView.setOnClickListener(this);
            return new FootViewHolder(itemView, this);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TangramViewHolder holder, int position) {
        if (position < getBeanCount()) {
            holder.onBindViewHolder(mBeans.get(position), position, this);
        } else {
            holder.onBindViewHolder(null, position, this);
        }
    }

    @Override
    public int getItemCount() {
        return getBeanCount() + getFootCount();
    }

    @Override
    public int getItemViewType(int position) {

        if (position < getBeanCount()) {
            Class<? extends TangramBean> clazz = mBeans.get(position).getClass();
            if (LayoutPool.get(clazz) != null) {
                return LayoutPool.get(clazz);
            } else {
                if (clazz.isAnnotationPresent(LayoutAnnotation.class)) {
                    LayoutAnnotation annotation = clazz.getAnnotation(LayoutAnnotation.class);
                    int value = annotation.value();
                    LayoutPool.put(clazz, value);
                    return value;
                } else {
                    throw new IllegalArgumentException(clazz.getName() + " should be declared by LayoutAnnotation to bind item layout.");
                }
            }
        } else {
            return VIEW_TYPE_FOOT;
        }

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager GridManager = (GridLayoutManager) manager;
            GridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position < getBeanCount()) {
                        return mSpanSizeListener == null ? 1 : mSpanSizeListener.onGetSpanCount(getItemViewType(position), GridManager);
                    } else {
                        return GridManager.getSpanCount();
                    }
                }
            });
        }
    }

}
