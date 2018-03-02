package com.example.ikhsanlaisa.insylapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhsanlaisa on 01/03/18.
 */

public class RegisterResponse<Data> extends BaseResponse {
    @SerializedName("nama")
    @Expose
    String nama;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("password")
    @Expose
    String password;
}
