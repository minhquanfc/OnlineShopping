package com.poly.onlineshopping.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.LoadActivity;
import com.poly.onlineshopping.activity.ProfileActivity;
import com.poly.onlineshopping.adapter.GioHangAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DatHang;
import com.poly.onlineshopping.model.GioHang;
import com.poly.onlineshopping.model.Product;
import com.poly.onlineshopping.model.Users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GioHangFragment extends Fragment {

    RecyclerView recyclerView;
    TextView tv_thaydiachi, tv_tongtien, tv_diachi, tv_ten, tv_sdt;
    Button btn_thanhtoan;
    List<Product> productList;
    GioHangAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        recyclerView = view.findViewById(R.id.rc_view_giohang);
        tv_thaydiachi = view.findViewById(R.id.tv_thaydiachi);
        tv_tongtien = view.findViewById(R.id.tv_tongtien);
        btn_thanhtoan = view.findViewById(R.id.btn_thanhtoan);
        tv_diachi = view.findViewById(R.id.tv_diachi);
        tv_ten = view.findViewById(R.id.tv_ten);
        tv_sdt = view.findViewById(R.id.tv_sdt);
        productList = new ArrayList<>();


//        gioHangList.add(new GioHang("aaa","aaa",1000,1,1000));
//        gioHangList.add(new GioHang("aaa","aaa",1000,1,1000));
//        gioHangList.add(new GioHang("aaa","aaa",1000,1,1000));
//        gioHangList.add(new GioHang("aaa","aaa",1000,1,1000));

        getProfile();
        tv_thaydiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        getData();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, new IntentFilter("Tongtien"));

        if (productList == null){
            btn_thanhtoan.setEnabled(false);
            Toast.makeText(getContext(), "Vui lòng thêm", Toast.LENGTH_SHORT).show();
        }else {
            btn_thanhtoan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addDataOrder();
                }
            });
        }
        return view;
    }

    private void addDataOrder() {
        Date date = new Date(System.currentTimeMillis());
        String hoten = tv_ten.getText().toString();
        String sodienthoai = tv_sdt.getText().toString();
        Log.d("aaa", "a: " + sodienthoai);
        String diachi = tv_diachi.getText().toString();
        String trangthai = "Đang xử lý";
        String ngaymua = date.toString();
        int num = 0;
        for (Product product : productList) {
            num = num + product.getSoluong();
        }
        Log.d("aaa","aaa"+num);
        int tongtien = Integer.valueOf(tv_tongtien.getText().toString());
        for (Product product : productList) {

            SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
            String token = sp1.getString("token", "");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://adminshop68.herokuapp.com/api/order/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = retrofit.create(ApiService.class);

            DatHang datHang = new DatHang(hoten, sodienthoai, diachi, ngaymua,num, tongtien, trangthai);
            Call<DatHang> call = apiService.postOrder(token, datHang);
            call.enqueue(new Callback<DatHang>() {
                @Override
                public void onResponse(Call<DatHang> call, Response<DatHang> response) {
                    if (response.isSuccessful()) {
                        productList.clear();
                        adapter.notifyDataSetChanged();
                        Xoacart();
                        Intent intent = new Intent(getContext(), LoadActivity.class);
                        getContext().startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DatHang> call, Throwable t) {

                }
            });

        }
    }

    private void Xoacart() {
        SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token", "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/order/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<GioHang> call = apiService.delCart(token);
        call.enqueue(new Callback<GioHang>() {
            @Override
            public void onResponse(Call<GioHang> call, Response<GioHang> response) {

            }

            @Override
            public void onFailure(Call<GioHang> call, Throwable t) {

            }
        });
    }

    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onReceive(Context context, Intent intent) {
            int tongtien = intent.getIntExtra("tongtien", 0);
            tv_tongtien.setText(tongtien + "");
        }
    };

    private void getData() {
        adapter = new GioHangAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManagerSanPham = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManagerSanPham);

        SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token", "");
        Log.e("aaa", "token: " + token);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<GioHang> call = apiService.getCart(token);
        call.enqueue(new Callback<GioHang>() {
            @Override
            public void onResponse(Call<GioHang> call, Response<GioHang> response) {
                if (response.isSuccessful()) {
                    GioHang gioHang = response.body();
                    List<Product> datas = gioHang.getProducts();
                    for (Product data : datas) {
                        productList.add(data);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<GioHang> call, Throwable t) {

            }
        });
    }

    private void getProfile() {
        SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token", "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Users> call = apiService.getProfile(token);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    tv_ten.setText(response.body().getTen());
                    tv_sdt.setText(response.body().getSodienthoai());
                    tv_diachi.setText(response.body().getDiachi());
                } else {
                    Toast.makeText(getContext(), "not connect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }

}