/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class PhieuNhapBLL {
        //lay danh sach phieu nhap
    public String getList()
    {
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", pnDAO.getList());
        return json.toString();
    }
    
    //ham them phieu nhap va tra ve trang thai
    public String themPN(PhieuNhapDTO pn)
    {
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",pnDAO.themDT(pn));
        return json.toString();
    }
    
    //ham xoa tac gia va tra ve trang thai
    public String xoaPN(PhieuNhapDTO pn)
    {
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",pnDAO.xoaPN(pn));
        return json.toString();
    }
}
