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
    public CaborResponse cabor;

    @SerializedName("tim1")
    @Expose
    public KelasResponse tim1;

    @SerializedName("tim2")
    @Expose
    public KelasResponse tim2;

    @SerializedName("score")
    @Expose
    public String score;

    @SerializedName("lokasi")
    @Expose
    public String tempat;

    public int getJadwal() {
        return jadwal;
    }

    public void setJadwal(int jadwal) {
        this.jadwal = jadwal;
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
