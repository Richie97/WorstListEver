package com.willowtree.worstlistviewever.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ericrichardson on 2/18/15.
 */
public class RedditData implements Parcelable {
    public String kind;
    public RedditData data;
    public ArrayList<RedditData> children;
    public String after;
    public String before;
    
    public String author;
    public String title;
    public String url;
    public String thumbnail;
    public String subreddit;
    public int ups;
    public int downs;
    @SerializedName("num_comments")
    public int commentCount;
    @SerializedName("is_self")
    public boolean isSelf;
    @SerializedName("selftext_html")
    public String selfTextHtml;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kind);
        dest.writeParcelable(this.data, flags);
        dest.writeSerializable(this.children);
        dest.writeString(this.after);
        dest.writeString(this.before);
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnail);
        dest.writeByte(isSelf ? (byte) 1 : (byte) 0);
        dest.writeString(this.selfTextHtml);
    }

    public RedditData() {
    }

    private RedditData(Parcel in) {
        this.kind = in.readString();
        this.data = in.readParcelable(RedditData.class.getClassLoader());
        this.children = (ArrayList<RedditData>) in.readSerializable();
        this.after = in.readString();
        this.before = in.readString();
        this.author = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.thumbnail = in.readString();
        this.isSelf = in.readByte() != 0;
        this.selfTextHtml = in.readString();
    }

    public static final Creator<RedditData> CREATOR = new Creator<RedditData>() {
        public RedditData createFromParcel(Parcel source) {
            return new RedditData(source);
        }

        public RedditData[] newArray(int size) {
            return new RedditData[size];
        }
    };
}
