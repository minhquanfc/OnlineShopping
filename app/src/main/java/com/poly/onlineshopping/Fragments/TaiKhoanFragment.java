package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.poly.onlineshopping.R;


public class TaiKhoanFragment extends Fragment {
    ImageView img;
    Button btnDonHang,btnYeuThich,btnCaiDat,btnGioiThieu,btnGioHang,btnDanhGia,btnHoTro,btnDangXuat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);

        img = view.findViewById(R.id.img1);
        btnDonHang = view.findViewById(R.id.btn_DonHang);
        btnYeuThich = view.findViewById(R.id.btn_YeuThich);
        btnCaiDat = view.findViewById(R.id.btn_Caidat);
        btnDanhGia = view.findViewById(R.id.btn_Danhgia);
        btnGioiThieu = view.findViewById(R.id.btn_Gioithieu);
        btnGioHang = view.findViewById(R.id.btn_GioHang);
        btnHoTro = view.findViewById(R.id.btn_Hotro);
        btnDangXuat = view.findViewById(R.id.btn_Dangxuat);
        return view;


    }



}