package com.sunzn.tangram.library.helper;

import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.library.bean.TangramBean;

import java.util.List;

public class TangramHelper {

    public static <R extends TangramBean, T extends R> void addTangramBean(List<R> beans, T bean) {
        if (beans != null && bean != null) {
            Border border = new Border(beans.size(), beans.size() + 1);
            bean.setBorder(border);
            beans.add(bean);
        }
    }

    public static <R extends TangramBean, T extends R> void addTangramBean(List<R> beans, List<T> data) {
        if (beans != null && data != null && data.size() > 0) {
            Border border = new Border(beans.size(), beans.size() + data.size());
            for (int i = 0; i < data.size(); i++) {
                T bean = data.get(i);
                bean.setBorder(border);
                beans.add(bean);
            }
        }
    }

}
