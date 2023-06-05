package com.poly.onlineshopping.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.InfoDonHangActivity;
import com.poly.onlineshopping.model.DanhMuc;
import com.poly.onlineshopping.model.DatHang;

import java.text.DecimalFormat;
import java.util.List;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangHolder>{
    Context context;
    List<DatHang> datHangList;

    public DonHangAdapter(Context context, List<DatHang> datHangList) {
        this.context = context;
        this.datHangList = datHangList;
    }

    @NonNull
    @Override
    public DonHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_donhang,parent,false);
        return new DonHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonHangHolder holder, @SuppressLint("RecyclerView") int position) {
        DatHang donHang = datHangList.get(position);
        holder.tv_ten_donhang.setText("Mã đơn: "+donHang.getId());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tv_gia_donhang.setText("Thành tiền : "+decimalFormat.format(donHang.getTongTien()));
        holder.tv_soluong_donhang.setText(String.valueOf(donHang.getSoLuong())+" sản phẩm");
        holder.tv_trangthai.setText(donHang.getTrangThai());
//        Glide.with(context).load(gioHang.getAnh()).into(holder.img_sp_donhang);
        holder.click_donhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoDonHangActivity.class);
                intent.putExtra("id",donHang.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datHangList.size();
    }
}
