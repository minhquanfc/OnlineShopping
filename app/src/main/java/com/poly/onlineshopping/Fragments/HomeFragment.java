package com.poly.onlineshopping.Fragments;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.BannerAdapter;
import com.poly.onlineshopping.adapter.DanhMucAdapter;
import com.poly.onlineshopping.adapter.DongHoAdapter;
import com.poly.onlineshopping.adapter.SanPhamAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.Banner;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.SanPham;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    SliderView img_slide;
    AutoCompleteTextView ed_search;
    RecyclerView rcview_dienthoai, rcview_danhmuc, rcview_dongho;

    List<DanhMuc> danhMucList;
    List<SanPham> sanPhamList;
    List<Banner> bannerList;
    List<DongHo> dongHoList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        img_slide = view.findViewById(R.id.img_slide);
        ed_search = view.findViewById(R.id.ed_search);
        rcview_dienthoai = view.findViewById(R.id.rcview_dienthoai);
        rcview_danhmuc = view.findViewById(R.id.rcview_danhmuc);
        rcview_dongho = view.findViewById(R.id.rcview_dongho);

        danhMucList = new ArrayList<>();
        sanPhamList = new ArrayList<>();
        bannerList = new ArrayList<>();
        dongHoList = new ArrayList<>();

        //SliderPhoto
        SliderPhoto();
        //danh muc
        GetDanhMuc();
        //san pham
        getSanPham();
        //get dong ho
        getDongho();

        return view;
    }

    private void getDongho() {
        DongHoAdapter dongHoAdapter = new DongHoAdapter(dongHoList,getContext());
        rcview_dongho.setAdapter(dongHoAdapter);
        LinearLayoutManager layoutManagerDongho = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcview_dongho.setLayoutManager(layoutManagerDongho);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<DongHo>> call = apiService.getDongho();
        call.enqueue(new Callback<List<DongHo>>() {
            @Override
            public void onResponse(Call<List<DongHo>> call, Response<List<DongHo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dongHoList.addAll(response.body());
                    dongHoAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DongHo>> call, Throwable t) {
                Toast.makeText(getContext(), "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getSanPham() {

        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(getContext(), sanPhamList);
        rcview_dienthoai.setAdapter(sanPhamAdapter);
        LinearLayoutManager layoutManagerSanPham = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcview_dienthoai.setLayoutManager(layoutManagerSanPham);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getSanPham();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    sanPhamAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(getContext(), "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetDanhMuc() {
        DanhMucAdapter danhMucAdapter = new DanhMucAdapter(getContext(), danhMucList);
        rcview_danhmuc.setAdapter(danhMucAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcview_danhmuc.setLayoutManager(linearLayoutManager);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<DanhMuc>> call = apiService.getDanhmuc();
        call.enqueue(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    danhMucList.addAll(response.body());
                    danhMucAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {

            }
        });
    }

    private void SliderPhoto() {
        BannerAdapter adapter = new BannerAdapter(bannerList,getContext());
        img_slide.setSliderAdapter(adapter);
        img_slide.setIndicatorAnimation(IndicatorAnimationType.WORM);
        img_slide.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        img_slide.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        img_slide.setIndicatorSelectedColor(Color.BLUE);
        img_slide.setIndicatorUnselectedColor(Color.WHITE);
        img_slide.setScrollTimeInSec(3); //set scroll delay in seconds :
        img_slide.startAutoCycle();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Banner>> call = apiService.getBanner();
        call.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bannerList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Không lấy được dữ liệu banner", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {

            }
        });
    }
}