/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.ChiTietKhuyenMaiDAO;
import DAO.SanPhamDAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.SanPhamDTO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class ChiTietKhuyenMaiBLL {
    
        //lay danh sach khuyen mai
    public String getList()
    {
        ChiTietKhuyenMaiDAO kmDAO = new ChiTietKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", kmDAO.getList());
        return json.toString();
    }
    //ham them khuyen mai va tra ve trang thai
    public String themCTKM(String list,String maKM)
    {
        ChiTietKhuyenMaiDAO kmDAO = new ChiTietKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray(list);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i);

            String tenSach = innerArray.getString(0);
            int soLuong = innerArray.getInt(1);
            double gia = innerArray.getDouble(2);
            if(!getMaSP(tenSach).equals(""))
            {
                json.put("ketqua",kmDAO.themDT(new ChiTietKhuyenMaiDTO(maKM,getMaSP(tenSach))));
            }
        }
        json.put("Trangthai", "true");
        return json.toString();
    }
    
    private String getMaSP(String tensach)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        for(SanPhamDTO sp : spDAO.getList())
        {
            if(tensach.equals(sp.getTenSP()))
            {
                return sp.getMaSP();
            }
        }
        return "";
    }
}
