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

public class HoaDonDTO {
    private String maHD;          // Mã Hóa Đơn (Varchar)
    private Date ngayLapHoaDon;   // Ngày Lập Hóa Đơn (Date)
    private double thanhTien;     // Thành Tiền (DOUBLE)
    private int trangThai;        // Trạng Thái (INT)
    private String maTK;          // Mã Tài Khoản (Varchar)

    // Constructor
    public HoaDonDTO(String maHD, Date ngayLapHoaDon, double thanhTien, int trangThai, String maTK) {
        this.maHD = maHD;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.maTK = maTK;
    }

    // Getters và Setters
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
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

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "HoaDonDTO{" +
               "maHD='" + maHD + '\'' +
               ", ngayLapHoaDon=" + ngayLapHoaDon +
               ", thanhTien=" + thanhTien +
               ", trangThai=" + trangThai +
               ", maTK='" + maTK + '\'' +
               '}';
    }
}

