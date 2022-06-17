package com.poly.onlineshopping.model;

public class GioHang {
    public String idUser;
    public Products products;

    public GioHang() {
    }

    public GioHang(String idUser, Products products) {
        this.idUser = idUser;
        this.products = products;
    }

    public GioHang(Products products) {
        this.products = products;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
