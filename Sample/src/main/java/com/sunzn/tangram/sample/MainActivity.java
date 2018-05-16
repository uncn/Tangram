package com.sunzn.tangram.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.sunzn.tangram.library.bean.BaseViewBean;
import com.sunzn.tangram.library.interfaces.FooterClickListener;
import com.sunzn.tangram.library.interfaces.LoadMoreListener;
import com.sunzn.tangram.library.view.RecyclerCompatView;
import com.sunzn.tangram.sample.bean.Done;
import com.sunzn.tangram.sample.bean.Foot;
import com.sunzn.tangram.sample.bean.Head;
import com.sunzn.tangram.sample.bean.Item;
import com.sunzn.tangram.sample.bean.Line;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerCompatView rv;
    private ArrayList<BaseViewBean> beans;
    private RecyclerAdapter adapter;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);


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
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Head("知网书"));
        }
        for (int i = 0; i < 4; i++) {
            beans.add(new Foot());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Line());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }

//        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setLayoutManager(new GridLayoutManager(this, 6));

        adapter = new RecyclerAdapter(beans);


        adapter.setFooterClickListener(new FooterClickListener() {
            @Override
            public void onFooterClick() {
                rv.setLoading();
                loadData();
            }
        });


        rv.setCompatAdapter(adapter);

        rv.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {

                if (x < 5) {
                    loadData();
                } else {
                    rv.setClosure();
                    Log.i("Tangram", "x ================================================== " + x);
                }

            }
        });

    }

    private void loadData() {

        final ArrayList<BaseViewBean> s = new ArrayList<>();

        Random random = new java.util.Random();
        int result = random.nextInt(10);

        if (result % 3 == 0) {
            for (int i = 0; i < 9; i++) {
                s.add(new Done());
            }
        } else {
            for (int i = 0; i < 6; i++) {
                s.add(new Foot());
            }
        }

        rv.postDelayed(new Runnable() {
            @Override
            public void run() {

                Random random = new java.util.Random();
                int result = random.nextInt(10);

                Log.i("Tangram", "i ======================================================================== " + result);

                if (result % 3 == 0) {
                    rv.setFailure();
                } else {
                    rv.setSuccess(s);
                    x++;
                }
            }
        }, 1000);

    }

}
