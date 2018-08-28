package com.sunzn.tangram.sample.holder;

import android.util.Log;
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

    private final String TAG = "ItemViewHolder";

    public ItemViewHolder(final View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
        TextView view = getView(R.id.item_tv);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item:" + getAdapterPosition());
            }
        });
    }

    @Override
    public void onBindViewHolder(Item model, int position, RecyclerAdapter adapter) {
        TextView view = getView(R.id.item_tv);
        view.setText("item" + position);
    }

}
