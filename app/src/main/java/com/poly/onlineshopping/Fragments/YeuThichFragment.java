package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.YeuThichAdapter;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.DongHo;
import com.poly.onlineshopping.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YeuThichFragment extends Fragment {

    RecyclerView recyclerView;
    List<SanPham> sanPhamList;
    YeuThichAdapter yeuThichAdapter;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yeu_thich, container, false);
        recyclerView = view.findViewById(R.id.rc_view_yeuthich);
        progressBar = view.findViewById(R.id.progressbar_yeuthich);

        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
        getData();
        return view;
    }

    private void getData() {
        sanPhamList = new ArrayList<>();
        yeuThichAdapter = new YeuThichAdapter(getContext(),sanPhamList);
        recyclerView.setAdapter(yeuThichAdapter);
        LinearLayoutManager layoutManagerDongho = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManagerDongho);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SanPham>> call = apiService.getSanPham();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful()){
                    sanPhamList.addAll(response.body());
                    yeuThichAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi lấy dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}