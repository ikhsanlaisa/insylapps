package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhsanlaisa on 26/03/18.
 */

public class MatchResponse extends BaseResponse {

    @SerializedName("date_time")
    @Expose
    public String date;

    @SerializedName("olahraga_id")
    @Expose
    public Integer cabor;

    @SerializedName("tim1")
    @Expose
    public Integer tim1;

    @SerializedName("tim2")
    @Expose
    public Integer tim2;

    @SerializedName("lokasi")
    @Expose
    public String tempat;

    @SerializedName("kelas")
    @Expose
    public KelasResponse kelas;

    public Integer getCabor() {
        return cabor;
    }

    public void setCabor(Integer cabor) {
        this.cabor = cabor;
    }

    public Integer getTim1() {
        return tim1;
    }

    public void setTim1(Integer tim1) {
        this.tim1 = tim1;
    }

    public Integer getTim2() {
        return tim2;
    }

    public void setTim2(Integer tim2) {
        this.tim2 = tim2;
    }

    public String getTempat() {
        return tempat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}
