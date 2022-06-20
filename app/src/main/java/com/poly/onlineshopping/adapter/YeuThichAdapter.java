package com.poly.onlineshopping.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.ChiTietActivity;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.Product;
import com.poly.onlineshopping.model.SanPham;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichHolder> {
    Context context;
    List<SanPham> sanPhamList;
    int soluong = 1;
    int tongGia = 0;
    SanPham sanPham;
    Product product;

    public YeuThichAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public YeuThichHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_yeuthich, parent, false);
        return new YeuThichHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YeuThichHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.tv_ten_sp_yeuthich.setText(sanPham.getTensanpham());
        holder.tv_gia_sp_yeuthich.setText(String.valueOf(sanPham.getGiasanpham()));
        Glide.with(context).load(sanPham.getAnhsanpham()).into(holder.img_sp_yeuthich);
        holder.tv_ten_sp_yeuthich.setMaxLines(1);
        holder.tv_ten_sp_yeuthich.setEllipsize(TextUtils.TruncateAt.END);
        holder.btn_cong_sp_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soluong < 10) {
                    soluong++;
                    holder.tv_soluong_yeuthich.setText(String.valueOf(soluong));
                    tongGia = sanPham.getGiasanpham() * soluong;
                }
            }
        });
        holder.btn_tru_sp_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soluong > 1) {
                    soluong--;
                    holder.tv_soluong_yeuthich.setText(String.valueOf(soluong));
                    tongGia = sanPham.getGiasanpham() * soluong;
                }
            }
        });
        holder.btn_add_sp_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp1 = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
                String token = sp1.getString("token","");

                String productId = sanPham.getId();
                String ten = holder.tv_ten_sp_yeuthich.getText().toString();
                int gia = Integer.parseInt(holder.tv_gia_sp_yeuthich.getText().toString());
                String anh = sanPham.getAnhsanpham();
                int qty = Integer.parseInt(holder.tv_soluong_yeuthich.getText().toString());
                tongGia = sanPham.getGiasanpham() * soluong;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://adminshop68.herokuapp.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
//                products = new Products(productId,qty);
                product = new Product(productId,ten,gia,qty,anh,tongGia);
                Call<Product> call = apiService.postAddCart(token, product);
                call.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        if (response.isSuccessful())
                        {
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {

                    }
                });
            }
        });
    }



    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
}
