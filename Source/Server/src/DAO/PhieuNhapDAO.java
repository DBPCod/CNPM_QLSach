/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author PC
 */
public class PhieuNhapDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<PhieuNhapDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<PhieuNhapDTO> list = new ArrayList<PhieuNhapDTO>();
        try {
                conn = database.connect();
                String query = "select * from phieunhap";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaPN = rs.getString("MaPN");
                    Date NgayNhap = rs.getDate("NgayNhap");
                    Double ThanhTien = rs.getDouble("ThanhTien");
                    int TrangThai = rs.getInt("Trangthai");
                    String MaTK = rs.getString("MaTK");
                    String MaNXB = rs.getString("MaNXB");
                    list.add(new PhieuNhapDTO(MaPN, NgayNhap, ThanhTien, TrangThai, MaTK, MaNXB));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    //ham them doi tuong vao csdl
    public String themDT(PhieuNhapDTO pn)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO phieunhap(MaPN,NgayNhap,Thanhtien,Trangthai,MaTK,MaNXB) values(?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,pn.getMaPN());
            java.sql.Date ngaynhap = new java.sql.Date(pn.getNgayNhap().getTime());
            pstmt.setDate(2,ngaynhap);
            pstmt.setDouble(3,pn.getThanhTien());
            pstmt.setInt(4,pn.getTrangThai());
            pstmt.setString(5,pn.getMaTK());
            pstmt.setString(6,pn.getMaNXB());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    public String xoaPN(PhieuNhapDTO pn)
    {
        java.sql.Connection conn;
        String query = "UPDATE phieunhap SET Trangthai=? WHERE MaPN=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,pn.getTrangThai());
            pstmt.setString(2,pn.getMaPN());
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
