package com.poly.onlineshopping.api;

import com.poly.onlineshopping.model.Banner;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.DatHang;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.GioHang;
import com.poly.onlineshopping.model.Product;
import com.poly.onlineshopping.model.SanPham;
import com.poly.onlineshopping.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    Call<Product> postAddCart(@Header("Authorization") String authtoken, @Body Product product);

    //get profile
    @GET("users/profile")
    Call<Users> getProfile(@Header("Authorization") String authtoken);
    @PUT("users/edits")
    Call<Users> postEditUser(@Header("Authorization") String authtoken,@Body Users users);

    @GET("giohang/list")
    Call<GioHang> getCart(@Header("Authorization") String authtoken);

    @HTTP(method = "DELETE", path = "delete", hasBody = true)
    Call<Product> deleteCart(@Header("Authorization") String authtoken, @Body Product productId);

    @POST("add")
    Call<DatHang> postOrder(@Header("Authorization") String authtoken, @Body DatHang datHang);
    @DELETE("delete")
    Call<GioHang> delCart(@Header("Authorization") String authtoken);

    @GET("list")
    Call<List<DatHang>> getOrder(@Header("Authorization") String authtoken);

//    @GET("item")
//    Call<DatHang> getItemOrder(@Header("Authorization") String authtoken,@Query("_id") String id);
    @GET("item/{id}")
     Call<DatHang> getItemOrder( @Path("_id") String id);

}
