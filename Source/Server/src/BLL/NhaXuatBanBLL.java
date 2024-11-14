/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBanDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class NhaXuatBanBLL {
    // lay danh sach nxb
    public String getList()
    {
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("list", nxbDAO.getList());
        return json.toString();
    }
    
    
    // lay 1 nxb
    public String getNhaXuatBan(String MaNXB) 
    {
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        JSONObject json = new JSONObject();
        for (NhaXuatBanDTO x : nxbDAO.getList())
        {
            if (x.getMaNXB().equals(MaNXB))
            {
                json.put("Trangthai", "true");
                json.put("MaNXB", x.getMaNXB());
                json.put("TenNXB", x.getTenNXB());
                json.put("Diachi", x.getDiaChi());
                json.put("Sodienthoai", x.getSoDienThoai());
                json.put("Email", x.getEmail());
                break;
            }
        }
        
        return json.toString();
    }
    
    // ham them nxb va tra ve trang thai
    public String themNXB(NhaXuatBanDTO nxb)
    {
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nxbDAO.themNXB(nxb));
        return json.toString();
    }

    // ham sua nxb va tra ve trang thai
    public String suaNXB(NhaXuatBanDTO nxb)
    {
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nxbDAO.suaNXB(nxb));
        return json.toString();
    }
    
    // ham xoa nxb va tra ve trang thai
    public String xoaNXB(NhaXuatBanDTO nxb)
    {
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",nxbDAO.xoaNXB(nxb));
        return json.toString();
    }
}
