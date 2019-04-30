package com.sunzn.tangram.library.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Border implements Serializable, Parcelable {

    private int lower;

    private int upper;

    private int repos;

    public Border() {
    }

    public Border(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public Border(int lower, int upper, int repos) {
        this.lower = lower;
        this.upper = upper;
        this.repos = repos;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public int getRepos() {
        return repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public boolean isInRange(int position) {
        return position >= lower && position < upper;
    }

    private Border(Parcel in) {
        lower = in.readInt();
        upper = in.readInt();
        repos = in.readInt();
    }

    public static final Creator<Border> CREATOR = new Creator<Border>() {
        @Override
        public Border createFromParcel(Parcel in) {
            return new Border(in);
        }

        @Override
        public Border[] newArray(int size) {
            return new Border[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lower);
        dest.writeInt(upper);
        dest.writeInt(repos);
    }
}
