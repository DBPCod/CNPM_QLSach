/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class LoaiKhuyenMaiDTO {
    private String maLoaiKM;      // Mã Loại Khuyến Mãi (Varchar)
    private String tenLoaiKM;     // Tên Loại Khuyến Mãi (Nvarchar)
    private int phanTramGiam;     // Phần trăm giảm giá (INT)
    private int Trangthai;
    // Constructor
    public LoaiKhuyenMaiDTO(String maLoaiKM, String tenLoaiKM, int phanTramGiam,int Trangthai) {
        this.maLoaiKM = maLoaiKM;
        this.tenLoaiKM = tenLoaiKM;
        this.phanTramGiam = phanTramGiam;
        this.Trangthai = Trangthai;
    }

    // Getters và Setters
    public String getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    public String getTenLoaiKM() {
        return tenLoaiKM;
    }

    public void setTenLoaiKM(String tenLoaiKM) {
        this.tenLoaiKM = tenLoaiKM;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public int getTrangThai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }
    
    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "LoaiKhuyenMaiDTO{" +
               "maLoaiKM='" + maLoaiKM + '\'' +
               ", tenLoaiKM='" + tenLoaiKM + '\'' +
               ", phanTramGiam=" + phanTramGiam +
               '}';
    }
}

