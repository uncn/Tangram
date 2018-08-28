package com.sunzn.tangram.library.holder;

import android.view.View;
import android.widget.ViewAnimator;

import com.sunzn.tangram.library.adapter.TangramAdapter;
import com.sunzn.tangram.library.bean.TangramBean;

import static com.sunzn.tangram.library.adapter.TangramAdapter.FOOT_STATE_DONE;
import static com.sunzn.tangram.library.adapter.TangramAdapter.FOOT_STATE_FAIL;
import static com.sunzn.tangram.library.adapter.TangramAdapter.FOOT_STATE_LOAD;

/**
 * Created by sunzn on 2017/9/6.
 */

public class FootViewHolder extends TangramViewHolder {

    public FootViewHolder(View itemView, TangramAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void onBindViewHolder(TangramBean model, int position, TangramAdapter adapter) {
        switch (adapter.getFootState()) {
            case FOOT_STATE_LOAD:
                itemView.setClickable(false);
                ((ViewAnimator) itemView).setDisplayedChild(FOOT_STATE_LOAD);
                break;
            case FOOT_STATE_FAIL:
                itemView.setClickable(true);
                ((ViewAnimator) itemView).setDisplayedChild(FOOT_STATE_FAIL);
                break;
            case FOOT_STATE_DONE:
                itemView.setClickable(false);
                ((ViewAnimator) itemView).setDisplayedChild(FOOT_STATE_DONE);
                break;
        }
    }

}
