/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class ChiTietPhieuNhapBLL {
    
    public String getList()
    {
        ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", ctpnDAO.getList());
        return json.toString();
    }
    
    //ham them chi tiet phieu nhap va tra ve trang thai
    public String themCTPN(String list,String maPN)
    {
        ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray(list);
//        MaSP,TenSP,value,GiaNhap1
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i);

            String MaSP = innerArray.getString(0);
            int soLuong = innerArray.getInt(2);
            double donGia = innerArray.getDouble(3) * soLuong;
            json.put("ketqua",ctpnDAO.themDT(new ChiTietPhieuNhapDTO(soLuong, donGia, MaSP, maPN)));
        }
        json.put("Trangthai", "true");
        return json.toString();
    }
}
