package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisLombaResponse extends BaseResponse {

    @SerializedName("olahraga_id")
    @Expose
    Integer cabor;

    @SerializedName("file")
    @Expose
    String email;

    public Integer getCabor() {
        return cabor;
    }

    public void setCabor(Integer cabor) {
        this.cabor = cabor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
