/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TheLoaiDTO;
import ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class TheLoaiDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<TheLoaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<TheLoaiDTO> list = new ArrayList<TheLoaiDTO>();
        try {
            conn = database.connect();
            String query = "select * from theloai";
            Statement stm = null;
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) 
            {
                String MaTL = rs.getString("MaTL");
                String TenTL = rs.getString("TenTL");
                int TrangThai = rs.getInt("Trangthai");
                list.add(new TheLoaiDTO(MaTL, TenTL, TrangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // ham them doi tuong vao csdl
    public String themTheLoai(TheLoaiDTO tl) 
    {
        java.sql.Connection conn;
        String query = "insert into theloai(MaTL,TenTL,TrangThai) values (?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, tl.getMaTL());
            pstmt.setString(2, tl.getTenTL());
            pstmt.setInt(3, 1);
            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    // ham cap nhat doi tuong vao csdl
    public String suaTheLoai(TheLoaiDTO tl) 
    {
        java.sql.Connection conn;
        String query = "update theloai set TenTL=? WHERE MaTL=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, tl.getTenTL());
            pstmt.setString(2, tl.getMaTL());

            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    // ham xoa doi tuong vao csdl
    public String xoaTheLoai(TheLoaiDTO tl) 
    {
        java.sql.Connection conn;
        String query = "update theloai set Trangthai=? where MaTL=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, tl.getTrangThai());
            pstmt.setString(2, tl.getMaTL());

            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
}
