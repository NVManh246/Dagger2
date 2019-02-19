package com.rikkei.dagger2.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int mId;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("email")
    private String mEmail;

    public User() {
    }

    public User(int id, String username, String email) {
        mId = id;
        mUsername = username;
        mEmail = email;
    }

    public int getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getEmail() {
        return mEmail;
    }
}
