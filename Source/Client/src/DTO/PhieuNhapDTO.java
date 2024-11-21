/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
import java.util.Date;

public class PhieuNhapDTO {
    private String maPN;          // Mã Phiếu Nhập (Varchar)
    private Date ngayNhap;        // Ngày Nhập (Date)
    private double thanhTien;     // Thành Tiền (DOUBLE)
    private int trangThai;        // Trạng Thái (INT)
    private String maTK;          // Mã Tài Khoản (Varchar)
    private String maNXB;         // Mã Nhà Xuất Bản (Varchar)

    // Constructor
    public PhieuNhapDTO(String maPN, Date ngayNhap, double thanhTien, int trangThai, String maTK, String maNXB) {
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.maTK = maTK;
        this.maNXB = maNXB;
    }

    // Getters và Setters
    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "PhieuNhapDTO{" +
               "maPN='" + maPN + '\'' +
               ", ngayNhap=" + ngayNhap +
               ", thanhTien=" + thanhTien +
               ", trangThai=" + trangThai +
               ", maTK='" + maTK + '\'' +
               ", maNXB='" + maNXB + '\'' +
               '}';
    }
}

