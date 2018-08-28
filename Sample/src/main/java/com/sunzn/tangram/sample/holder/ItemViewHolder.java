package com.sunzn.tangram.sample.holder;

import android.view.View;
import android.widget.TextView;

import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Item;

/**
 * Created by sunzn on 2017/9/5.
 */

public class ItemViewHolder extends TangramViewHolder<Item, RecyclerAdapter> {

    public ItemViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bindView(Item model, int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.item_tv);
        view.setText("item" + position);
    }

}
