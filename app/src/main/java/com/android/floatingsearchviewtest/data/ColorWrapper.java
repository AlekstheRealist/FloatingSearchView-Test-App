package com.android.floatingsearchviewtest.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aleksreal7 on 1/19/17.
 */

public class ColorWrapper implements Parcelable {

    @SerializedName("hex")
    @Expose
    private String hex;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("rgb")
    @Expose
    private String rgb;

    private ColorWrapper(Parcel in) {
        hex = in.readString();
        name = in.readString();
        rgb = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hex);
        dest.writeString(name);
        dest.writeString(rgb);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public static final Creator<ColorWrapper> CREATOR = new Creator<ColorWrapper>() {
        @Override
        public ColorWrapper createFromParcel(Parcel in) {
            return new ColorWrapper(in);
        }

        @Override
        public ColorWrapper[] newArray(int size) {
            return new ColorWrapper[size];
        }
    };
}