package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lxl on 2017/3/29.
 */

public class News implements Parcelable {
    private String news_id;
    private String title;
    private String top_image;
    private String text_image0;
    private String text_image1;
    private String source;
    private String content;
    private String digest;
    private String reply_count;
    private String edit_time;


    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTop_image() {
        return top_image;
    }

    public void setTop_image(String top_image) {
        this.top_image = top_image;
    }

    public String getText_image0() {
        return text_image0;
    }

    public void setText_image0(String text_image0) {
        this.text_image0 = text_image0;
    }

    public String getText_image1() {
        return text_image1;
    }

    public void setText_image1(String text_image1) {
        this.text_image1 = text_image1;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getReply_count() {
        return reply_count;
    }

    public void setReply_count(String reply_count) {
        this.reply_count = reply_count;
    }

    public String getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(String edit_time) {
        this.edit_time = edit_time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.news_id);
        dest.writeString(this.title);
        dest.writeString(this.top_image);
        dest.writeString(this.text_image0);
        dest.writeString(this.text_image1);
        dest.writeString(this.source);
        dest.writeString(this.content);
        dest.writeString(this.digest);
        dest.writeString(this.reply_count);
        dest.writeString(this.edit_time);
    }

    public News() {
    }

    protected News(Parcel in) {
        this.news_id = in.readString();
        this.title = in.readString();
        this.top_image = in.readString();
        this.text_image0 = in.readString();
        this.text_image1 = in.readString();
        this.source = in.readString();
        this.content = in.readString();
        this.digest = in.readString();
        this.reply_count = in.readString();
        this.edit_time = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public String toString() {
        return "News{" +
                "news_id='" + news_id + '\'' +
                ", title='" + title + '\'' +
                ", top_image='" + top_image + '\'' +
                ", text_image0='" + text_image0 + '\'' +
                ", text_image1='" + text_image1 + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", digest='" + digest + '\'' +
                ", reply_count='" + reply_count + '\'' +
                ", edit_time='" + edit_time + '\'' +
                '}';
    }
}
