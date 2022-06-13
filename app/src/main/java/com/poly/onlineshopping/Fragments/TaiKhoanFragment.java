package com.poly.onlineshopping.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.LoginActivity;


public class TaiKhoanFragment extends Fragment {
    ImageView img_edit;
    TextView tv_name_user, tv_mail_user, tv_donhangcuatoi, tv_yeuthich, tv_caidat, tv_giohang, tv_danhgia, tv_gioithieu, tv_hotro, tv_dangxuat;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        anhXa();

        tv_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });

        tv_yeuthich.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                YeuThichFragment Yeuthich = new YeuThichFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout, Yeuthich).commit();
            }


        });
        tv_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), GioHangFragment.class);
//                startActivity(intent);


                Fragment GioHang = new GioHangFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout, GioHang).commit();
            }
        });
        tv_hotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), HoTroActivity.class);
//                startActivity(intent);
            }
        });
        return view;

    }

    private void anhXa() {
        img_edit = view.findViewById(R.id.img_edit);
        tv_name_user = view.findViewById(R.id.tv_name_user);
        tv_mail_user = view.findViewById(R.id.tv_mail_user);
        tv_donhangcuatoi = view.findViewById(R.id.tv_donhangcuatoi);
        tv_yeuthich = view.findViewById(R.id.tv_yeuthich);
        tv_caidat = view.findViewById(R.id.tv_caidat);
        tv_giohang = view.findViewById(R.id.tv_giohang);
        tv_danhgia = view.findViewById(R.id.tv_danhgia);
        tv_gioithieu = view.findViewById(R.id.tv_gioithieu);
        tv_hotro = view.findViewById(R.id.tv_hotro);
        tv_dangxuat = view.findViewById(R.id.tv_dangxuat);
    }


}