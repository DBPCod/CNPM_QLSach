/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TacGiaDAO;
import DTO.TacGiaDTO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class TacGiaBLL {
    //lay danh sach tac gia
    public String getList()
    {
        TacGiaDAO tgDAO = new TacGiaDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", tgDAO.getList());
        return json.toString();
    }
    
    //lay 1 tac gia 
    public String getTacGia(String MaTG)
    {
        TacGiaDAO tgDAO = new TacGiaDAO();
        JSONObject json = new JSONObject();
        for(TacGiaDTO x : tgDAO.getList())
        {
            if(x.getMaTG().equals(MaTG))
            {
                json.put("Trangthai","true");
                json.put("MaTG",x.getMaTG());
                json.put("Hovaten",x.getHoVaTen());
                json.put("ButDanh",x.getButDanh());
                json.put("GioiTinh", x.getGioiTinh());
                json.put("QuocTich", x.getQuocTich());
                break;
            }
        }
        return json.toString();
    }
    //ham them tac gia va tra ve trang thai
    public String themTG(TacGiaDTO tg)
    {
        TacGiaDAO tgDAO = new TacGiaDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tgDAO.themDT(tg));
        return json.toString();
    }
    
    //ham sua tac gia va tra ve trang thai
    public String suaTG(TacGiaDTO tg)
    {
        TacGiaDAO tgDAO = new TacGiaDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tgDAO.suaTG(tg));
        return json.toString();
    }
    
    //ham xoa tac gia va tra ve trang thai
    public String xoaTG(TacGiaDTO tg)
    {
        TacGiaDAO tgDAO = new TacGiaDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tgDAO.xoaTG(tg));
        return json.toString();
    }
}
