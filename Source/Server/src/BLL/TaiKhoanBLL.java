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
import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
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

    public String login(String data) {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        String taikhoan = json.getString("taikhoan");
        String matkhau = json.getString("matkhau");
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        NhanVienDAO nvDAO = new NhanVienDAO();

        TaiKhoanDTO matchedTK = null;
        boolean isActive = false;

        // Kiểm tra thông tin đăng nhập
        for (TaiKhoanDTO x : tkDAO.getAll()) {
            if (x.getTenTK().equals(taikhoan) && x.getMatKhauTK().equals(matkhau)) {
                matchedTK = x;
                break;
            }
        }

        // Nếu tài khoản đúng, kiểm tra trạng thái
        if (matchedTK != null) {
            for (NhanVienDTO nv : nvDAO.getAll()) {
                if (nv.getMaTK().equals(matchedTK.getMaTK()) && nv.getTrangThai() == 1 && nv.getTrangThai()!=0) {
                    isActive = true;
                    break;
                }
            }
        }

        // Xử lý kết quả
        if (matchedTK != null && isActive) {
            json1.put("Trangthai", "true");
            json1.put("MaTK", matchedTK.getMaTK());
            return json1.toString(0);
        }

        if (matchedTK != null && !isActive) {
            json1.put("Trangthai", "false");
            json1.put("Thongbao", "Tài khoản đã bị vô hiệu hóa");
        } else {
            json1.put("Trangthai", "false");
            json1.put("Thongbao", "Tên tài khoản hoặc mật khẩu không chính xác");
        }
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
    
    //ham xoa tai khoan va tra ve trang thai
    public String xoaTK(TaiKhoanDTO tk)
    {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",tkDAO.xoaTK(tk));
        return json.toString();
    }
}
