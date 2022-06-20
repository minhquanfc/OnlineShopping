package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.model.DatHang;

import java.text.DecimalFormat;

public class InfoDonHangActivity extends AppCompatActivity {
    TextView tv_ten_nguoi_nhan,tv_sdt_donhang,tv_diachi_donhang,tv_soluong_donhang,tv_thanhtien_donhang,tv_trangthai_donhang,tv_time_donhang;
    RecyclerView rc_view_info_donhang;
    Toolbar toolbar;
    DatHang donHang;
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
        donHang = (DatHang) getIntent().getSerializableExtra("donhang");
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if ( donHang != null) {
            tv_ten_nguoi_nhan.setText(donHang.getHoten());
            tv_sdt_donhang.setText(donHang.getSodienthoai());
            tv_diachi_donhang.setText(donHang.getDiachi());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            tv_thanhtien_donhang.setText(decimalFormat.format(donHang.getTongtien())+"đ");
//            tv_soluong_donhang.setText(String.valueOf(donHang.getSoLuong()));
            tv_trangthai_donhang.setText(donHang.getTrangthai());
            tv_time_donhang.setText(donHang.getNgaymua());
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}