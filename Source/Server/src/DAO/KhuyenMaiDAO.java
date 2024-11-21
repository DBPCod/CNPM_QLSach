/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
/**
 *
 * @author PC
 */
public class KhuyenMaiDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<KhuyenMaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<KhuyenMaiDTO> list = new ArrayList<KhuyenMaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from khuyenmai";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaKM = rs.getString("MaKM");
                    String TenKM = rs.getString("TenKM");
                    Date NgayBatDau = rs.getDate("NgayBatDau");
                    Date NgayKetThuc = rs.getDate("NgayKetThuc");
                    String MaLKM = rs.getString("MaLoaiKM");
                    int Trangthai = rs.getInt("Trangthai");
                    int PhanTramGiam = rs.getInt("PhanTramGiam");
                    list.add(new KhuyenMaiDTO( MaKM,  TenKM,  NgayBatDau,  NgayKetThuc,  MaLKM, Trangthai,PhanTramGiam));
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    //ham them doi tuong vao csdl
    public String themDT(KhuyenMaiDTO km)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO khuyenmai(MaKM,TenKM,NgayBatDau,NgayKetThuc,MaLoaiKM,Trangthai,PhanTramGiam) values(?,?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,km.getMaKM());
            pstmt.setString(2,km.getTenKM());
            java.sql.Date NBD = new java.sql.Date(km.getNgayBatDau().getTime());
            java.sql.Date NKT = new java.sql.Date(km.getNgayKetThuc().getTime());
            pstmt.setDate(3,NBD);
            pstmt.setDate(4,NKT);
            pstmt.setString(5,km.getMaLoaiKM());
            pstmt.setInt(6,1);
            pstmt.setInt(7,km.getPhanTram());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
 
    
    public String xoaKM(KhuyenMaiDTO km)
    {
        java.sql.Connection conn;
        String query = "UPDATE khuyenmai SET Trangthai=? WHERE MaKM=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,km.getTrangThai());
            pstmt.setString(2,km.getMaKM());
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
