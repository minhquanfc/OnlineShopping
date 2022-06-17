package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.DanhSachAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DanhSachActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    DanhSachAdapter danhSachAdapter;
    List<SanPham> sanPhamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        recyclerView =findViewById(R.id.rcview_list_sp);
        toolbar =findViewById(R.id.toolbar_sanpham);
        String type = getIntent().getStringExtra("type");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sanPhamList = new ArrayList<>();
        danhSachAdapter = new DanhSachAdapter(DanhSachActivity.this,sanPhamList);
        recyclerView.setAdapter(danhSachAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DanhSachActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        if (type !=null && type.equalsIgnoreCase("Điện thoại")){
            getDataDienthoai();
        }
        if (type !=null && type.equalsIgnoreCase("Máy tính")){
            getDataMayTinh();
        }
        if (type !=null && type.equalsIgnoreCase("Đồng hồ")){
            getDataDongHo();
        }
        if (type !=null && type.equalsIgnoreCase("Ipad")){
            getDataIpad();
        }
        if (type !=null && type.equalsIgnoreCase("Phụ kiện")){
            getDataPhuKien();
        }
    }

    private void getDataDienthoai() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getDienThoai();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    danhSachAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DanhSachActivity.this, "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getDataMayTinh() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getMayTinh();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    danhSachAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DanhSachActivity.this, "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getDataDongHo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getdongho();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    danhSachAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DanhSachActivity.this, "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getDataIpad() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getIpad();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    danhSachAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DanhSachActivity.this, "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getDataPhuKien() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getPhuKien();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPhamList.addAll(response.body());
                    danhSachAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DanhSachActivity.this, "Loi api", Toast.LENGTH_SHORT).show();
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