package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsResponse {

    @SerializedName("judul")
    @Expose
    public String judul;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("foto")
    @Expose
    public String foto;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
