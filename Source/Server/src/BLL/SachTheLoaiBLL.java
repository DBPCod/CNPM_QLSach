/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SachTheLoaiDAO;
import DAO.TheLoaiDAO;
import DTO.SachTheLoaiDTO;
import DTO.TheLoaiDTO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class SachTheLoaiBLL {
    public String themSTL(SachTheLoaiDTO stl)
    {
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua", stlDAO.themSTL(stl));
        return json.toString();
    }
    
    //ham lay ma the loai
    public String getSachTheLoai(SachTheLoaiDTO stl)
    {
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        JSONObject json = new JSONObject();
        ArrayList<SachTheLoaiDTO> list = new ArrayList<SachTheLoaiDTO>();
        for(SachTheLoaiDTO tl : stlDAO.getAll())
        {   
            if(stl.getMaSP().equals(tl.getMaSP()))
            {
                json.put("Trangthai", "true");
                list.add(tl);
            }
 
        }
        JSONArray jsonArray = new JSONArray(list);
        String jsonString = jsonArray.toString();
        json.put("ketqua",jsonString);
        return json.toString();
    }
    
    public String getSachTenTheLoai(SachTheLoaiDTO stl)
    {
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        JSONObject json = new JSONObject();
        ArrayList<TheLoaiDTO> list = new ArrayList<TheLoaiDTO>();
        for(SachTheLoaiDTO tl : stlDAO.getAll())
        {   
            if(stl.getMaSP().equals(tl.getMaSP()))
            {
                json.put("Trangthai", "true");
                list.add(getTenTL(tl.getMaTL()));
            }
 
        }
        JSONArray jsonArray = new JSONArray(list);
        String jsonString = jsonArray.toString();
        json.put("ketqua",jsonString);
        return json.toString();
    }
    
    //ham xu li lay ten ma the loai cua san pham
    public TheLoaiDTO getTenTL(String MaTL)
    {
        System.out.println(MaTL);
        ArrayList<TheLoaiDTO> list = new ArrayList<TheLoaiDTO>();
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        for(TheLoaiDTO tl : tlDAO.getList())
        {
            
            if(MaTL.equals(tl.getMaTL()))
            {
                return new TheLoaiDTO(tl.getMaTL(),tl.getTenTL(),tl.getTrangThai());
            }
        }
        return null;
    }
    
    //ham xu li cap nhat the loai cho san pham
    public String updateSachTheLoai(JSONObject data)
    {
        String maSP = data.getString("MaSP");
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        stlDAO.xoaSTL(new SachTheLoaiDTO(maSP,""));
        JSONArray jsonArray = new JSONArray(data.getString("list"));
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String maTL = jsonObject.getString("maTL");
            json.put("ketqua", stlDAO.themSTL(new SachTheLoaiDTO(maSP,maTL)));
        }
        return json.toString();
    }
    
//    public static void main(String []args)
//    {
//        SachTheLoaiBLL bll = new SachTheLoaiBLL();
////        bll.getSachTenTheLoai(new );SachTheLoaiDTO("SP_10",""));
//        System.out.println(bll.getSachTenTheLoai(new SachTheLoaiDTO("SP_10","")));
//    }
}
