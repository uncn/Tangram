package com.sunzn.tangram.sample.bean;

import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.library.bean.TangramBean;

public class Base extends TangramBean {

    private Border border;

    public Base() {
    }

    public Base(Border border) {
        this.border = border;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

}
