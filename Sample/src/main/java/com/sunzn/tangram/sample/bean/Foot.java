package com.sunzn.tangram.sample.bean;

import com.sunzn.tangram.library.annotation.LayoutAnnotation;
import com.sunzn.tangram.library.bean.BaseViewBean;
import com.sunzn.tangram.sample.R;

/**
 * Created by sunzn on 2017/9/5.
 */

@LayoutAnnotation(R.layout.foot)
public class Foot extends BaseViewBean {

    private String name;
    private String pass;

}
