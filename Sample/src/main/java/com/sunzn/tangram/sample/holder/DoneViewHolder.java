package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Done;

/**
 * Created by sunzn on 2017/9/5.
 */

public class DoneViewHolder extends TangramViewHolder<Done, RecyclerAdapter> {

    private Context context;

    public DoneViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
        context = itemView.getContext();
    }

    @Override
    public void onBindViewHolder(Done model, int position, RecyclerAdapter adapter) {

        View holder = getView(R.id.done_holder);

        Border border = model.getBorder();

        if (border.isInRange(position)) {
            int spanCount = 3;
            int hSpacing = 40;
            int vSpacing = 15;
            int column = (position - border.getLower()) % spanCount;
            holder.setPadding(hSpacing - column * hSpacing / spanCount, vSpacing, (column + 1) * hSpacing / spanCount, vSpacing);
        }

        TextView view = getView(R.id.done_tv);
        view.setText("item" + position);

        ImageView image = getView(R.id.done_iv);
        switch (position % 9) {
            case 0:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/JJZK/JJZK201739.jpg").into(image);
                break;
            case 1:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/JJZK/JJZK201742.jpg").into(image);
                break;
            case 2:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/JJZK/JJZK201744.jpg").into(image);
                break;
            case 3:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/WMIA/WMIA201779.jpg").into(image);
                break;
            case 4:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/FAIZ/FAIZ201710.jpg").into(image);
                break;
            case 5:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/XDFL/XDFL201710.jpg").into(image);
                break;
            case 6:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/GJRZ/GJRZ201708.jpg").into(image);
                break;
            case 7:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/HQDL/HQDL201313.jpg").into(image);
                break;
            case 8:
                Glide.with(context).load("http://c61.cnki.net/CJFD/big/NBAT/NBAT201209.jpg").into(image);
                break;
        }
    }

}
