package com.codepath.apps.simpletwittes.models;

import com.google.gson.annotations.SerializedName;

public class User {

    private String name;
    @SerializedName("id_str")
    private long uid;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("profile_image_url")
    private String profileImageUrl;

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
