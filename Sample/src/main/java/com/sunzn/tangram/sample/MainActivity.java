package com.sunzn.tangram.sample;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.library.bean.TangramBean;
import com.sunzn.tangram.library.interfaces.FooterClickListener;
import com.sunzn.tangram.library.interfaces.LoadMoreListener;
import com.sunzn.tangram.library.view.TangramView;
import com.sunzn.tangram.sample.bean.Done;
import com.sunzn.tangram.sample.bean.Foot;
import com.sunzn.tangram.sample.bean.Head;
import com.sunzn.tangram.sample.bean.Item;
import com.sunzn.tangram.sample.bean.Line;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TangramView tangram;
    private ArrayList<TangramBean> beans;
    private RecyclerAdapter adapter;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tangram = findViewById(R.id.tangram);


        beans = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Head("今日快讯"));
        }
        for (int i = 0; i < 5; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Head("期刊"));
        }


        Log.e("TAGGG", "size" + beans.size());

        Border border = new Border(beans.size(), beans.size() + 10);

        for (int i = 0; i < 10; i++) {
            beans.add(new Done(border));
        }

        Log.e("TAGGG", "size" + beans.size());

        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Head("知网书"));
        }

        Border border1 = new Border(beans.size(), beans.size() + 10);
        for (int i = 0; i < 4; i++) {
            beans.add(new Foot(border1));
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }

        Border border2 = new Border(beans.size(), beans.size() + 9);
        for (int i = 0; i < 9; i++) {
            beans.add(new Done(border2));
        }

        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }

        Border border3 = new Border(beans.size(), beans.size() + 9);
        for (int i = 0; i < 9; i++) {
            beans.add(new Done(border3));
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
//        for (int i = 0; i < 9; i++) {
//            beans.add(new Done());
//        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
//        for (int i = 0; i < 9; i++) {
//            beans.add(new Done());
//        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
//        for (int i = 0; i < 9; i++) {
//            beans.add(new Done());
//        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
//        for (int i = 0; i < 9; i++) {
//            beans.add(new Done());
//        }

//        rv.setLayoutManager(new LinearLayoutManager(this));

        tangram.setLayoutManager(new GridLayoutManager(this, 6));

//        adapter = new RecyclerAdapter(beans);

        adapter = new RecyclerAdapter();
        adapter.setData(beans);

        adapter.setFooterClickListener(new FooterClickListener() {
            @Override
            public void onFooterClick() {
                tangram.setLoading();
                loadData();
            }
        });

        tangram.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = parent.getChildAdapterPosition(view);
                switch (adapter.getItemViewType(position)) {

                    case R.layout.done:
//                        Point point = ((Base) adapter.getItem(position)).getPoint();
//                        if (position >= point.x && position < point.y) {
//                            int spanCount = 3;
//                            int hSpacing = 40;
//                            int vSpacing = 15;
//                            int column = (position - point.x) % spanCount;
//                            outRect.left = hSpacing - column * hSpacing / spanCount;
//                            outRect.right = (column + 1) * hSpacing / spanCount;
////                            if (position < spanCount) {
//                            outRect.top = vSpacing;
////                            }
//                            outRect.bottom = vSpacing;
//                        }
                        break;
                    case R.layout.foot:
//                        Point pointFoot = ((Base) adapter.getItem(position)).getPoint();
//                        if (position >= pointFoot.x && position < pointFoot.y) {
//                            int spanCount = 2;
//                            int hSpacing = 40;
//                            int vSpacing = 15;
//                            int column = (position - pointFoot.x) % spanCount;
//                            outRect.left = hSpacing - column * hSpacing / spanCount;
//                            outRect.right = (column + 1) * hSpacing / spanCount;
////                            if (position < spanCount) {
//                            outRect.top = vSpacing;
////                            }
//                            outRect.bottom = vSpacing;
//                        }
                        break;
                    default:
                        outRect.left = 0;
                        outRect.right = 0;
                        outRect.bottom = 0;
                        outRect.top = 0;
                        break;

                }
            }
        });

        tangram.setCompatAdapter(adapter);

        tangram.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {

                if (x < 5) {
                    loadData();
                } else {
                    tangram.setClosure();
                    Log.i("Tangram", "x ================================================== " + x);
                }

            }
        });

    }

    private void loadData() {

        final ArrayList<TangramBean> s = new ArrayList<>();

        Random random = new java.util.Random();
        int result = random.nextInt(10);

        if (result % 3 == 0) {
            Border border = new Border(beans.size(), beans.size() + 9);
            for (int i = 0; i < 9; i++) {
                s.add(new Done(border));
            }
        } else {
            Border border = new Border(beans.size(), beans.size() + 6);
            for (int i = 0; i < 6; i++) {
                s.add(new Foot(border));
            }
        }

        tangram.postDelayed(new Runnable() {
            @Override
            public void run() {

                Random random = new java.util.Random();
                int result = random.nextInt(10);

                Log.i("Tangram", "i ======================================================================== " + result);

                if (result % 3 == 0) {
                    tangram.setFailure();
                } else {
                    tangram.setSuccess(s);
                    x++;
                }
            }
        }, 1000);

    }

}
