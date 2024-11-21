/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class TacGiaDTO {
    private String maTG;        // Mã Tác Giả (Varchar)
    private String hoVaTen;     // Họ và tên (Nvarchar)
    private String butDanh;     // Bút danh (Nvarchar)
    private String gioiTinh;    // Giới tính (Nvarchar)
    private String quocTich;    // Quốc tịch (Nvarchar)
    private int trangThai;
    // Constructor
    public TacGiaDTO(String maTG, String hoVaTen, String butDanh, String gioiTinh, String quocTich,int trangThai) {
        this.maTG = maTG;
        this.hoVaTen = hoVaTen;
        this.butDanh = butDanh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.trangThai=trangThai;
    }

    // Getters và Setters
    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getButDanh() {
        return butDanh;
    }

    public void setButDanh(String butDanh) {
        this.butDanh = butDanh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
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
        return "TacGiaDTO{" +
               "maTG='" + maTG + '\'' +
               ", hoVaTen='" + hoVaTen + '\'' +
               ", butDanh='" + butDanh + '\'' +
               ", gioiTinh='" + gioiTinh + '\'' +
               ", quocTich='" + quocTich + '\'' +
               '}';
    }
}

