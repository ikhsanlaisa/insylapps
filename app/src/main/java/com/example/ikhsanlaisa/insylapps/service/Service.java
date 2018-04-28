package com.example.ikhsanlaisa.insylapps.service;

import com.example.ikhsanlaisa.insylapps.Response.CaborResponse;
import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.example.ikhsanlaisa.insylapps.Response.KontakResponse;
import com.example.ikhsanlaisa.insylapps.Response.MatchResponse;
import com.example.ikhsanlaisa.insylapps.Response.NewsResponse;
import com.example.ikhsanlaisa.insylapps.Response.RegisLombaResponse;
import com.example.ikhsanlaisa.insylapps.Response.ScoreResponse;
import com.example.ikhsanlaisa.insylapps.Response.UserResponse;
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.Response.LoginResponse;
import com.example.ikhsanlaisa.insylapps.Response.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface Service {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse<Data>> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse<Data>> register(@Field("nama") String nama, @Field("email") String email, @Field("password") String password);

    @GET("score")
    Call<List<ScoreResponse>> score();

    @GET("kontak")
    Call<List<KontakResponse>> kontak();

    @GET("user")
    Call<UserResponse> user();

    @GET("news")
    Call<List<NewsResponse>> news();

    @GET("jadwal")
    Call<List<MatchResponse>> match();

    @GET("kelas")
    Call<List<KelasResponse>> kelas();

    @GET("cabor")
    Call<List<CaborResponse>> cabor();

    @FormUrlEncoded
    @POST("regis")
    Call<RegisLombaResponse> regis(@Field("olahraga_id") Integer cabor_id);

    @FormUrlEncoded
    @POST("updateuser")
    Call<UserResponse> updateuser(@Field("nama") String nama, @Field("email") String email, @Field("tgl_lahir") String tgl_lahir, @Field("no_hp") String no_hp, @Field("alamat") String alamat, @Field("kelas_id") Integer foto);

    @FormUrlEncoded
    @POST("updateuser")
    Call<UserResponse> updatepassword(@Field("password") String password);
}
