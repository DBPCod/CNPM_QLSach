/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class NhanVienBLL {
    
    //ham lay danh sach nhan vien
    public String getList()
    {
        NhanVienDAO nvDAO = new NhanVienDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", nvDAO.getAll());
        return json.toString();
    }
    
    //lay nhan vien bang ma tai khoan
    public String getNV(String data)
    {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        NhanVienDAO nhanvien = new NhanVienDAO();
        for(NhanVienDTO x : nhanvien.getAll())
        {
            
            
            if(x.getMaTK().equals(json.getString("MaTK")))
            {
                json1.put("Trangthai","true");
                json1.put("MaNV",x.getMaNV());
                json1.put("Hovaten",x.getHoVaTen());
                json1.put("NgaySinh",x.getNgaySinh());
                json1.put("Gioitinh", x.getGioiTinh());
                json1.put("Sodienthoai", x.getSoDienThoai());
                json1.put("Email", x.getEmail());
                json1.put("Diachi",x.getDiaChi());
                json1.put("MaTK", x.getMaTK());
                json1.put("MaVT", x.getMaVT());
                return json1.toString();
            }
        }
        json1.put("Trangthai","false");
        return json1.toString();
    }
    
    public String getNhanVien(String MaNV) 
    {
        NhanVienDAO nvDAO = new NhanVienDAO();
        JSONObject json = new JSONObject();
        for (NhanVienDTO x : nvDAO.getAll())
        {
            if (x.getMaNV().equals(MaNV))
            {
                json.put("Trangthai", "true");
                json.put("MaNV", x.getMaNV());
                json.put("Hovaten", x.getHoVaTen());
                json.put("NgaySinh", x.getNgaySinh());
                json.put("GioiTinh", x.getGioiTinh());
                json.put("Sodienthoai", x.getSoDienThoai());
                json.put("Email", x.getEmail());
                json.put("DiaChi", x.getDiaChi());
                json.put("MaTK", x.getMaTK());
                json.put("MaVT", x.getMaVT());
                break;
            }
        }
        
        return json.toString();
    }
    
    // ham them nhan vien tra ve trang thai
    public String themNV(NhanVienDTO nv)
    {
        NhanVienDAO nvDAO = new NhanVienDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nvDAO.themNV(nv));
        return json.toString();
    }
    
    public String suaNV(NhanVienDTO nv)
    {
        NhanVienDAO nvDAO = new NhanVienDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nvDAO.suaNV(nv));
        return json.toString();
    }
    
    // ham xoa nxb va tra ve trang thai
    public String xoaNV(NhanVienDTO nv)
    {
        NhanVienDAO nvDAO = new NhanVienDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nvDAO.xoaNV(nv));
        return json.toString();
    }
//    
//    public static void main(String [] args)
//    {
//        NhanVienDAO nv = new NhanVienDAO();
//        for(NhanVienDTO nv1 : nv.getAll())
//        {
//            System.out.println(nv1.getMaNV());
//        }
//    }
}
