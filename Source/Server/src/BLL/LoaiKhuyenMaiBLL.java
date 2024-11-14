/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.LoaiKhuyenMaiDAO;
import DTO.LoaiKhuyenMaiDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class LoaiKhuyenMaiBLL {
    //lay danh sach tac gia
    public String getList()
    {
        LoaiKhuyenMaiDAO lkmDAO = new LoaiKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
        json.put("list", lkmDAO.getList());
        return json.toString();
    }
    
    // ham them lkm va tra ve trang thai
    public String themLKM(LoaiKhuyenMaiDTO lkm)
    {
        LoaiKhuyenMaiDAO lkmDAO = new LoaiKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",lkmDAO.themLKM(lkm));
        return json.toString();
    }
    
    //ham sua loai khuyen mai va tra ve trang thai
    public String suaLKM(LoaiKhuyenMaiDTO lkm)
    {
        LoaiKhuyenMaiDAO lkmDAO = new LoaiKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",lkmDAO.suaLKM(lkm));
        return json.toString();
    }
    
    //ham sua loai khuyen mai va tra ve trang thai
    public String xoaLKM(LoaiKhuyenMaiDTO lkm)
    {
        LoaiKhuyenMaiDAO lkmDAO = new LoaiKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",lkmDAO.xoaLKM(lkm));
        return json.toString();
    }
}
