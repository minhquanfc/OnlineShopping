package com.poly.onlineshopping.model;

import java.io.Serializable;

public class DongHo implements Serializable {
    public String id;
    public String tensanpham;
    public int giasanpham;
    public String mota;
    public String anhsanpham;
    public String loai;

    public DongHo() {
    }

    public DongHo(String id, String tensanpham, int giasanpham, String mota, String anhsanpham, String loai) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.mota = mota;
        this.anhsanpham = anhsanpham;
        this.loai = loai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(int giasanpham) {
        this.giasanpham = giasanpham;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnhsanpham() {
        return anhsanpham;
    }

    public void setAnhsanpham(String anhsanpham) {
        this.anhsanpham = anhsanpham;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}