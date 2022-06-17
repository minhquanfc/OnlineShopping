package com.poly.onlineshopping.api;

import com.poly.onlineshopping.model.Banner;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.GioHang;
import com.poly.onlineshopping.model.SanPham;
import com.poly.onlineshopping.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiService {
    @GET("getproduct")
    Call<List<SanPham>> getSanPham();
    @GET("getdienthoai")
    Call<List<SanPham>> getDienThoai();
    @GET("getdongho")
    Call<List<DongHo>> getDongho();
    @GET("getmaytinh")
    Call<List<SanPham>> getMayTinh();
    @GET("getdongho")
    Call<List<SanPham>> getdongho();
    @GET("getipad")
    Call<List<SanPham>> getIpad();
    @GET("getphukien")
    Call<List<SanPham>> getPhuKien();

    @POST("register")
    Call<Users> createPost(@Body Users users);
    @POST("login")
    Call<Users> postLogin(@Body Users users);

    @GET("getcategory")
    Call<List<DanhMuc>> getDanhmuc();
    @GET("getbanner")
    Call<List<Banner>> getBanner();

    @POST("giohang/themgiohang")
    Call<GioHang> postAddCart(@Header("Authorization") String authtoken,@Body GioHang gioHang);

    //get profile
    @GET("users/profile")
    Call<Users> getProfile(@Header("Authorization") String authtoken);
    @PUT("users/edits")
    Call<Users> postEditUser(@Header("Authorization") String authtoken,@Body Users users);
}
