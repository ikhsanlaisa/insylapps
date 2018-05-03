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
import com.example.ikhsanlaisa.insylapps.model.Match;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface Service {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse<Data>> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("refreshtoken")
    Call<LoginResponse<Data>> refresh();

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse<Data>> register(@Field("nama") String nama, @Field("email") String email,
                                          @Field("password") String password, @Field("kelas_id") int kelas_id);

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

    @Multipart
    @POST("updateuser")
    Call<UserResponse> updateuser(@Part("nama") RequestBody nama, @Part("email") RequestBody email, @Part("tgl_lahir") RequestBody tgl_lahir,
                                  @Part("no_hp") RequestBody no_hp, @Part("alamat") RequestBody alamat, @Part("kelas_id") RequestBody kelas,
                                  @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("updateuser")
    Call<UserResponse> updatepassword(@Field("password") String password);
}
