package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Foot;

/**
 * Created by sunzn on 2017/9/5.
 */

public class FootViewHolder extends TangramViewHolder<Foot, RecyclerAdapter> {

    private Context context;

    public FootViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
        context = itemView.getContext();
    }

    @Override
    public void onBindViewHolder(Foot model, int position, RecyclerAdapter adapter) {

        View holder = getView(R.id.foot_holder);
        holder.setPadding(20, 0, 20, 0);

        TextView view = getView(R.id.foot_tv);
        ImageView image = getView(R.id.foot_iv);
        view.setText("Foot item" + position);

        switch (position % 4) {
            case 0:
                Glide.with(context).load("http://e.bianke.cnki.net/Home/GetCorpusPic/20171130130559602_small_.jpg").into(image);
                break;
            case 1:
                Glide.with(context).load("http://e.bianke.cnki.net/Home/GetCorpusPic/20171018112722939_small_.jpg").into(image);
                break;
            case 2:
                Glide.with(context).load("http://e.bianke.cnki.net/Home/GetCorpusPic/20171106151140138_small_.jpg").into(image);
                break;
            case 3:
                Glide.with(context).load("http://e.bianke.cnki.net/Home/GetCorpusPic/20170825152648241_small_.jpg").into(image);
                break;
        }
    }

}
