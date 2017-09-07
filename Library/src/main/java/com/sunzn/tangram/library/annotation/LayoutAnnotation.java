package com.sunzn.tangram.library.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sunzn on 2017/9/5.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface LayoutAnnotation {

    int value() default 0;

}
