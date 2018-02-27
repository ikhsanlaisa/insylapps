package com.example.ikhsanlaisa.insylapps.service;

import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface Service {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse<Data>> login(@Field("email") String email, @Field("password") String password);

}
