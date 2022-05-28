package com.poly.onlineshopping.model;

public class DanhMuc {
    public String ten;
    public String anh;
    public String loai;

    public DanhMuc() {
    }

    public DanhMuc(String ten, String anh, String loai) {
        this.ten = ten;
        this.anh = anh;
        this.loai = loai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
