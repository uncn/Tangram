package com.sunzn.tangram.sample.holder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sunzn.tangram.library.holder.TangramViewHolder;
import com.sunzn.tangram.sample.R;
import com.sunzn.tangram.sample.RecyclerAdapter;
import com.sunzn.tangram.sample.bean.Head;

/**
 * Created by sunzn on 2017/9/5.
 */

public class HeadViewHolder extends TangramViewHolder<Head, RecyclerAdapter> {

    private Context context;

    public HeadViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
        context = itemView.getContext();
        RelativeLayout holder = (RelativeLayout) getView(R.id.head_holder);
        holder.setOnClickListener(new OnViewClickListener(adapter));
    }

    @Override
    public void onBindViewHolder(Head model, final int position, RecyclerAdapter adapter) {
        TextView view = (TextView) getView(R.id.head_tv);
        view.setText(model.getName());

        RelativeLayout holder = (RelativeLayout) getView(R.id.head_holder);
        holder.setTag(position);
    }

    class OnViewClickListener implements View.OnClickListener {

        private RecyclerAdapter mAdapter;

        private OnViewClickListener(RecyclerAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Head-" + (int) v.getTag(), Toast.LENGTH_SHORT).show();
        }

    }

}
