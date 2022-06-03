package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.DanhMucAdapter;
import com.poly.onlineshopping.adapter.SanPhamAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.Banner;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    ImageSlider img_slide;
    AutoCompleteTextView ed_search;
    RecyclerView rcview_dienthoai,rcview_danhmuc;

    List<DanhMuc> danhMucList;
    List<SanPham> sanPhamList;
    List<Banner> bannerList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        img_slide = view.findViewById(R.id.img_slide);
        ed_search = view.findViewById(R.id.ed_search);
        rcview_dienthoai = view.findViewById(R.id.rcview_dienthoai);
        rcview_danhmuc = view.findViewById(R.id.rcview_danhmuc);
        danhMucList = new ArrayList<>();
        sanPhamList = new ArrayList<>();
        bannerList = new ArrayList<>();

        //SliderPhoto
        SliderPhoto();
        //danh muc
        GetDanhMuc();
        //san pham
        getSanPham();

        return view;
    }

    private void getSanPham() {

        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(getContext(),sanPhamList);
        rcview_dienthoai.setAdapter(sanPhamAdapter);
        LinearLayoutManager layoutManagerSanPham = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcview_dienthoai.setLayoutManager(layoutManagerSanPham);

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("http://192.168.1.243:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getSanPham();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() !=null)
                {
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
        danhMucList.add(new DanhMuc("Điện thoại","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/iphone-13-starlight-1-600x600.png?alt=media&token=52f21e27-4b21-4baa-8a1e-06cb6fbbe3fb","dienthoai"));
        danhMucList.add(new DanhMuc("Máy tính","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/laptop.png?alt=media&token=7bac408c-d3e8-4903-881e-28e06db55edf","maytinh"));
        danhMucList.add(new DanhMuc("Ipad","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/ipad.png?alt=media&token=0d578aed-ddb1-468c-8ea1-2929a26b3bb9","ipad"));
        danhMucList.add(new DanhMuc("Phụ kiện","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/keyboard.png?alt=media&token=01d0a517-a43b-40b2-8e2d-89583c520aa4","phukien"));
        danhMucList.add(new DanhMuc("Đồng hồ","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/smart-watch.png?alt=media&token=6b0c6cd9-94ef-410b-9f65-d4548b279c03","dongho"));

        DanhMucAdapter danhMucAdapter = new DanhMucAdapter(getContext(),danhMucList);
        rcview_danhmuc.setAdapter(danhMucAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcview_danhmuc.setLayoutManager(linearLayoutManager);
    }

    private void SliderPhoto() {
        List<SlideModel> banners = new ArrayList<SlideModel>();
        banners.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-179.png", ScaleTypes.FIT));
        banners.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/flip3-720-220-720x220.png", ScaleTypes.FIT));
        banners.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));
        banners.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));
        banners.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));

        img_slide.setImageList(banners,ScaleTypes.CENTER_CROP);
        img_slide.startSliding(3000);

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://192.168.1.243:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Banner>> call = apiService.getBanner();
        call.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                if (response.isSuccessful() && response.body() !=null)
                {

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