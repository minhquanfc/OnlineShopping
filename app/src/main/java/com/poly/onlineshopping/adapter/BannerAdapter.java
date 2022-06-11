package com.poly.onlineshopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.model.Banner;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class BannerAdapter extends SliderViewAdapter<BannerAdapter.Holder> {
    List<Banner> bannerList;
    Context context;

    public BannerAdapter(List<Banner> bannerList, Context context) {
        this.bannerList = bannerList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        Banner banner = bannerList.get(position);
        Glide.with(viewHolder.imageView).load(banner.getAnh()).into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return bannerList.size();
    }


    public class Holder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_banner);
        }
    }

}
