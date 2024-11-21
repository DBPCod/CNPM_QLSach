/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class ChiTietHoaDonDTO {
    private String maCTHD;    // Mã Chi Tiết Hóa Đơn (Varchar)
    private int soLuong;      // Số Lượng (Int)
    private double donGia;    // Đơn Giá (DOUBLE)
    private String maSP;      // Mã Sản Phẩm (Varchar)

    // Constructor
    public ChiTietHoaDonDTO(String maCTHD, int soLuong, double donGia, String maSP) {
        this.maCTHD = maCTHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maSP = maSP;
    }

    // Getters và Setters
    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" +
               "maCTHD='" + maCTHD + '\'' +
               ", soLuong=" + soLuong +
               ", donGia=" + donGia +
               ", maSP='" + maSP + '\'' +
               '}';
    }
}

