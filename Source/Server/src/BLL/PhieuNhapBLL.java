/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.PhieuNhapDAO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class PhieuNhapBLL {
        //lay danh sach tac gia
    public String getList()
    {
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", pnDAO.getList());
        return json.toString();
    }
}
