/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class KhuyenMaiBLL {
       //lay danh sach tac gia
    public String getList()
    {
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", kmDAO.getList());
        return json.toString();
    }
    
    //ham them khuyen mai va tra ve trang thai
    public String themKM(KhuyenMaiDTO km)
    {
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",kmDAO.themDT(km));
        return json.toString();
    }
    
    //ham xoa khuyen mai va tra ve trang thai
    public String xoaKM(KhuyenMaiDTO km)
    {
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",kmDAO.xoaKM(km));
        return json.toString();
    }
}
