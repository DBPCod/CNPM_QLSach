/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaXuatBanDTO;
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
public class NhaXuatBanDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<NhaXuatBanDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<NhaXuatBanDTO> list = new ArrayList<NhaXuatBanDTO>();
        try {
            conn = database.connect();
            String query = "select * from nhaxuatban";
            Statement stm = null;
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) 
            {
                String MaNXB = rs.getString("MaNXB");
                String TenNXB = rs.getString("TenNXB");
                String Diachi = rs.getString("Diachi");
                String Sodienthoai = rs.getString("Sodienthoai");
                String Email = rs.getString("Email");
                int TrangThai = rs.getInt("Trangthai");
                list.add(new NhaXuatBanDTO(MaNXB, TenNXB, Diachi, Sodienthoai, Email, TrangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    // ham them doi tuong vao csdl
    public String themNXB(NhaXuatBanDTO nxb) 
    {
        java.sql.Connection conn;
        String query = "insert into nhaxuatban(MaNXB,TenNXB,Diachi,Sodienthoai,Email,TrangThai) values (?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nxb.getMaNXB());
            pstmt.setString(2, nxb.getTenNXB());
            pstmt.setString(3, nxb.getDiaChi());
            pstmt.setString(4, nxb.getSoDienThoai());
            pstmt.setString(5, nxb.getEmail());
            pstmt.setInt(6, 1);
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
    public String suaNXB(NhaXuatBanDTO nxb) 
    {
        java.sql.Connection conn;
        String query = "update nhaxuatban set TenNXB=?,Diachi=?,Sodienthoai=?,Email=? WHERE MaNXB=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nxb.getTenNXB());
            pstmt.setString(2, nxb.getDiaChi());
            pstmt.setString(3, nxb.getSoDienThoai());
            pstmt.setString(4, nxb.getEmail());
            pstmt.setString(5, nxb.getMaNXB());

            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    // ham xoa doi tuong vao csdl
    public String xoaNXB(NhaXuatBanDTO nxb) 
    {
        java.sql.Connection conn;
        String query = "update nhaxuatban set Trangthai=? where MaNXB=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nxb.getTrangThai());
            pstmt.setString(2, nxb.getMaNXB());

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
