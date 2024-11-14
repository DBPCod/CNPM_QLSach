/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author PC
 */
import ConnectDB.ConnectDB;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TaiKhoanBLL {
    ConnectDB database = new ConnectDB();
    public String login(String data)
    {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        String taikhoan = json.getString("taikhoan");
        String matkhau = json.getString("matkhau");
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        for(TaiKhoanDTO x : tkDAO.getAll())
        {
            
            if(x.getTenTK().equals(taikhoan) && x.getMatKhauTK().equals(matkhau))
            {
                json1.put("Trangthai","true");
                json1.put("MaTK",x.getMaTK());
                
                return json1.toString(0);
            }
        }
        json1.put("trangthai","false");
        return json1.toString(0);
    }
    
    public String getList()
    {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", tkDAO.getList());
        return json.toString();
    }
    
    //lay 1 tai khoan 
    public String getTaiKhoan(String MaTK)
    {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        JSONObject json = new JSONObject();
        for(TaiKhoanDTO x : tkDAO.getList())
        {
            if(x.getMaTK().equals(MaTK))
            {
                json.put("Trangthai","true");
                json.put("MaTK",x.getMaTK());
                json.put("TenTK",x.getTenTK());
                json.put("MatkhauTK",x.getMatKhauTK());
                
                break;
            }
        }
        
        return json.toString();
    }
    
    public String themTK(TaiKhoanDTO tk)
    {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tkDAO.themTK(tk));
        return json.toString();
    }
    
    //ham sua tac gia va tra ve trang thai
    public String suaTK(TaiKhoanDTO tk)
    {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tkDAO.suaTK(tk));
        return json.toString();
    }
//    
//    //ham xoa tai khoan va tra ve trang thai
//    public String xoaTK(TaiKhoanDTO tk)
//    {
//        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
//        JSONObject json = new JSONObject();
//        json.put("Trangthai", "true");
//        json.put("ketqua",tkDAO.xoaTK(tk));
//        return json.toString();
//    }
}
