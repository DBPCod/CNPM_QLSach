/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import ConnectDB.ConnectDB;
import DAO.SanPhamDAO;
import DAO.TacGiaDAO;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    //lay danh sach tac gia
    public String getList()
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
        json.put("list", spDAO.getList());
        return json.toString();
    }
    
    //lay du lieu de hien thi anh
    public String getAnhBia(String MaAB)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
       json.put("Trangthai","true");
       for(SanPhamDTO x: spDAO.getAnh())
       {
           if(x.getMaSP().equals(MaAB))
           {
               json.put("anhbia", x.getAnhBia());
               break;
           }
       }
       return json.toString();
    }
    //lay 1 san pham
    public String getSanPham(String MaSP)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        for(SanPhamDTO  sp: spDAO.getList())
        {
            if(sp.getMaSP().equals(MaSP))    
            {
                json.put("Trangthai","true");
                json.put("MaSP", sp.getMaSP());
                json.put("TenSP",sp.getTenSP());
                json.put("SoTrang",sp.getSoTrang());
                json.put("NgonNgu",sp.getNgonNgu());
                json.put("GiaBia",sp.getGiaBia());
                json.put("SoLuong",sp.getSoLuong());
                json.put("GiaNhap",sp.getGiaNhap());
                json.put("MaTG",sp.getMaTG());
//                json.put("Trangthai",sp.getTrangThai());
                break;
            }
        }
        
        return json.toString();
    }
    
    //ham them san pham
    public String themSP(SanPhamDTO sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",spDAO.themDT(sp));
        return json.toString();
    }
    
    public String suaSP(JSONObject sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("ketqua",spDAO.suaSP(sp.getString("MaSP"),Double.parseDouble(sp.getString("GiaBia"))));
        return json.toString();
    }
    
    public String suaSLSP(JSONObject sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        String listString = sp.getString("list");
         JSONArray listArray = new JSONArray(listString);
         System.out.println(listArray.length());
         System.out.println(sp);
         String theloai = sp.getString("theloai");
         if(theloai.equals("hoadon"))
         {
             for (int i = 0; i < listArray.length(); i++) {
            // Mỗi phần tử trong listArray là một JSONArray con
                JSONArray tacGiaObject = listArray.getJSONArray(i);

                // Truy xuất thông tin sản phẩm từ mảng con
                String maSP = tacGiaObject.getString(0); // Mã sản phẩm
                String tenSP = tacGiaObject.getString(1); // Tên sản phẩm
                String soLuong = tacGiaObject.getString(2); // Số lượng
                String gia = tacGiaObject.getString(3); // Giá

                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                JSONObject sanPhamInfo = new JSONObject(getSanPham(maSP));

                // Cập nhật số lượng sản phẩm trong cơ sở dữ liệu
                int newQuantity = sanPhamInfo.getInt("SoLuong") - Integer.parseInt(soLuong);
                System.out.println(newQuantity);
                // Thực hiện cập nhật số lượng sản phẩm
                json.put("Trangthai", spDAO.suaSLSP(maSP, newQuantity));
            }
         }
         else
         {
             for (int i = 0; i < listArray.length(); i++) {
            // Mỗi phần tử trong listArray là một JSONArray con
                JSONArray tacGiaObject = listArray.getJSONArray(i);

                // Truy xuất thông tin sản phẩm từ mảng con
                String maSP = tacGiaObject.getString(0); // Mã sản phẩm
                String tenSP = tacGiaObject.getString(1); // Tên sản phẩm
                String soLuong = tacGiaObject.getString(2); // Số lượng
                String gia = tacGiaObject.getString(3); // Giá

                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                JSONObject sanPhamInfo = new JSONObject(getSanPham(maSP));

                // Cập nhật số lượng sản phẩm trong cơ sở dữ liệu
                int newQuantity = sanPhamInfo.getInt("SoLuong") + Integer.parseInt(soLuong);
                System.out.println(newQuantity);
                // Thực hiện cập nhật số lượng sản phẩm
                json.put("Trangthai", spDAO.suaSLSP(maSP, newQuantity));
            }
         }
         

        
        return json.toString();
    }
    
    public String suaHuySLSP(JSONObject sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        String listString = sp.getString("list");
         JSONArray listArray = new JSONArray(listString);
         String theloai = sp.getString("theloai");
         if(theloai.equals("phieunhap"))
         {
             for (int i = 0; i < listArray.length(); i++) {
            // Mỗi phần tử trong listArray là một JSONArray con
                JSONObject x = listArray.getJSONObject(i);
                // Truy xuất thông tin sản phẩm từ mảng con
                String maSP = x.getString("maSP"); // Mã sản phẩm
                int soLuong = x.getInt("soLuongNhap"); // Số lượng

                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                JSONObject sanPhamInfo = new JSONObject(getSanPham(maSP));

                // Cập nhật số lượng sản phẩm trong cơ sở dữ liệu
                int newQuantity = sanPhamInfo.getInt("SoLuong") - soLuong;
                System.out.println(newQuantity);
                // Thực hiện cập nhật số lượng sản phẩm
                json.put("Trangthai", spDAO.suaSLSP(maSP, newQuantity));
                
            }
         }
         else
         {
             for (int i = 0; i < listArray.length(); i++) {
            // Mỗi phần tử trong listArray là một JSONArray con
                JSONObject x = listArray.getJSONObject(i);
                // Truy xuất thông tin sản phẩm từ mảng con
                String maSP = x.getString("maSP"); // Mã sản phẩm
                int soLuong = x.getInt("soLuong"); // Số lượng

                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                JSONObject sanPhamInfo = new JSONObject(getSanPham(maSP));

                // Cập nhật số lượng sản phẩm trong cơ sở dữ liệu
                int newQuantity = sanPhamInfo.getInt("SoLuong") + soLuong;
                System.out.println(newQuantity);
                // Thực hiện cập nhật số lượng sản phẩm
                json.put("Trangthai", spDAO.suaSLSP(maSP, newQuantity));
            }
         }
         

        
        return json.toString();
    }
    
    public String xoaTheLoai(SanPhamDTO sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",spDAO.xoaSP(sp));
        return json.toString();
    }
    
    public static void main(String []args)
    {
        SanPhamBLL sp = new SanPhamBLL();
        System.out.println(sp.getAnhBia("SP_5"));
        System.out.println(sp.getSanPham("SP_5"));
    }
}
