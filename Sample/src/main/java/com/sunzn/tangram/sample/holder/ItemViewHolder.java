package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Item;

/**
 * Created by sunzn on 2017/9/5.
 */

public class ItemViewHolder extends BaseViewHolder<Item, RecyclerAdapter> {

    public ItemViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bindView(Item model, int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.item_tv);
        view.setText("item" + position);
    }

}
