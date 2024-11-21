package QL.SanPhamGUI;

import java.util.ArrayList;
import java.util.Date;

public class doiTuongGUI1 {
    private String tenSP;         // Tên Sản Phẩm (Nvarchar)
    private int soTrang;          // Số trang (int)
    private String ngonNgu;       // Ngôn ngữ (Nvarchar)
    private double giaBia;        // Giá bìa (Double)
    private byte[] anhBia;        // Ảnh bìa (BLOB - Binary Large Object)
    private double giaNhap;       // Giá nhập (Double)
    private String tenTG;         // Tên Tác Giả
    public ArrayList<Object[]> list; // Danh sách các đối tượng

    public doiTuongGUI1()
    {
        tenSP="";
        soTrang=0;
        ngonNgu="";
        giaBia=0;
        anhBia=null;
        giaNhap=0;
        tenTG="";
        list=new ArrayList<Object[]>();
    }
    // Constructor với tất cả thuộc tính
    public doiTuongGUI1(String tenSP, int soTrang, String ngonNgu, double giaBia, byte[] anhBia, double giaNhap, String tenTG,ArrayList<Object[]> list) {
        this.tenSP = tenSP;
        this.soTrang = soTrang;
        this.ngonNgu = ngonNgu;
        this.giaBia = giaBia;
        this.anhBia = anhBia;
        this.giaNhap = giaNhap;
        this.tenTG = tenTG;
        this.list = list; // Khởi tạo danh sách
    }

    // Getter và Setter cho tất cả thuộc tính

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

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }


    public ArrayList<Object[]> getList() {
        return list;
    }

    public void setList(ArrayList<Object[]> list) {
        this.list = list;
    }
}
