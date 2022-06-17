package com.poly.onlineshopping.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    public String _id;
    public String tensanpham;
    public int giasanpham;
    public String mota;
    public String anhsanpham;
    public String loai;

    public SanPham() {
    }

    public SanPham(String id, String tensanpham, int giasanpham, String mota, String anhsanpham, String loai) {
        this._id = id;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.mota = mota;
        this.anhsanpham = anhsanpham;
        this.loai = loai;
    }

    public SanPham(String id, String tensanpham, int giasanpham, String anhsanpham) {
        this._id = id;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.anhsanpham = anhsanpham;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
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