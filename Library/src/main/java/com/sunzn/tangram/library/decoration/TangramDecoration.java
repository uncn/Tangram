package com.sunzn.tangram.library.decoration;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class TangramDecoration extends RecyclerView.ItemDecoration {

    public abstract void onDecoration(@NonNull Rect outRect, int position);

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        onDecoration(outRect, position);
    }

}
