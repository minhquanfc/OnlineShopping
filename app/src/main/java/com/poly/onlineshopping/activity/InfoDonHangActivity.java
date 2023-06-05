package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DatHang;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoDonHangActivity extends AppCompatActivity {
    TextView tv_ten_nguoi_nhan,tv_sdt_donhang,tv_diachi_donhang,tv_soluong_donhang,tv_thanhtien_donhang,tv_trangthai_donhang,tv_time_donhang;
    RecyclerView rc_view_info_donhang;
    Toolbar toolbar;
    DatHang donHang;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_don_hang);
        toolbar = findViewById(R.id.toolbar_info_donhang);
        tv_ten_nguoi_nhan = findViewById(R.id.tv_ten_nguoi_nhan);
        tv_sdt_donhang = findViewById(R.id.tv_sdt_donhang);
        tv_diachi_donhang = findViewById(R.id.tv_diachi_donhang);
        tv_soluong_donhang = findViewById(R.id.tv_soluong_donhang);
        tv_thanhtien_donhang = findViewById(R.id.tv_thanhtien_donhang);
        tv_trangthai_donhang = findViewById(R.id.tv_trangthai_donhang);
        rc_view_info_donhang = findViewById(R.id.rc_view_info_donhang);
        tv_time_donhang = findViewById(R.id.tv_time_donhang);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //intent data donhang sang info don hang
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.e("aaa","id"+id);
//        getData();
//        if ( donHang != null) {
//            tv_ten_nguoi_nhan.setText(donHang.getHoTen());
//            tv_sdt_donhang.setText(donHang.getSoDienthoai());
//            tv_diachi_donhang.setText(donHang.getDiaChi());
//            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//            tv_thanhtien_donhang.setText(decimalFormat.format(donHang.getTongTien())+"đ");
//            tv_soluong_donhang.setText(String.valueOf(donHang.getSoLuong()));
//            tv_trangthai_donhang.setText(donHang.getTrangThai());
//            tv_time_donhang.setText(donHang.getNgayMua());
//        }
    }

    private void getData() {
        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token","");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/order/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<DatHang> call = apiService.getItemOrder("63216aae0532fab790a65b0a");
        call.enqueue(new Callback<DatHang>() {
            @Override
            public void onResponse(Call<DatHang> call, Response<DatHang> response) {
                if (response.isSuccessful()){
                    donHang = response.body();
                    tv_ten_nguoi_nhan.setText(donHang.getHoTen());
                    tv_sdt_donhang.setText(donHang.getSoDienthoai());
                    tv_diachi_donhang.setText(donHang.getDiaChi());
                    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                    tv_thanhtien_donhang.setText(decimalFormat.format(donHang.getTongTien())+"đ");
                    tv_soluong_donhang.setText(String.valueOf(donHang.getSoLuong()));
                    tv_trangthai_donhang.setText(donHang.getTrangThai());
                    tv_time_donhang.setText(donHang.getNgayMua());
                } else {
                    Toast.makeText(InfoDonHangActivity.this, "Loi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DatHang> call, Throwable t) {
                Toast.makeText(InfoDonHangActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
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