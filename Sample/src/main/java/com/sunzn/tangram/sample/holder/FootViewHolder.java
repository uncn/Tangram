package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Foot;

/**
 * Created by sunzn on 2017/9/5.
 */

public class FootViewHolder extends BaseViewHolder<Foot, RecyclerAdapter> {

    private Context context;

    public FootViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void setUpView(Foot model, int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.foot_tv);
        ImageView image = (ImageView) getView(R.id.foot_iv);
        view.setText("Foot item" + position);


        Glide.with(context).load("http://c61.cnki.net/CJFD/big/CWSJ/CWSJ201707.jpg").placeholder(R.mipmap.ic_launcher).into(image);
    }

}
