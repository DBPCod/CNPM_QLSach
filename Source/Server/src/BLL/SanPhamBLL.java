/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import ConnectDB.ConnectDB;
import DAO.SanPhamDAO;
import DAO.TacGiaDAO;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    //lay danh sach tac gia
    public String getList()
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
        json.put("list", spDAO.getList());
        return json.toString();
    }
    
    //lay du lieu de hien thi anh
    public String getAnhBia(String MaAB)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        spDAO.getAnh();
        JSONObject json = new JSONObject();
       json.put("Trangthai","true");
       for(SanPhamDTO x: spDAO.getAnh())
       {
           if(x.getMaSP().equals(MaAB))
           {
               json.put("anhbia", x.getAnhBia());
               break;
           }
       }
       return json.toString();
    }
    //lay 1 san pham
    public String getSanPham(String MaSP)
    {
         SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        for(SanPhamDTO  sp: spDAO.getList())
        {
            if(sp.getMaSP().equals(MaSP))    
            {
                json.put("Trangthai","true");
                json.put("MaSP", sp.getMaSP());
                json.put("TenSP",sp.getTenSP());
                json.put("SoTrang",sp.getSoTrang());
                json.put("NgonNgu",sp.getNgonNgu());
                json.put("GiaBia",sp.getGiaBia());
//                byte[] anhBia = sp.getAnhBia();
//                if (anhBia != null) {
//                    String anhBiaBase64 = Base64.getEncoder().encodeToString(anhBia);
//                    json.put("AnhBia", anhBiaBase64);
//                } else {
//                    json.put("AnhBia","null"); // Hoặc xử lý khác
//                    System.out.println("AnhBia is null for MaSP: " + MaSP);
//                }
//                String anhBiaBase64 = Base64.getEncoder().encodeToString(sp.getAnhBia());
//                json.put("AnhBia",anhBiaBase64);
                json.put("SoLuong",sp.getSoLuong());
                json.put("GiaNhap",sp.getGiaNhap());
                json.put("MaTG",sp.getMaTG());
//                json.put("Trangthai",sp.getTrangThai());
                break;
            }
        }
        
        return json.toString();
    }
    
    //ham them san pham
    public String themSP(SanPhamDTO sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",spDAO.themDT(sp));
        return json.toString();
    }
    
    public String suaSP(JSONObject sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("ketqua",spDAO.suaSP(sp.getString("MaSP"),Double.parseDouble(sp.getString("GiaBia"))));
        return json.toString();
    }
    
    public String xoaTheLoai(SanPhamDTO sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",spDAO.xoaSP(sp));
        return json.toString();
    }
}
