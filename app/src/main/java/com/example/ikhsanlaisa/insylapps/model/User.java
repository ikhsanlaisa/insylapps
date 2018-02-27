package com.example.ikhsanlaisa.insylapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class User {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    @SerializedName("roles")
    @Expose
    public int roles;
}
