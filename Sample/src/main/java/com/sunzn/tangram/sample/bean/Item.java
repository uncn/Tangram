package com.sunzn.tangram.sample.bean;


import com.sunzn.tangram.library.annotation.LayoutAnnotation;
import com.sunzn.tangram.library.bean.TangramBean;
import com.sunzn.tangram.sample.R;

/**
 * Created by sunzn on 2017/9/5.
 */

@LayoutAnnotation(R.layout.item)
public class Item extends TangramBean {

    private String name;
    private String pass;

}
