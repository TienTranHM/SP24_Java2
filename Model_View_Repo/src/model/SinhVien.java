/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TienTHM_1
 */
public class SinhVien {
    private String MaSV;
    private String HoTen;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

}
