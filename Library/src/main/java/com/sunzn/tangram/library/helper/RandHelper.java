package com.sunzn.tangram.library.helper;

import java.util.Collections;
import java.util.List;

public class RandHelper {

    public static <T> List<T> create(List<T> data, int size) {
        if (data != null && data.size() > size) {
            Collections.shuffle(data);
            return data.subList(0, size);
        } else {
            return data;
        }
    }

}
