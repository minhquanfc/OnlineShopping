package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.DanhMucAdapter;
import com.poly.onlineshopping.adapter.SanPhamAdapter;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.SanPham;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ImageSlider img_slide;
    AutoCompleteTextView ed_search;
    RecyclerView rcview_dienthoai,rcview_danhmuc;

    List<DanhMuc> danhMucList;
    List<SanPham> sanPhamList;
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

        //SliderPhoto
        SliderPhoto();
        //danh muc
        GetDanhMuc();
        //san pham
        getSanPham();

        return view;
    }

    private void getSanPham() {
        sanPhamList.add(new SanPham("1","Iphone 13",686868,"iphone 13 2021","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/dienthoai%2Fsamsung-galaxy-z-flip-3-violet-1-600x600.jpg?alt=media&token=2c9ca89f-ad0a-4ee8-8dbe-850f1262fa3c","dienthoai"));
        sanPhamList.add(new SanPham("2","Iphone 13",686868,"iphone 13 2021","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/dienthoai%2Fsamsung-galaxy-z-flip-3-violet-1-600x600.jpg?alt=media&token=2c9ca89f-ad0a-4ee8-8dbe-850f1262fa3c","dienthoai"));
        sanPhamList.add(new SanPham("3","Iphone 13",686868,"iphone 13 2021","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/dienthoai%2Fsamsung-galaxy-z-flip-3-violet-1-600x600.jpg?alt=media&token=2c9ca89f-ad0a-4ee8-8dbe-850f1262fa3c","dienthoai"));
        sanPhamList.add(new SanPham("4","Iphone 13",686868,"iphone 13 2021","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/dienthoai%2Fsamsung-galaxy-z-flip-3-violet-1-600x600.jpg?alt=media&token=2c9ca89f-ad0a-4ee8-8dbe-850f1262fa3c","dienthoai"));
        sanPhamList.add(new SanPham("5","Iphone 13",686868,"iphone 13 2021","https://firebasestorage.googleapis.com/v0/b/onlineshop-1831d.appspot.com/o/dienthoai%2Fsamsung-galaxy-z-flip-3-violet-1-600x600.jpg?alt=media&token=2c9ca89f-ad0a-4ee8-8dbe-850f1262fa3c","dienthoai"));

        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(getContext(),sanPhamList);
        rcview_dienthoai.setAdapter(sanPhamAdapter);
        LinearLayoutManager layoutManagerSanPham = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcview_dienthoai.setLayoutManager(layoutManagerSanPham);
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
        List<SlideModel> slideModels = new ArrayList<SlideModel>();
        slideModels.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-179.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/flip3-720-220-720x220.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.tgdd.vn/2022/05/banner/720-220-720x220-157.png", ScaleTypes.FIT));

        img_slide.setImageList(slideModels,ScaleTypes.CENTER_CROP);
        img_slide.startSliding(3000);
    }
}