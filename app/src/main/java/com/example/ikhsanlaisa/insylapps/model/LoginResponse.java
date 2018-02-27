package com.example.ikhsanlaisa.insylapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhsanlaisa on 26/02/18.
 */

public class LoginResponse<D> extends BaseResponse {
    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("roles")
    @Expose
    public String roles;

    @SerializedName("data")
    @Expose
    public Data data;
}
