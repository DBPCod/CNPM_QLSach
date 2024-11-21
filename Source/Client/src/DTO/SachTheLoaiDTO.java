/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class SachTheLoaiDTO {
    private String maSP;  // Mã Sản Phẩm (Varchar)
    private String maTL;  // Mã Thể Loại (Varchar)

    // Constructor
    public SachTheLoaiDTO(String maSP, String maTL) {
        this.maSP = maSP;
        this.maTL = maTL;
    }

    // Getters và Setters
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "SachTheLoaiDTO{" +
               "maSP='" + maSP + '\'' +
               ", maTL='" + maTL + '\'' +
               '}';
    }
}

