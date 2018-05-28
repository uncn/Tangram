package com.sunzn.tangram.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.sunzn.tangram.library.R;
import com.sunzn.tangram.library.adapter.RecyclerWarpAdapter;
import com.sunzn.tangram.library.bean.BaseViewBean;
import com.sunzn.tangram.library.interfaces.LoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzn on 2017/9/5.
 */

public class RecyclerCompatView extends RecyclerView {

    private boolean hasMore = true;
    private boolean isProcess = false;
    private RecyclerWarpAdapter mAdapter;
    private LoadMoreListener mLoadMoreListener;
    private ArrayList<Integer> mFootViewIDs = new ArrayList<>();

    public RecyclerCompatView(Context context) {
        this(context, null);
    }

    public RecyclerCompatView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerCompatView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RecyclerCompatView);
        int mFooterLoadView = typedArray.getResourceId(R.styleable.RecyclerCompatView_FooterLoad, -1);
        int mFooterFailView = typedArray.getResourceId(R.styleable.RecyclerCompatView_FooterFail, -1);
        int mFooterDoneView = typedArray.getResourceId(R.styleable.RecyclerCompatView_FooterDone, -1);

        if (mFooterLoadView != -1) mFootViewIDs.add(mFooterLoadView);
        if (mFooterFailView != -1) mFootViewIDs.add(mFooterFailView);
        if (mFooterDoneView != -1) mFootViewIDs.add(mFooterDoneView);

        typedArray.recycle();
    }

    public <T extends RecyclerWarpAdapter> void setCompatAdapter(T adapter) {
        adapter.setFootViews(mFootViewIDs);
        setAdapter(adapter);
        mAdapter = adapter;
    }

    public <T extends BaseViewBean> void setSuccess(List<T> beans) {
        mAdapter.addData(beans);
        getAdapter().notifyDataSetChanged();
        setProcess(false);
    }

    public void setLoading() {
        setHasMore(true);
        setProcess(true);
        mAdapter.setFootStateLoad();
        getAdapter().notifyDataSetChanged();
    }

    public void setFailure() {
        setProcess(true);
        mAdapter.setFootStateFail();
        getAdapter().notifyDataSetChanged();
    }

    public void setClosure() {
        setHasMore(false);
        setProcess(false);
        mAdapter.setTerminal();
        getAdapter().notifyDataSetChanged();
    }

    public void setHasMore(boolean more) {
        hasMore = more;
    }

    public void setProcess(boolean process) {
        isProcess = process;
    }

    public void setLoadMoreListener(LoadMoreListener listener) {
        mLoadMoreListener = listener;
        initScrollListener();
    }

    private void initScrollListener() {
        if (mFootViewIDs != null && mFootViewIDs.size() == 3) {
            this.addOnScrollListener(new OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (hasMore) {
                        LayoutManager manager = getLayoutManager();
                        int end, total;
                        end = ((LinearLayoutManager) manager).findLastVisibleItemPosition();
                        total = getAdapter().getItemCount();

                        Log.e("Tangram", "end = " + end + "--------- tot = " + total + "--------- isProcess = " + isProcess);

                        if (mLoadMoreListener != null && !isProcess && end >= total - 1) {
                            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                                isProcess = true;
                                mLoadMoreListener.onLoadMore();
                            }
                        }
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
        } else {
            throw new IllegalArgumentException("init ScrollListener must set FooterLoad, FooterFail, FooterDone attribute");
        }
    }

}
