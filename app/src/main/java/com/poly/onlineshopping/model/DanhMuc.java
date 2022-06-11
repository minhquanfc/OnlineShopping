package com.poly.onlineshopping.model;

public class DanhMuc {
    public String ten;
    public String anh;

    public DanhMuc() {
    }

    public DanhMuc(String ten, String anh) {
        this.ten = ten;
        this.anh = anh;
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
}
