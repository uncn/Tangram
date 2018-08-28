package com.sunzn.tangram.sample.bean;

import com.sunzn.tangram.library.annotation.LayoutAnnotation;
import com.sunzn.tangram.library.bean.TangramBean;
import com.sunzn.tangram.sample.R;

/**
 * Created by sunzn on 2017/9/5.
 */

@LayoutAnnotation(R.layout.item_head)
public class Head extends TangramBean {

    private String name;
    private String pass;

    public Head() {
        super();
    }

    public Head(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
