package com.poly.onlineshopping.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.DonHangActivity;
import com.poly.onlineshopping.activity.LoginActivity;
import com.poly.onlineshopping.activity.ProfileActivity;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TaiKhoanFragment extends Fragment {
    ImageView img_edit;
    TextView tv_name_user, tv_mail_user, tv_donhangcuatoi, tv_yeuthich, tv_caidat, tv_giohang, tv_danhgia, tv_gioithieu, tv_hotro, tv_dangxuat;
    View view;
    String token;
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
                getActivity().finishAffinity();
                Toast.makeText(getActivity(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });

        tv_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), YeuThichFragment.class);
//                startActivity(intent);
            }
        });
        tv_donhangcuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DonHangActivity.class);
                startActivity(intent);
            }
        });
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        getProfile();
        SharedPreferences sp1 = getContext().getApplicationContext().getSharedPreferences("Login", MODE_PRIVATE);
        token = sp1.getString("token","");
        return view;
    }

    private void getProfile() {
        SharedPreferences sp= getActivity().getSharedPreferences("User", MODE_PRIVATE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Users> call = apiService.getProfile(token);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    tv_name_user.setText(response.body().getTen());
                    tv_mail_user.setText(response.body().getEmail());
                    SharedPreferences.Editor Ed= sp.edit();
                    Ed.putString("id",response.body().get_id());
                    Log.d("aaa","id:"+response.body().get_id());
                }else {
//                    Toast.makeText(getContext(), "not connect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
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