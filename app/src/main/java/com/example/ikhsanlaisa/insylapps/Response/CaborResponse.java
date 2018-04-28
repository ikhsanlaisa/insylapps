package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CaborResponse extends BaseResponse{
    @SerializedName("cabang_olahraga")
    @Expose
    public String cabor;

    @SerializedName("pj")
    @Expose
    public String pj;

    public String getCabor() {
        return cabor;
    }

    public void setCabor(String cabor) {
        this.cabor = cabor;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }
}
