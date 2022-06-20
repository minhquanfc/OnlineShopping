package com.poly.onlineshopping.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.ChiTietActivity;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DatHang;
import com.poly.onlineshopping.model.GioHang;
import com.poly.onlineshopping.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangHolder> {
    Context context;
    List<Product> productList;
    int tongtien = 0;
    String productId;
    Product product;


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
        product = productList.get(position);
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

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có muốn xóa không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        productId = product.getProductId();
                        SharedPreferences sp1 = context.getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
                        String token = sp1.getString("token", "");
                        Log.d("aaa","a"+productId);
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("https://adminshop68.herokuapp.com/api/giohang/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        ApiService apiService = retrofit.create(ApiService.class);
                        Product product1 = new Product(productId);
                        Call<Product> call = apiService.deleteCart(token,product1);
                        call.enqueue(new Callback<Product>() {
                            @Override
                            public void onResponse(Call<Product> call, Response<Product> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else {
                                    Toast.makeText(context, "Xóa thành không thành công", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Product> call, Throwable t) {

                            }
                        });
                        dialog.dismiss();
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
