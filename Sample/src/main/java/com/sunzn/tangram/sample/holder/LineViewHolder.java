package com.sunzn.tangram.sample.holder;

import android.view.View;

import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Line;

/**
 * Created by sunzn on 2017/10/17.
 */

public class LineViewHolder extends BaseViewHolder<Line, RecyclerAdapter> {

    public LineViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bindView(Line model, int position, RecyclerAdapter adapter) {

    }

}
