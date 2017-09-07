package com.sunzn.tangram.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.sunzn.tangram.library.bean.BaseViewBean;
import com.sunzn.tangram.library.interfaces.LoadMoreListener;
import com.sunzn.tangram.library.view.RecyclerCompatView;
import com.sunzn.tangram.sample.bean.Done;
import com.sunzn.tangram.sample.bean.Foot;
import com.sunzn.tangram.sample.bean.Head;
import com.sunzn.tangram.sample.bean.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerCompatView rv;
    private ArrayList<BaseViewBean> beans;
    private RecyclerAdapter adapter;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerCompatView) findViewById(R.id.rv);


        beans = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            beans.add(new Head());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Item());
        }
        for (int i = 0; i < 2; i++) {
            beans.add(new Foot());
        }
        for (int i = 0; i < 1; i++) {
            beans.add(new Head());
        }
        for (int i = 0; i < 9; i++) {
            beans.add(new Done());
        }
        for (int i = 0; i < 2; i++) {
            beans.add(new Foot());
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

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        rv.setLayoutManager(mLayoutManager);

        rv.setLayoutManager(new GridLayoutManager(this, 6));

        adapter = new RecyclerAdapter(beans);
        rv.setCompatAdapter(adapter);

        rv.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {

                if (x < 5) {

                    x++;

                    final ArrayList<Done> s = new ArrayList<Done>();

                    for (int i = 0; i < 9; i++) {
                        s.add(new Done());
                    }

                    rv.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rv.setLoadFinish(s);
                        }
                    }, 2000);


                } else {
                    rv.setTerminal();
                }

            }
        });
    }
    
}
