package com.example.ikhsanlaisa.insylapps.model;

import com.example.ikhsanlaisa.insylapps.Response.ScoreResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {
    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("user")
    @Expose
    public User user;

//    @SerializedName("score")
//    @Expose
//    public ScoreResponse<D> scoreResponse;
//
//    @SerializedName("photos")
//    @Expose
//    public List<Photo> photos = null;
}
