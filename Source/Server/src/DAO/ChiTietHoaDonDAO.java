/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietPhieuNhapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ChiTietHoaDonDAO {
    ConnectDB database = new ConnectDB();
    
    public ArrayList<ChiTietHoaDonDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<ChiTietHoaDonDTO>();
        try {
                conn = database.connect();
                String query = "select * from chitiethd";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaHD = rs.getString("MaHD");
                    int soluong = rs.getInt("Soluong");
                    double Dongia = rs.getDouble("DonGia");
                    String MaSP = rs.getString("MaSP");
                    list.add(new ChiTietHoaDonDTO(MaHD, soluong, Dongia, MaSP));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    public String themDT(ChiTietHoaDonDTO cthd)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO chitiethd(MaHD,Soluong,Dongia,MaSP) values(?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,cthd.getMaCTHD());
            pstmt.setInt(2,cthd.getSoLuong());
            pstmt.setDouble(3,cthd.getDonGia());
            pstmt.setString(4,cthd.getMaSP());
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
