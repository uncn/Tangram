package com.sunzn.tangram.library.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunzn on 2017/9/5.
 */

public class BaseViewBean implements Parcelable {

    protected BaseViewBean(Parcel in) {
        // TODO
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseViewBean> CREATOR = new Creator<BaseViewBean>() {
        @Override
        public BaseViewBean createFromParcel(Parcel in) {
            return new BaseViewBean(in);
        }

        @Override
        public BaseViewBean[] newArray(int size) {
            return new BaseViewBean[size];
        }
    };
    
}
