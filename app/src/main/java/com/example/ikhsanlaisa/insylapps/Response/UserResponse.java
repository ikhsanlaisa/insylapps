package com.example.ikhsanlaisa.insylapps.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Muh. Ikhsan L on 4/19/2018.
 */

public class UserResponse extends BaseResponse {
    @SerializedName("nama")
    @Expose
    public String nama;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("tgl_lahir")
    @Expose
    public String tgl_lahir;

    @SerializedName("no_hp")
    @Expose
    public String no_hp;

    @SerializedName("alamat")
    @Expose
    public String alamat;

    @SerializedName("foto")
    @Expose
    public String foto;

    @SerializedName("kelas_id")
    @Expose
    public int kelas_id;

    @SerializedName("tb_kelas")
    @Expose
    public KelasResponse kelas;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(int kelas_id) {
        this.kelas_id = kelas_id;
    }
}
