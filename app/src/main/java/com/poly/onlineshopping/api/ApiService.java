package com.poly.onlineshopping.api;

import com.poly.onlineshopping.model.Banner;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.SanPham;
import com.poly.onlineshopping.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("getproduct")
    Call<List<SanPham>> getSanPham();
    @GET("getdongho")
    Call<List<DongHo>> getDongho();
    @POST("register")
    Call<Users> createPost(@Body Users users);
    @POST("login")
    Call<Users> postLogin(@Body Users users);

    @GET("getcategory")
    Call<List<DanhMuc>> getDanhmuc();
    @GET("getbanner")
    Call<List<Banner>> getBanner();

    @POST("giohang/themgiohang")
    Call<SanPham> postAddCart(@Body SanPham sanPham);
}
