package DAO;

import ConnectDB.ConnectDB;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class HoaDonDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<HoaDonDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        try {
            conn = database.connect();
            String query = "select * from hoadon";
            Statement stm = null;
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) 
            {
                String MaHD = rs.getString("MaHD");
                Date NgayLapHD = rs.getDate("Ngaylaphoadon");
                Double ThanhTien = rs.getDouble("ThanhTien");
                int TrangThai = rs.getInt("Trangthai");
                String MaTK = rs.getString("MaTK");
                list.add(new HoaDonDTO(MaHD, NgayLapHD, ThanhTien, TrangThai, MaTK));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //ham them doi tuong vao csdl
    public String themDT(HoaDonDTO hd)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO hoadon(MaHD,Ngaylaphoadon,ThanhTien,Trangthai,MaTK) values(?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,hd.getMaHD());
            java.sql.Date ngaynhap = new java.sql.Date(hd.getNgayLapHoaDon().getTime());
            pstmt.setDate(2,ngaynhap);
            pstmt.setDouble(3,hd.getThanhTien());
            pstmt.setInt(4,hd.getTrangThai());
            pstmt.setString(5,hd.getMaTK());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    public String xoaHD(HoaDonDTO hd)
    {
        java.sql.Connection conn;
        String query = "UPDATE hoadon SET Trangthai=? WHERE MaHD=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,hd.getTrangThai());
            pstmt.setString(2,hd.getMaHD());
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
