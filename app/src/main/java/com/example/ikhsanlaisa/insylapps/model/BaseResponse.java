package com.example.ikhsanlaisa.insylapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class BaseResponse {
    @SerializedName("error")
    @Expose
    public String error;

    @SerializedName("success")
    @Expose
    public boolean success;

}
