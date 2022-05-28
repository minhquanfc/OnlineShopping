package com.poly.onlineshopping.model;

public class SanPham {
    public String id;
    public String ten;
    public int gia;
    public String mota;
    public String img;
    public String loai;

    public SanPham() {
    }

    public SanPham(String id, String ten, int gia, String mota, String img, String loai) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
        this.img = img;
        this.loai = loai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
