/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TheLoaiDAO;
import DTO.TheLoaiDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class TheLoaiBLL {
    // lay danh sach the loai
    public String getList()
    {
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("list", tlDAO.getList());
        return json.toString();
    }
    
    // lay 1 the loai
    public String getTheLoai(String MaTL) 
    {
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        JSONObject json = new JSONObject();
        for (TheLoaiDTO x : tlDAO.getList())
        {
            if (x.getMaTL().equals(MaTL))
            {
                json.put("Trangthai", "true");
                json.put("MaTL", x.getMaTL());
                json.put("TenTL", x.getTenTL());
                break;
            }
        }
        
        return json.toString();
    }  
    
    // ham them the loai va tra ve trang thai
    public String themTheLoai(TheLoaiDTO tl)
    {
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tlDAO.themTheLoai(tl));
        return json.toString();
    }
    
    // ham sua the loai va tra ve trang thai
    public String suaTheLoai(TheLoaiDTO tl)
    {
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tlDAO.suaTheLoai(tl));
        return json.toString();
    }
    
    // ham xoa the loai va tra ve trang thai
    public String xoaTheLoai(TheLoaiDTO tl)
    {
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tlDAO.xoaTheLoai(tl));
        return json.toString();
    }
}
