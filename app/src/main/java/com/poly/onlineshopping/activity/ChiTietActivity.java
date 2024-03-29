package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.Product;
import com.poly.onlineshopping.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChiTietActivity extends AppCompatActivity {

    Button btn_add_giohang;
    TextView tv_gia_chitiet, tv_tensp_chitiet, tv_mota_chitiet, tv_soluong_sp;
    Toolbar toolbar;
    ImageView img_sanpham, back_chitiet, btn_cong_sp, btn_tru_sp;
    int soLuong = 1;
    int tonggia = 0;
    SanPham sanPham;
    DongHo dongHo;
    Product product;
    List<SanPham> sanPhamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        btn_add_giohang = findViewById(R.id.btn_add_giohang);
        tv_gia_chitiet = findViewById(R.id.tv_gia_chitiet);
        tv_tensp_chitiet = findViewById(R.id.tv_tensp_chitiet);
        tv_mota_chitiet = findViewById(R.id.tv_mota_chitiet);
        tv_soluong_sp = findViewById(R.id.tv_soluong_sp);
        btn_cong_sp = findViewById(R.id.btn_cong_sp);
        btn_tru_sp = findViewById(R.id.btn_tru_sp);
        img_sanpham = findViewById(R.id.img_sp_chitiet);
        sanPhamList = new ArrayList<>();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();

        btn_cong_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soLuong < 10) {
                    soLuong++;
                    tv_soluong_sp.setText(String.valueOf(soLuong));
                    tonggia = sanPham.getGiasanpham() * soLuong;
                }
            }
        });
        btn_tru_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soLuong > 1) {
                    soLuong--;
                    tv_soluong_sp.setText(String.valueOf(soLuong));
                }
            }
        });
        btn_add_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataGioHang();
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        final Object obj = getIntent().getSerializableExtra("chitiet");
//        sanPham = (SanPham) intent.getSerializableExtra("chitiet");
        if (obj instanceof SanPham) {
            sanPham = (SanPham) obj;
        }
        if (sanPham != null) {
            Glide.with(ChiTietActivity.this).load(sanPham.getAnhsanpham()).into(img_sanpham);
            tv_tensp_chitiet.setText(sanPham.getTensanpham());
            tv_gia_chitiet.setText(String.valueOf(sanPham.getGiasanpham()));
            tv_mota_chitiet.setText(sanPham.getMota());
        }
//        dongHo = (DongHo) intent.getSerializableExtra("chitiet");
        if (obj instanceof DongHo) {
            dongHo = (DongHo) obj;
        }
        if (dongHo != null) {
            Glide.with(ChiTietActivity.this).load(dongHo.getAnhsanpham()).into(img_sanpham);
            tv_tensp_chitiet.setText(dongHo.getTensanpham());
            tv_gia_chitiet.setText(String.valueOf(dongHo.getGiasanpham()));
            tv_mota_chitiet.setText(dongHo.getMota());
        }
    }
    String productId,ten,anh;
    int gia,qty;
    private void addDataGioHang() {
        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String token = sp1.getString("token","");
        if (sanPham !=null){
            productId = sanPham.getId();
            ten = tv_tensp_chitiet.getText().toString();
             gia = Integer.parseInt(tv_gia_chitiet.getText().toString());
             anh = sanPham.getAnhsanpham();
             qty = Integer.parseInt(tv_soluong_sp.getText().toString());
            tonggia = sanPham.getGiasanpham() * soLuong;
        } else {
             productId = dongHo.getId();
             ten = tv_tensp_chitiet.getText().toString();
             gia = Integer.parseInt(tv_gia_chitiet.getText().toString());
             anh = dongHo.getAnhsanpham();
             qty = Integer.parseInt(tv_soluong_sp.getText().toString());
            tonggia = dongHo.getGiasanpham() * soLuong;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
//                products = new Products(productId,qty);
        product = new Product(productId,ten,gia,qty,anh,tonggia);
        Log.e("aaa","giohang: "+tonggia);
        Call<Product> call = apiService.postAddCart(token, product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful())
                {
                    btn_add_giohang.setEnabled(false);
                    Toast.makeText(ChiTietActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}