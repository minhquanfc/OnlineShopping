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
import com.poly.onlineshopping.model.SanPham;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamHolder> {
    Context context;
    List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public SanPhamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanpham,parent,false);
        return new SanPhamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
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
