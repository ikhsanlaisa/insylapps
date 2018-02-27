package com.example.ikhsanlaisa.insylapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {
    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("user")
    @Expose
    public User user;

//    @SerializedName("photo")
//    @Expose
//    public Photo photo;
//
//    @SerializedName("photos")
//    @Expose
//    public List<Photo> photos = null;
}
