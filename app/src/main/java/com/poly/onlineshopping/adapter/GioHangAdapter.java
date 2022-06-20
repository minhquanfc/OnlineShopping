package com.poly.onlineshopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.ChiTietActivity;
import com.poly.onlineshopping.model.Product;

import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangHolder> {
    Context context;
    List<Product> productList;
    int tongtien = 0;


    public GioHangAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public GioHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_giohang, parent, false);
        return new GioHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangHolder holder, int position) {
        Product product = productList.get(position);
        holder.tv_ten_sp_giohang.setText(product.getTensanpham());
        holder.tv_ten_sp_giohang.setText(product.getTensanpham());
        holder.tv_gia_sp_giohang.setText(String.valueOf(product.getGiasanpham()));
        holder.tv_soluong_giohang.setText(String.valueOf(product.getSoluong()));
        Glide.with(holder.img_sp_giohang.getContext()).load(product.getAnhsanpham()).into(holder.img_sp_giohang);

        tongtien = 0;
        for(int i = 0; i< productList.size(); i++)
        {
            tongtien += productList.get(i).getTongtien();
        }
        Intent intent = new Intent("Tongtien");
        intent.putExtra("tongtien", tongtien);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
