package com.poly.onlineshopping.model;

public class Users {
    public String _id;
    public String ten;
    public String email;
    public String password;
    public String sodienthoai;
    public String diachi;
    public String token;

    public Users() {
    }

    public Users(String _id, String ten, String email, String password, String sodienthoai, String diachi, String token) {
        this._id = _id;
        this.ten = ten;
        this.email = email;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.token = token;
    }

    public Users(String _id ,String ten, String email, String password, String sodienthoai, String diachi) {
        this._id = _id;
        this.ten = ten;
        this.email = email;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
    }
    public Users(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public Users(String ten, String email, String sodienthoai, String diachi) {
        this.ten = ten;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
    }

    public Users(String id, String name, String email, String sdt, String diachi) {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}