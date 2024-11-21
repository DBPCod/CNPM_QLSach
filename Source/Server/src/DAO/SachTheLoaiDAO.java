/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.SachTheLoaiDTO;
import DTO.SanPhamDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SachTheLoaiDAO {
     ConnectDB database = new ConnectDB();
     //ham lay danh sach the loai 
     public ArrayList<SachTheLoaiDTO> getAll()
    {
        java.sql.Connection conn;
        ArrayList<SachTheLoaiDTO> list = new ArrayList<SachTheLoaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from sachtheloai";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaSP = rs.getString("MaSP");
                    String MaTL = rs.getString("MaTL");
                    list.add(new SachTheLoaiDTO(MaSP,MaTL));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
     //ham them doi tuong
    public String themSTL(SachTheLoaiDTO stl)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO sachtheloai(MaSP,MaTL) values(?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,stl.getMaSP());
            pstmt.setString(2,stl.getMaTL());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
     
     //ham xoa doi tuong the loai de cap nhat the loai cho san pham
     public String xoaSTL(SachTheLoaiDTO stl)
     {
         java.sql.Connection conn;
        String query = "delete from sachtheloai where MaSP=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, stl.getMaSP());

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
