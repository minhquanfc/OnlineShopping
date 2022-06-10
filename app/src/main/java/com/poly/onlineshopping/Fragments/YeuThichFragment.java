package com.poly.onlineshopping.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.poly.onlineshopping.R;

public class YeuThichFragment extends Fragment {
    ImageView tru1,tru2,tru3,cong1,cong2,cong3;
    Button btn1,btn2,btn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yeu_thich, container, false);

        tru1 = view.findViewById(R.id.imgTru1);
        tru2 = view.findViewById(R.id.imgTru2);
        tru3 = view.findViewById(R.id.imgTru3);
        cong1 = view.findViewById(R.id.imgCong1);
        cong2 = view.findViewById(R.id.imgCong2);
        cong3 = view.findViewById(R.id.imgCong3);
        btn1 = view.findViewById(R.id.btn_ytThem1);
        btn2 = view.findViewById(R.id.btn_ytThem2);
        btn3 = view.findViewById(R.id.btn_ytThem3);


        return view;    }
}