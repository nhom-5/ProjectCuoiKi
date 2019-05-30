package com.example.thanhnguyen.currencyconversion;

public class Object {
    int id;
    String ngay;
    String bmi;
    String ketqua;

    public Object(int id, String ngay, String bmi, String ketqua) {
        this.id = id;
        this.ngay = ngay;
        this.bmi = bmi;
        this.ketqua = ketqua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }
}
