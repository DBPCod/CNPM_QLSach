/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class SanPhamDTO {
    private String maSP;          // Mã Sản Phẩm, khóa chính (Varchar)
    private String tenSP;         // Tên Sản Phẩm (Nvarchar)
    private int soTrang;          // Số trang (int)
    private String ngonNgu;       // Ngôn ngữ (Nvarchar)
    private double giaBia;        // Giá bìa (Double)
    private byte[] anhBia;        // Ảnh bìa (BLOB - Binary Large Object)
    private int soLuong;          // Số lượng (Int)
    private double giaNhap;       // Giá nhập (Double)
    private String maTG;          // Mã Tác Giả (Varchar)
    private int trangThai;
    // Constructor
    public SanPhamDTO(String maSP, String tenSP, int soTrang, String ngonNgu, double giaBia, byte[] anhBia, int soLuong, double giaNhap, String maTG,int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soTrang = soTrang;
        this.ngonNgu = ngonNgu;
        this.giaBia = giaBia;
        this.anhBia = anhBia;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.maTG = maTG;
        this.trangThai=trangThai;
    }

    // Getters và Setters
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public double getGiaBia() {
        return giaBia;
    }

    public void setGiaBia(double giaBia) {
        this.giaBia = giaBia;
    }

    public byte[] getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(byte[] anhBia) {
        this.anhBia = anhBia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
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
        return "SanPhamDTO{" +
               "maSP='" + maSP + '\'' +
               ", tenSP='" + tenSP + '\'' +
               ", soTrang=" + soTrang +
               ", ngonNgu='" + ngonNgu + '\'' +
               ", giaBia=" + giaBia +
               ", soLuong=" + soLuong +
               ", giaNhap=" + giaNhap +
               ", maTG='" + maTG + '\'' +
               '}';
    }
}

