package com.mallow.recyclerview;

import java.io.Serializable;

/**
 * Company: Mallow Technology
 * Created by bhagya on 03/01/17.
 */
public class News implements Serializable{
    private String title;
    private String desc;
    private int photoId;

    public News(String title, String desc, int photoId) {
        super();
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
