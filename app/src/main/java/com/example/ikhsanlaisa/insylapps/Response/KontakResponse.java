package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhsanlaisa on 27/03/18.
 */

public class KontakResponse extends BaseResponse {
    @SerializedName("nama")
    @Expose
    public String nama;

    @SerializedName("no_telp")
    @Expose
    public String no_telp;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("foto")
    @Expose
    public String foto;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
