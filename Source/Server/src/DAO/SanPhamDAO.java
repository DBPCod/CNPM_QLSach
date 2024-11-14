/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Base64;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class SanPhamDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<SanPhamDTO> getList()
    {
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        java.sql.Connection conn;
        conn = database.connect();
        String query="select * from sanpham";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String base64String="";
            while(rs.next())
            {
                String MaSP = rs.getString("MaSp");
                String tenSP = rs.getString("TenSP");
                int soTrang = rs.getInt("SoTrang");
                String ngonNgu = rs.getString("NgonNgu");
                Double giaBia = rs.getDouble("GiaBia");
                int soLuong = rs.getInt("SoLuong");
                Blob blob = rs.getBlob("AnhBia");
                byte[] imageBytes;
                if(blob==null)
                {
                    imageBytes=null;    
                }
                else
                {
                    imageBytes = blob.getBytes(1, (int) blob.length());
                    base64String = Base64.getEncoder().encodeToString(imageBytes);
                }
                
                Double giaNhap = rs.getDouble("GiaNhap");
                String maTG = rs.getString("MaTG");
                int trangThai = rs.getInt("TrangThai");
                list.add(new SanPhamDTO(MaSP,  tenSP,  soTrang,  ngonNgu,  giaBia, null, soLuong, giaNhap, maTG,trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public ArrayList<SanPhamDTO> getAnh()
    {
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        java.sql.Connection conn;
        conn = database.connect();
        String query="select MaSP,AnhBia from sanpham";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String base64String="";
            while(rs.next())
            {
                String MaSP = rs.getString("MaSP");
                Blob blob = rs.getBlob("AnhBia");
                byte[] imageBytes;
                if(blob==null)
                {
                    imageBytes=null;    
                }
                else
                {
                    imageBytes = blob.getBytes(1, (int) blob.length());
                    base64String = Base64.getEncoder().encodeToString(imageBytes);
                }
                list.add(new SanPhamDTO(MaSP,"",0, "", 0, base64String,0, 0, "",0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String themDT(SanPhamDTO sp)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO sanpham(MaSP,TenSP,SoTrang,NgonNgu,GiaBia,AnhBia,SoLuong,GiaNhap,MaTG,Trangthai) values(?,?,?,?,?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,sp.getMaSP());
            pstmt.setString(2,sp.getTenSP());
            pstmt.setInt(3,sp.getSoTrang());
            pstmt.setString(4,sp.getNgonNgu());
            pstmt.setDouble(5,sp.getGiaBia());
            //xem lai
            
            byte[] imageBytes = Base64.getDecoder().decode(sp.getAnhBia());
            pstmt.setBytes(6,imageBytes);
            pstmt.setInt(7,sp.getSoLuong());
            pstmt.setDouble(8,sp.getGiaNhap());
            pstmt.setString(9,sp.getMaTG());
            pstmt.setDouble(10,sp.getTrangThai());
            
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    
    //ham cap nhat doi tuong len csdl
    public String suaSP(String MaSP,Double GiaBia)
    {
        java.sql.Connection conn;
        String query = "UPDATE sanpham SET GiaBia=? WHERE MaSP=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1,GiaBia);
            pstmt.setString(2,MaSP);
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
    
    public String xoaSP(SanPhamDTO sp)
    {
        java.sql.Connection conn;
        String query = "UPDATE sanpham SET Trangthai=? WHERE MaSP=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,sp.getTrangThai());
            pstmt.setString(2,sp.getMaSP());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
}
