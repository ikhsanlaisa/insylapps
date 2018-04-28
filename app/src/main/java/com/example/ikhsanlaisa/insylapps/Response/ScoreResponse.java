package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhsanlaisa on 26/03/18.
 */

public class ScoreResponse extends BaseResponse {

    @SerializedName("jadwal_id")
    @Expose
    public int jadwal;

    @SerializedName("cabor")
    @Expose
    public String cabor;

    @SerializedName("tim1")
    @Expose
    public String tim1;

    @SerializedName("tim2")
    @Expose
    public String tim2;

    @SerializedName("score")
    @Expose
    public String score;

    @SerializedName("lokasi")
    @Expose
    public String tempat;

    public String getCabor() {
        return cabor;
    }

    public void setCabor(String cabor) {
        this.cabor = cabor;
    }

    public int getJadwal() {
        return jadwal;
    }

    public void setJadwal(int jadwal) {
        this.jadwal = jadwal;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}
