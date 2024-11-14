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

public class NhanVienDTO {
    private String maNV;           // Mã Nhân Viên (Varchar)
    private String hoVaTen;        // Họ và Tên (Nvarchar)
    private Date ngaySinh;         // Ngày Sinh (Date)
    private String gioiTinh;       // Giới Tính (Nvarchar)
    private String soDienThoai;    // Số Điện Thoại (Varchar)
    private String email;          // Email (Nvarchar)
    private String diaChi;         // Địa Chỉ (Nvarchar)
    private String maTK;           // Mã Tài Khoản (Varchar)
    private String maVT;           // Mã Vị Trí (Varchar)
    private int trangThai;
    // Constructor
    public NhanVienDTO(String maNV, String hoVaTen, Date ngaySinh, String gioiTinh, String soDienThoai, String email, String diaChi, String maTK, String maVT,int trangThai) {
        this.maNV = maNV;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.maTK = maTK;
        this.maVT = maVT;
        this.trangThai=trangThai;
    }

    // Getters và Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getMaVT() {
        return maVT;
    }

    public void setMaVT(String maVT) {
        this.maVT = maVT;
    }
    
    public void setTrangThai(int trangThai)
    {
        this.trangThai=trangThai;
    }
    public int getTrangThai() {
        return trangThai;
    }
    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "NhanVienDTO{" +
               "maNV='" + maNV + '\'' +
               ", hoVaTen='" + hoVaTen + '\'' +
               ", ngaySinh=" + ngaySinh +
               ", gioiTinh='" + gioiTinh + '\'' +
               ", soDienThoai='" + soDienThoai + '\'' +
               ", email='" + email + '\'' +
               ", diaChi='" + diaChi + '\'' +
               ", maTK='" + maTK + '\'' +
               ", maVT='" + maVT + '\'' +
               '}';
    }
}

