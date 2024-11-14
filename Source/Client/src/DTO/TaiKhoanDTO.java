/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class TaiKhoanDTO {
    private String maTK;          // Mã Tài Khoản (Varchar)
    private String tenTK;         // Tên Tài Khoản (Nvarchar)
    private String matKhauTK;     // Mật Khẩu Tài Khoản (Nvarchar)
    private int trangThai;
    // Constructor
    public TaiKhoanDTO(String maTK, String tenTK, String matKhauTK,int trangThai) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.matKhauTK = matKhauTK;
        this.trangThai=trangThai;
    }

    // Getters và Setters
    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhauTK() {
        return matKhauTK;
    }

    public void setMatKhauTK(String matKhauTK) {
        this.matKhauTK = matKhauTK;
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
        return "TaiKhoanDTO{" +
               "maTK='" + maTK + '\'' +
               ", tenTK='" + tenTK + '\'' +
               ", matKhauTK='" + matKhauTK + '\'' +
               '}';
    }
}

