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

public class KhuyenMaiDTO {
    private String maKM;        // Mã Khuyến Mãi (Varchar)
    private String tenKM;       // Tên Khuyến Mãi (Nvarchar)
    private Date ngayBatDau;    // Ngày Bắt Đầu (Date)
    private Date ngayKetThuc;   // Ngày Kết Thúc (Date)
    private String maLoaiKM;    // Mã Loại Khuyến Mãi (Varchar)

    // Constructor
    public KhuyenMaiDTO(String maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc, String maLoaiKM) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maLoaiKM = maLoaiKM;
    }

    // Getters và Setters
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "KhuyenMaiDTO{" +
               "maKM='" + maKM + '\'' +
               ", tenKM='" + tenKM + '\'' +
               ", ngayBatDau=" + ngayBatDau +
               ", ngayKetThuc=" + ngayKetThuc +
               ", maLoaiKM='" + maLoaiKM + '\'' +
               '}';
    }
}

