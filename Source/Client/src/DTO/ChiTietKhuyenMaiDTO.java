/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class ChiTietKhuyenMaiDTO {
    private String maKM;  // Mã Khuyến Mãi (Varchar)
    private String maSP;  // Mã Sản Phẩm (Varchar)

    // Constructor
    public ChiTietKhuyenMaiDTO(String maKM, String maSP) {
        this.maKM = maKM;
        this.maSP = maSP;
    }

    // Getters và Setters
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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
        return "ChiTietKhuyenMaiDTO{" +
               "maKM='" + maKM + '\'' +
               ", maSP='" + maSP + '\'' +
               '}';
    }
}

