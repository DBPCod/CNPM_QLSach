/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class VaiTroDTO {
    private String maVT;      // Mã Vai Trò (Varchar)
    private String tenVT;     // Tên Vai Trò (Nvarchar)

    // Constructor
    public VaiTroDTO(String maVT, String tenVT) {
        this.maVT = maVT;
        this.tenVT = tenVT;
    }

    // Getters và Setters
    public String getMaVT() {
        return maVT;
    }

    public void setMaVT(String maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "VaiTroDTO{" +
               "maVT='" + maVT + '\'' +
               ", tenVT='" + tenVT + '\'' +
               '}';
    }
}

