package com.poly.onlineshopping.model;

import java.util.List;

public class Product {
    public String productId,tensanpham;
    public int giasanpham,soluong;
    public int tongtien;

    public Product() {
    }

    public Product(String productId, String tensanpham, int giasanpham, int soluong, int tongtien) {
        this.productId = productId;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}
