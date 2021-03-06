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
    public String cabor;

    @SerializedName("tim1")
    @Expose
    public String tim1;

    @SerializedName("tim2")
    @Expose
    public String tim2;

    @SerializedName("lokasi")
    @Expose
    public String tempat;

    @SerializedName("kelas")
    @Expose
    public KelasResponse kelas;

    @SerializedName("kelas1")
    @Expose
    public KelasResponse kelas1;

    @SerializedName("cb_olahraga")
    @Expose
    public CaborResponse cabors;

    public String getCabor() {
        return cabor;
    }

    public void setCabor(String cabor) {
        this.cabor = cabor;
    }

    public String getTim1() {
        return tim1;
    }

    public void setTim1(String tim1) {
        this.tim1 = tim1;
    }

    public String getTim2() {
        return tim2;
    }

    public void setTim2(String tim2) {
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
