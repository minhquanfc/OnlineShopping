package com.poly.onlineshopping.chucnangmanghinhtaikhoan;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class GioiThieuFragment extends Fragment {
//    SliderView sliderView;
//    int[] images = {R.drawable.anh7,
//            R.drawable.anh3,
//            R.drawable.anh8,
//            R.drawable.anh4,
//            R.drawable.anh5,
//            R.drawable.anh6,
//            R.drawable.anh1,
//            R.drawable.anh2};
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gioi_thieu, container, false);

//        sliderView = view.findViewById(R.id.img_slide);
//
//        SliderAdapter sliderAdapter = new SliderAdapter(images);
//
//        sliderView.setSliderAdapter(sliderAdapter);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
//        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
//        sliderView.startAutoCycle();
        return view;
    }
}