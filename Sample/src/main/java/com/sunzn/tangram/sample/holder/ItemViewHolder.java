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

    private Context context;

    public ItemViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void setUpView(Item model, int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.item_tv);
        view.setText("item" + position);

        ImageView image = (ImageView) getView(R.id.item_iv);
        Glide.with(context).load("http://c61.cnki.net/CJFD/big/YLYL/YLYL201523.jpg").placeholder(R.mipmap.ic_launcher).into(image);
    }

}
