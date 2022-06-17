package com.poly.onlineshopping.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.DanhSachActivity;
import com.poly.onlineshopping.model.DanhMuc;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucHolder> {
    Context context;
    List<DanhMuc> danhMucList;

    public DanhMucAdapter(Context context, List<DanhMuc> danhMucList) {
        this.context = context;
        this.danhMucList = danhMucList;
    }

    @NonNull
    @Override
    public DanhMucHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_danhmuc,parent,false);
        return new DanhMucHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucHolder holder, @SuppressLint("RecyclerView") int position) {
        DanhMuc danhMuc = danhMucList.get(position);
        holder.tv_ten_danhmuc.setText(danhMuc.getTen());
        Glide.with(holder.img_danhmuc).load(danhMuc.getAnh()).into(holder.img_danhmuc);
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachActivity.class);
                intent.putExtra("type",danhMucList.get(position).getTen());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return danhMucList.size();
    }
}
