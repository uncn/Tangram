package com.sunzn.tangram.sample.bean;

import com.sunzn.tangram.library.annotation.LayoutAnnotation;
import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.sample.RecyclerAdapter;

/**
 * Created by sunzn on 2017/9/5.
 */

@LayoutAnnotation(RecyclerAdapter.ITEM_DONE)
public class Done extends Base {

    private String name;
    private String pass;

    public Done(Border border) {
        super(border);
    }

}
