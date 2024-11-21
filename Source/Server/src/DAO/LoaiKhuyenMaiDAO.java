/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import ConnectDB.ConnectDB;
import DTO.LoaiKhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class LoaiKhuyenMaiDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<LoaiKhuyenMaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<LoaiKhuyenMaiDTO> list = new ArrayList<LoaiKhuyenMaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from loaikhuyenmai";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaLoaiKM = rs.getString("MaLoaiKM");
                    String TenLoaiKM = rs.getString("TenLoaiKM");
                    int PhanTramGiam = rs.getInt("PhanTramGiam");
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new LoaiKhuyenMaiDTO(MaLoaiKM,TenLoaiKM,PhanTramGiam,Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    public String themLKM(LoaiKhuyenMaiDTO lkm) 
    {
        java.sql.Connection conn;
        String query = "insert into loaikhuyenmai(MaLoaiKM,TenLoaiKM,Phantramgiam,Trangthai) values (?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, lkm.getMaLoaiKM());
            pstmt.setString(2, lkm.getTenLoaiKM());
            pstmt.setInt(3, lkm.getPhanTramGiam());
            pstmt.setInt(4, lkm.getTrangThai());
            
            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    //ham cap nhat doi tuong len csdl
    public String suaLKM(LoaiKhuyenMaiDTO lkm)
    {
        java.sql.Connection conn;
        String query = "UPDATE loaikhuyenmai SET TenLoaiKM=?,Phantramgiam=?,Trangthai=? WHERE MaLoaiKM=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,lkm.getTenLoaiKM());
            pstmt.setInt(2,lkm.getPhanTramGiam());
            pstmt.setInt(3,lkm.getTrangThai());
            pstmt.setString(4,lkm.getMaLoaiKM());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
    
    public String xoaLKM(LoaiKhuyenMaiDTO lkm)
    {
        java.sql.Connection conn;
        String query = "UPDATE loaikhuyenmai SET Trangthai=? WHERE MaLoaiKM=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,lkm.getTrangThai());
            pstmt.setString(2,lkm.getMaLoaiKM());
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
