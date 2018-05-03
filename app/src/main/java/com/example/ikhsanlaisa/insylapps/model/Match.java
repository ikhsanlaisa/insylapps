package com.example.ikhsanlaisa.insylapps.model;

import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {
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
