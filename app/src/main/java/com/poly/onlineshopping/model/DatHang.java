package com.poly.onlineshopping.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DatHang {

    @SerializedName("_id")
    @Expose
    public String id;
    public String idUser;
    public String hoTen;
    public String soDienthoai;
    public String diaChi;
    public String ngayMua;
    public int soLuong;
    public int tongTien;
    public String trangThai;
    public ArrayList<Product> products;

    public DatHang(String id, String idUser, String hoTen, String soDienthoai, String diaChi, String ngayMua, int soLuong, int tongTien, String trangThai, ArrayList<Product> products) {
        this.id = id;
        this.idUser = idUser;
        this.hoTen = hoTen;
        this.soDienthoai = soDienthoai;
        this.diaChi = diaChi;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.products = products;
    }

    public DatHang(String hoTen, String soDienthoai, String diaChi, String ngayMua, int soLuong, int tongTien, String trangThai, ArrayList<Product> products) {
        this.hoTen = hoTen;
        this.soDienthoai = soDienthoai;
        this.diaChi = diaChi;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.products = products;
    }

    public DatHang(String hoTen, String soDienthoai, String diaChi, String ngayMua, int soLuong, int tongTien, String trangThai) {
        this.hoTen = hoTen;
        this.soDienthoai = soDienthoai;
        this.diaChi = diaChi;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienthoai() {
        return soDienthoai;
    }

    public void setSoDienthoai(String soDienthoai) {
        this.soDienthoai = soDienthoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
