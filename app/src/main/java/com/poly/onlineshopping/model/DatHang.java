package com.poly.onlineshopping.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DatHang implements Serializable {

    @SerializedName("idUser")
    @Expose
    private String idUser;
    @SerializedName("hoten")
    @Expose
    private String hoten;
    @SerializedName("sodienthoai")
    @Expose
    private String sodienthoai;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("ngaymua")
    @Expose
    private String ngaymua;
    @SerializedName("tongtien")
    @Expose
    private Integer tongtien;
    @SerializedName("trangthai")
    @Expose
    private String trangthai;
    @SerializedName("products")
    @Expose
    private ArrayList<Product> products;
    @SerializedName("_id")
    @Expose
    private String id;

    public DatHang(String idUser, String hoten, String sodienthoai, String diachi, String ngaymua, Integer tongtien, String trangthai, ArrayList<Product> products, String id) {
        this.idUser = idUser;
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
        this.products = products;
        this.id = id;
    }

    public DatHang(String hoten, String sodienthoai, String diachi, String ngaymua, Integer tongtien, String trangthai, ArrayList<Product> products) {
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
        this.products = products;
    }

    public DatHang(String hoten, String sdt, String diachi, String ngaymua, int tongtien, String trangthai, Product product) {
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
        this.products = products;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public Integer getTongtien() {
        return tongtien;
    }

    public void setTongtien(Integer tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
