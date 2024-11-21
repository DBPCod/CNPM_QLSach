/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.VaiTroDAO;
import DTO.VaiTroDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class VaiTroBLL {
    public String getVaiTro(String data)
    {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        VaiTroDAO vtDAO = new VaiTroDAO();
        for(VaiTroDTO x : vtDAO.getAll())
        {
            if(json.getString("MaVT").equals(x.getMaVT()))
            {
                json1.put("Trangthai","true");
                json1.put("MaVT",x.getMaVT());
                json1.put("TenVT",x.getTenVT());
                return json1.toString();
            }
        }
        json1.put("trangthai","false");
        return json1.toString(0);
    }
    
    public String getList()
    {
        VaiTroDAO vtDAO = new VaiTroDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", vtDAO.getAll());
        return json.toString();
    }
   
}
