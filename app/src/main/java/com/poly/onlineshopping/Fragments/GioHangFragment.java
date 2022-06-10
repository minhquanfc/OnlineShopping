package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.poly.onlineshopping.R;

public class GioHangFragment extends Fragment {
    TextView tv1,tv2;
    Button btn1,btn2;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        tv1 = view.findViewById(R.id.tv_diachi);
        tv2 = view.findViewById(R.id.tv_Tongtien);
        btn1 = view.findViewById(R.id.btn_Thaydoi);
        btn2 = view.findViewById(R.id.btn_Thanhtoan);
        recyclerView = view.findViewById(R.id.rcview_GioHang);
        return view;    }
}