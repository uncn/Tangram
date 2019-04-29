package com.sunzn.tangram.library.helper;

import com.sunzn.tangram.library.bean.Border;
import com.sunzn.tangram.library.bean.TangramBean;

import java.util.List;

public class TangramHelper {

    public static <R extends TangramBean, T extends R> void addTangramBean(List<R> beans, T bean) {
        if (beans != null && bean != null) {
            int lower = beans.size();
            int upper = beans.size() + 1;
            bean.setBorder(new Border(lower, upper, 0));
            beans.add(bean);
        }
    }

    public static <R extends TangramBean, T extends R> void addTangramBean(List<R> beans, List<T> data) {
        if (beans != null && data != null && data.size() > 0) {
            int lower = beans.size();
            int upper = beans.size() + data.size();
            for (int i = 0; i < data.size(); i++) {
                T bean = data.get(i);
                bean.setBorder(new Border(lower, upper, i));
                beans.add(bean);
            }
        }
    }

}
