package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Done;

/**
 * Created by sunzn on 2017/9/5.
 */

public class DoneViewHolder extends BaseViewHolder<Done, RecyclerAdapter> {

    private Context context;

    public DoneViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void setUpView(Done model, int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.done_tv);
        view.setText("item" + position);

        ImageView image = (ImageView) getView(R.id.done_iv);
        Glide.with(context).load("http://c61.cnki.net/CJFD/big/CWSJ/CWSJ201707.jpg").placeholder(R.mipmap.ic_launcher).into(image);
    }

}
