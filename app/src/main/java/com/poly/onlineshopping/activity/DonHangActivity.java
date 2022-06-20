package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.DonHangAdapter;
import com.poly.onlineshopping.adapter.GioHangAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DatHang;
import com.poly.onlineshopping.model.GioHang;
import com.poly.onlineshopping.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonHangActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<DatHang> datHangList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        toolbar = findViewById(R.id.toolbar_donhang);
        recyclerView = findViewById(R.id.rcview_list_donhang);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datHangList = new ArrayList<>();
        getData();

    }
    private void getData() {
        DonHangAdapter adapter = new DonHangAdapter(DonHangActivity.this,datHangList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManagerSanPham = new LinearLayoutManager(DonHangActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManagerSanPham);

        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token","");
//        Log.e("aaa","token: "+token);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/order/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<DatHang>> call = apiService.getOrder(token);
        call.enqueue(new Callback<List<DatHang>>() {
            @Override
            public void onResponse(Call<List<DatHang>> call, Response<List<DatHang>> response) {
                if (response.isSuccessful()){
                    datHangList.addAll(response.body());
                    Log.e("aaa","token: "+response.body());
//                    GioHang gioHang = response.body();
//                    List<DatHang> datas = gioHang.getProducts();
//                    for (Product data:datas){
//                        datHangList.add(data);
//                        adapter.notifyDataSetChanged();
//                    }
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<DatHang>> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}