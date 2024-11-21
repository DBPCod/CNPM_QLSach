/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class ChiTietPhieuNhapDTO {
    private int soLuongNhap;  // Số Lượng Nhập (Int)
    private double donGia;     // Đơn Giá (DOUBLE)
    private String maSP;       // Mã Sản Phẩm (Varchar)
    private String maPN;       // Mã Phiếu Nhập (Varchar)

    // Constructor
    public ChiTietPhieuNhapDTO(int soLuongNhap, double donGia, String maSP, String maPN) {
        this.soLuongNhap = soLuongNhap;
        this.donGia = donGia;
        this.maSP = maSP;
        this.maPN = maPN;
    }

    // Getters và Setters
    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
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

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "ChiTietPhieuNhapDTO{" +
               "soLuongNhap=" + soLuongNhap +
               ", donGia=" + donGia +
               ", maSP='" + maSP + '\'' +
               ", maPN='" + maPN + '\'' +
               '}';
    }
}

