package com.example.ikhsanlaisa.insylapps.service;

import com.example.ikhsanlaisa.insylapps.Response.KontakResponse;
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
    Call<List<UserResponse>> user();


}
