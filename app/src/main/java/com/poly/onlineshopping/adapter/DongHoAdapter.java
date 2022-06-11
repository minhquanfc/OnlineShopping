package com.poly.onlineshopping.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.SanPham;

import java.util.List;

public class DongHoAdapter extends RecyclerView.Adapter<DongHoHolder> {
    List<DongHo> sanPhamList;
    Context context;

    public DongHoAdapter(List<DongHo> sanPhamList, Context context) {
        this.sanPhamList = sanPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public DongHoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanpham,parent,false);
        return new DongHoHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull DongHoHolder holder, int position) {
        DongHo sanPham = sanPhamList.get(position);
        holder.tv_ten_sanpham.setText(sanPham.getTensanpham());
        holder.tv_gia_sanpham.setText(String.valueOf(sanPham.getGiasanpham()));
        Glide.with(holder.img_sanpham).load(sanPham.getAnhsanpham()).into(holder.img_sanpham);

        //ten 1 dong
        holder.tv_ten_sanpham.setMaxLines(1);
        holder.tv_ten_sanpham.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
}
