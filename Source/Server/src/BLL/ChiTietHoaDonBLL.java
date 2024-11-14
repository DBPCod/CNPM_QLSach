/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class ChiTietHoaDonBLL {
    
    public String getList()
    {
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", cthdDAO.getList());
        return json.toString();
    }
    //ham them chi tiet phieu nhap va tra ve trang thai
    public String themCTHD(String list,String MaHD)
    {
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray(list);
//       MaSP,TenSP,value,GiaBia1
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i);

            String MaSP = innerArray.getString(0);
            int soLuong = innerArray.getInt(2);
            double donGia = innerArray.getDouble(3);
            json.put("ketqua",cthdDAO.themDT(new ChiTietHoaDonDTO(MaHD, soLuong, donGia, MaSP)));
        }
        json.put("Trangthai", "true");
        return json.toString();
    }
}
