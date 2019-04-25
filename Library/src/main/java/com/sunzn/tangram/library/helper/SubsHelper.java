package com.sunzn.tangram.library.helper;

import java.util.List;

public class SubsHelper {

    public static <T> List<T> create(List<T> data, int size) {
        if (data != null && data.size() > size) {
            return data.subList(0, size);
        } else {
            return data;
        }
    }

}
