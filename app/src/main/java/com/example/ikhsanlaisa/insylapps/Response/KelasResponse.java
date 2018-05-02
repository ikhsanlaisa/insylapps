package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KelasResponse extends BaseResponse{

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("nama_kelas")
    @Expose
    public String nama;

    @SerializedName("foto")
    @Expose
    public String foto;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
