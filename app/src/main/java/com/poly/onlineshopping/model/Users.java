package com.poly.onlineshopping.model;

public class Users {
    public String ten;
    public String email;
    public String password;
    public String sodienthoai;
    public String diachi;
    public String token;

    public Users() {
    }

    public Users(String ten, String email, String password, String sodienthoai, String diachi, String token) {
        this.ten = ten;
        this.email = email;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.token = token;
    }

    public Users(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public Users(String ten, String email, String password, String sodienthoai, String diachi) {
        this.ten = ten;
        this.email = email;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
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