package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sunzn.tangram.library.holder.BaseViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Head;

/**
 * Created by sunzn on 2017/9/5.
 */

public class HeadViewHolder extends BaseViewHolder<Head, RecyclerAdapter> {

    private Context context;

    public HeadViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void setUpView(Head model, final int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.item_tv);
        view.setText("Head item" + position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Head-" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
