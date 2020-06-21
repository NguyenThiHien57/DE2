package com.example.de2;

public class KHModel {
    int ID;
    String tenKH,soLuong;
    String Nguon,Dich;

    public KHModel( String tenKH, String soLuong, String nguon, String dich) {
        this.tenKH = tenKH;
        this.soLuong = soLuong;
        this.Nguon = nguon;
        this.Dich = dich;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNguon() {
        return Nguon;
    }

    public void setNguon(String nguon) {
        Nguon = nguon;
    }

    public String getDich() {
        return Dich;
    }

    public void setDich(String dich) {
        Dich = dich;
    }
}
